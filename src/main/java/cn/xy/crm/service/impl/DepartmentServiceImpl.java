package cn.xy.crm.service.impl;

import cn.xy.crm.domain.Department;
import cn.xy.crm.mapper.DepartmentMapper;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.DepartmentQueryObject;
import cn.xy.crm.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author z-xy
 * @version v1.0
 * @date created in 2021-12-19 18:12
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> queryDeptForEmp() {
        return departmentMapper.selectAll();
    }

    @Override
    public PageResult list(DepartmentQueryObject qo) {
        // 先根据条件查部门的个数
        Long total = departmentMapper.queryCount(qo);
        if (total == 0L) {
            return PageResult.EMPTY;
        }
        List<Department> departmentList = departmentMapper.queryPage(qo);
        return new PageResult(total, departmentList);
    }

    @Override
    public List<Department> listTree() {
        return departmentMapper.selectRoot();
    }

    @Override
    public int add(Department department) {
        return departmentMapper.insert(department);
    }

    @Override
    public int disable(Long id) {
        return departmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int edit(Department dept) {
        return departmentMapper.updateByPrimaryKey(dept);
    }

    @Override
    public List<Department> listAll() {
        return departmentMapper.selectAll();
    }

    @Override
    public List<Department> getByMid(Long id) {
        return departmentMapper.getByMid(id);
    }
}
