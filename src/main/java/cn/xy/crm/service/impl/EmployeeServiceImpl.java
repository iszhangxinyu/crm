package cn.xy.crm.service.impl;

import cn.xy.crm.domain.Employee;
import cn.xy.crm.domain.Role;
import cn.xy.crm.mapper.EmployeeMapper;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.EmployeeQueryObject;
import cn.xy.crm.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author z-xy
 * @version v1.0
 * @date created in 2021-12-19 10:00
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 新增员工，并增加与角色的关联信息
     *
     * @param e
     * @return
     */
    @Override
    public int save(Employee e) {
        int effect = employeeMapper.insert(e);
        List<Role> roleList = e.getRoleList();
        for (Role role : roleList) {
            employeeMapper.addRelation(e.getId(), role.getId());
        }
        return effect;
    }

    @Override
    public Long dimission(Long id) {
        return employeeMapper.updateEmployeeState(id);
    }

    @Override
    public Employee get(Long id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    /**
     * 1.更新员工信息
     * 2.更新员工关联角色信息
     *
     * @param e
     * @return
     */
    @Override
    public int update(Employee e) {
        int effect = employeeMapper.updateByPrimaryKey(e);
        // 删除所有的关联信息后，重新添加
        employeeMapper.deleteRelation(e.getId());
        for (Role role : e.getRoleList()) {
            employeeMapper.addRelation(e.getId(), role.getId());
        }
        return effect;
    }

    @Override
    public List<Employee> list() {
        return null;
    }

    @Override
    public Employee queryByLogin(String username, String password) {
        return employeeMapper.queryByLogin(username, password);
    }

    @Override
    public PageResult queryByCondition(EmployeeQueryObject qo) {
        Long total = employeeMapper.queryByConditionCount(qo);
        if (total == 0L) {
            return PageResult.EMPTY;
        }
        List<Employee> employeeList = employeeMapper.queryByCondition(qo);
        return new PageResult(total, employeeList);
    }

    @Override
    public List<Long> queryRoleIdsByEmpId(Long id) {
        return employeeMapper.queryRoleIdsByEmpId(id);
    }

    @Override
    public List<Employee> listManager() {
        return employeeMapper.listManager();
    }

    @Override
    public List<Employee> selectByPotential() {
        return employeeMapper.selectByPotential();
    }

    @Override
    public List<Employee> selectByCustomer() {
        return employeeMapper.selectByCustomer();
    }

    @Override
    public List<Employee> selectByInCharge() {
        return employeeMapper.selectByInCharge();
    }

    @Override
    public PageResult sellerList() {
        Long total = employeeMapper.selectAllCount();
        List<Employee> results = employeeMapper.selectAll();
        return new PageResult(total, results);
    }

}
