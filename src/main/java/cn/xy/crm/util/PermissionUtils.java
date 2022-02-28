package cn.xy.crm.util;

import cn.xy.crm.domain.Employee;
import cn.xy.crm.domain.Menu;
import cn.xy.crm.domain.Permission;
import cn.xy.crm.service.IPermissionService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 提供权限认证的方法
 *
 * @author z-xy
 * @version v1.0
 * @date created in 2022-01-11 21:20
 */
@Component
public class PermissionUtils {
    private static IPermissionService permissionService;

    /**
     * 注入permissionService
     *
     * @param permissionService 权限业务对象
     */
    @Autowired
    public void setPermissionService(IPermissionService permissionService) {
        PermissionUtils.permissionService = permissionService;
    }

    /**
     * 权限校验,拥有该权限或者无需校验的请求返回true
     * <p>
     * 管理员理应拥有的所有的权限，可以直接放行；只有访问的请求需要权限校验，才会进行判断，ALL权限是一模块的所有权限，在排除单个权限后进行ALL
     * 的校验。
     * <p>
     * 需要校验的请求可以每次都从数据库中查询，也可以在登录时查询当前用户的所有权限保存到session中，这样需要校验时从session中取值，这样就减少了频繁的数据库读写，
     * 但是也会出现数据的更新不及时。
     *
     * @param function 处理请求路径的权限表达式
     * @return 是否拥有该访问权限
     */
    public static boolean checkPermission(String function) {
        // 管理员放行
        Employee employee = (Employee) UserContext.get().getSession().getAttribute(UserContext.USER_IN_SESSION);
        if (employee.getAdmin()) {
            return true;
        }
        // 第一次校验请求时保存系统的所有权限列表到session中
        if (CommonUtils.ALL_PERMISSIONS.size() == 0) {
            List<Permission> permissionList = permissionService.selectAll();
            for (Permission permission : permissionList) {
                CommonUtils.ALL_PERMISSIONS.add(permission.getResource());
            }
        }
        // 该条请求是权限路径
        if (CommonUtils.ALL_PERMISSIONS.contains(function)) {
            // 当前用户的权限路径保存在session中
            @SuppressWarnings("unchecked")
            List<String> resources =
                    (List<String>) UserContext.get().getSession().getAttribute(UserContext.PERMISSION_IN_SESSION);
            // 用户是否拥有该权限
            String all = function.split(":")[0] + ":ALL";
            return resources.contains(function) || resources.contains(all);
        } else {
            // 不是权限路径，无需校验
            return true;
        }
    }

    /**
     * 用户的功能菜单显示
     * <p>
     * 本方法一级菜单没有处理
     *
     * @param menus 当前系统的所有一级菜单
     */
    public static void checkMenus(List<Menu> menus) {
        // 管理员无需校验
        Employee current = (Employee) UserContext.get().getSession().getAttribute(UserContext.USER_IN_SESSION);
        if (current.getAdmin()) {
            return;
        }
        // 查询当前用户的所有权限
        @SuppressWarnings("unchecked")
        List<String> resources =
                (List<String>) UserContext.get().getSession().getAttribute(UserContext.PERMISSION_IN_SESSION);
        Menu menu = null;
        for (int i = menus.size() - 1; i >= 0; i--) {
            menu = menus.get(i);
            if (StringUtils.isNotBlank(menu.getFunction())) {
                String function = menu.getFunction();
                String allFunction = function.substring(0, function.lastIndexOf(":") + 1) + "ALL";
                // 当前员工没有该权限且没有all权限，移除
                if (!resources.contains(function) && !resources.contains(allFunction)) {
                    menus.remove(i);
                }
            }

            // function为null，说明所有用户都可以访问
            if (menu.getChildren() != null && menu.getChildren().size() > 0) {
                checkMenus(menu.getChildren());
            }
        }
    }
}
