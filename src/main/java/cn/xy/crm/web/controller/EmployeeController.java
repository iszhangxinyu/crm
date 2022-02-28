package cn.xy.crm.web.controller;

import cn.xy.crm.domain.Employee;
import cn.xy.crm.domain.Menu;
import cn.xy.crm.page.AjaxResult;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.EmployeeQueryObject;
import cn.xy.crm.service.IEmployeeService;
import cn.xy.crm.service.IMenuService;
import cn.xy.crm.service.IPermissionService;
import cn.xy.crm.util.PermissionUtils;
import cn.xy.crm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author z-xy
 * @version v1.0
 * @date created in 2021-12-19 14:53
 */
@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IPermissionService permissionService;
    @Autowired
    private IMenuService menuService;

    @RequestMapping("/login")
    @ResponseBody
    public AjaxResult login(String username, String password, HttpServletRequest request) {
        // 将登录的request保存到当前线程中
        UserContext.set(request);
        AjaxResult ajaxResult = null;
        Employee employee = employeeService.queryByLogin(username, password);
        if (employee != null) {
            request.getSession().setAttribute(UserContext.USER_IN_SESSION, employee);
            // 保存当前用户的权限resource到session中
            List<String> resources = permissionService.queryPermissionByEmpId(employee.getId());
            request.getSession().setAttribute(UserContext.PERMISSION_IN_SESSION, resources);
            // 保存用户的按钮菜单到session中
            // 1.查出系统中的所有菜单
            List<Menu> menus = menuService.queryForMenu();
            PermissionUtils.checkMenus(menus);
            for (int i = menus.size() - 1; i >= 0; i--) {
                Menu menu = menus.get(i);
                if (menu.getChildren() != null && menu.getChildren().size() == 0) {
                    menus.remove(i);
                }
            }
            request.getSession().setAttribute(UserContext.MENU_IN_SESSIOIN, menus);
            ajaxResult = new AjaxResult(true);
        } else {
            ajaxResult = new AjaxResult(false, "用户名或密码错误，请重新登录");
        }
        return ajaxResult;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletResponse response) {
        UserContext.get().getSession().invalidate();
        return "redirect:/login.jsp";
    }

    @RequestMapping("/employee")
    public String index() {
        return "employee";
    }

    @RequestMapping("/employee_list")
    @ResponseBody
    public PageResult list(EmployeeQueryObject qo) {
        return employeeService.queryByCondition(qo);
    }

    @RequestMapping("/manager_list")
    @ResponseBody
    public List<Employee> listManger() {
        List<Employee> managerList = Collections.emptyList();
        try {
            managerList = employeeService.listManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return managerList;
    }

    @RequestMapping("/employee_save")
    @ResponseBody
    public AjaxResult save(Employee employee) {
        AjaxResult ajaxResult = null;
        employee.setInputtime(new Date());
        employee.setPassword("000000");
        employee.setState(true);
        employee.setAdmin(false);
        int effect = employeeService.save(employee);
        if (effect > 0) {
            ajaxResult = new AjaxResult(true, "添加成功");
        } else {
            ajaxResult = new AjaxResult(false, "添加失败");
        }
        return ajaxResult;
    }

    @RequestMapping("/employee_edit")
    @ResponseBody
    public AjaxResult edit(Employee employee) {
        AjaxResult ajaxResult = null;
        try {
            int effect = employeeService.update(employee);
            if (effect > 0) {
                return new AjaxResult(true, "修改成功");
            } else {
                return new AjaxResult("修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("操作异常");
        }
    }

    /**
     * @param id
     * @return
     */
    @RequestMapping("/employee_delete")
    @ResponseBody
    public AjaxResult delete(Long id) {
        AjaxResult ajaxResult = null;
        try {
            employeeService.dimission(id);
            ajaxResult = new AjaxResult(true, "离职成功");
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult = new AjaxResult(false, "操作异常请联系管理员");
        }
        return ajaxResult;
    }

    /**
     * 高级查询
     *
     * @param qo
     * @return
     */
    @RequestMapping("/employee_search")
    @ResponseBody
    public PageResult search(EmployeeQueryObject qo) {
        return employeeService.queryByCondition(qo);
    }

    @RequestMapping("/employee_queryRoleIdsByEmpId")
    @ResponseBody
    public List<Long> queryRoleIdsByEmpId(Long id) {
        return employeeService.queryRoleIdsByEmpId(id);
    }

    /**
     * 查询所有潜在客户的负责人
     * <p>
     * 如何确定查询出来的员工都是市场专员呢? 这种只有添加过潜在客户的员工才能被查询出来
     */
    @RequestMapping("/selectByPotential")
    @ResponseBody
    public List<Employee> selectByPotential() {
        List<Employee> l = employeeService.selectByPotential();
        return employeeService.selectByPotential();
    }

    /**
     * 查询所有正式客户的负责人
     */
    @RequestMapping("/selectByCustomer")
    @ResponseBody
    public List<Employee> selectByCustomer() {
        return employeeService.selectByCustomer();
    }


    /**
     * 根据正式客户查询负责人
     */
    @RequestMapping("/incharge_list")
    @ResponseBody
    public List<Employee> selectByInCharge() {
        return employeeService.selectByInCharge();
    }

    /**
     * 为订单管理模块查询营销人员
     *
     * @return
     */
    @RequestMapping("/seller_list")
    @ResponseBody
    public PageResult sellerList() {
        PageResult result = null;
        result = employeeService.sellerList();
        return result;
    }

}
