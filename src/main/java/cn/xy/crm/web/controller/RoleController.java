package cn.xy.crm.web.controller;

import cn.xy.crm.domain.Role;
import cn.xy.crm.page.AjaxResult;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.RoleQueryObject;
import cn.xy.crm.service.IPermissionService;
import cn.xy.crm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author z-xy
 * @version v1.0
 * @date created in 2021-12-23 15:46
 */
@Controller
public class RoleController {
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IPermissionService permissionService;

    /**
     * 定位到role.jsp
     *
     * @return
     */
    @RequestMapping("/role")
    public String index() {
        return "/role";
    }

    @RequestMapping("/role_save")
    @ResponseBody
    public AjaxResult save(Role role) {
        AjaxResult ajaxResult = null;
        try {
            int result = roleService.save(role);
            if (result > 0) {
                ajaxResult = new AjaxResult(true, "添加成功");
            } else {
                ajaxResult = new AjaxResult(false, "添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult = new AjaxResult("保存异常");
        }
        return ajaxResult;
    }

    /**
     * 显示用户的角色列表
     *
     * @param qo
     * @return
     */
    @RequestMapping("/role_list")
    @ResponseBody
    public PageResult list(RoleQueryObject qo) {
        return roleService.queryRoleForPage(qo);
    }

    /**
     * 显示角色对应的权限列表
     *
     * @param id
     * @return
     */
    @RequestMapping("/permission_queryByRid")
    @ResponseBody
    public PageResult showPermissionsOfRole(Long id) {
        return permissionService.queryPermissionsByRid(id);
    }

    /**
     * 修改角色信息
     */
    @RequestMapping("/role_edit")
    @ResponseBody
    public AjaxResult edit(Role role) {
        AjaxResult result = null;
        try {
            int effect = roleService.modifyRoleInfo(role);
            if (effect > 0) {
                result = new AjaxResult(true, "角色信息修改成功");
            } else {
                result = new AjaxResult("修改角色信息失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("操作异常");
        }
        return result;
    }

    @RequestMapping("/role_queryRoleForEmp")
    @ResponseBody
    public List<Role> queryRoleForEmp() {
        return roleService.queryRoleForEmp();
    }

    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    @RequestMapping("/role_delete")
    @ResponseBody
    public AjaxResult delete(Long id) {
        AjaxResult ajaxResult = null;
        try {
            int effect = roleService.delete(id);
            if (effect > 0) {
                ajaxResult = new AjaxResult(true, "删除成功");
            } else {
                ajaxResult = new AjaxResult("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult = new AjaxResult("操作异常,可能是该角色已分配权限或分配给用户");
        }
        return ajaxResult;
    }
}
