package cn.xy.crm.web.controller;

import cn.xy.crm.domain.Department;
import cn.xy.crm.page.AjaxResult;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.DepartmentQueryObject;
import cn.xy.crm.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;

/**
 * @author z-xy
 * @version v1.0
 * @date created in 2021-12-19 18:04
 */
@Controller
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("/department")
    public String index() {
        return "department";
    }

    /**
     * 员工模块：添加员工分配部门，显示当前系统的所有部门
     *
     * @return
     */
    @RequestMapping("/dept_queryDeptForEmp")
    @ResponseBody
    public List<Department> queryDeptForEmp() {
        return departmentService.queryDeptForEmp();
    }

    @RequestMapping("/department_list")
    @ResponseBody
    public PageResult list(DepartmentQueryObject qo) {
        PageResult page = null;
        page = departmentService.list(qo);
        return page;
    }

    /**
     * 以tree的形式显示部门列
     */
    @RequestMapping("/department_tree")
    @ResponseBody
    public List<Department> listTree() {
        List<Department> departmentList = Collections.emptyList();
        try {
            departmentList= departmentService.listTree();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departmentList;
    }

    @RequestMapping("/department_add")
    @ResponseBody
    public AjaxResult add(Department department) {
        AjaxResult result = null;
        try {
            department.setState(true);
            int effect = departmentService.add(department);
            if(effect > 0) {
                result = new AjaxResult(true, "添加成功");
            } else {
                result = new AjaxResult("添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("操作错误");
        }
        return result;
    }

    @RequestMapping("/department_edit")
    @ResponseBody
    public AjaxResult edit(Department dept) {
        AjaxResult result = null;
        try {
            int effect = departmentService.edit(dept);
            if (effect > 0) {
                result = new AjaxResult(true, "修改成功");
            } else {
                result = new AjaxResult("修改失败");
            }
        } catch (Exception e) {
            result = new AjaxResult("操作失误");
        }
        return result;
    }

    /**
     * 停用部门
     */
    @RequestMapping("/department_delete")
    @ResponseBody
    public AjaxResult disable(Long id) {
        AjaxResult result = null;
        try {
            int effect = departmentService.disable(id);
            if (effect > 0) {
                result = new AjaxResult(true, "停用成功");
            } else {
                result = new AjaxResult("停用失败");
            }
        } catch (Exception e) {
            result = new AjaxResult("操作失误");
        }
        return result;
    }
}
