package cn.xy.crm.service;

import cn.xy.crm.domain.Department;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.DepartmentQueryObject;

import java.util.List;

/**
 * @author z-xy
 * @version v1.0
 * @date created in 2021-12-19 18:05
 */
public interface IDepartmentService {

    /**
     * 查询所有的部门信息
     *
     * @return
     */
    List<Department> queryDeptForEmp();

    /**
     * 当前系统的部门列表
     * @param qo
     * @return
     */
    PageResult list(DepartmentQueryObject qo);

    /**
     * 从根部门开始查
     * @return
     */
    List<Department> listTree();

    /**
     * 添加部门
     * @param department
     * @return
     */
    int add(Department department);

    /**
     * 停用部门
     * @param id
     * @return
     */
    int disable(Long id);

    int edit(Department dept);

    List<Department> listAll();

    List<Department> getByMid(Long id);
}

