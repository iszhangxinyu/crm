package cn.xy.crm.service;

import cn.xy.crm.domain.Employee;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.EmployeeQueryObject;

import java.util.List;

/**
 * @author z-xy
 * @version v1.0
 * @date created in 2021-12-19 9:52
 */
public interface IEmployeeService {
    /**
     * 添加员工
     * @param e
     * @return
     */
    int save(Employee e);

    Long dimission(Long id);

    Employee get(Long id);

    /**
     * 修改Employee信息
     * @param e
     * @return
     */
    int update(Employee e);

    List<Employee> list();

    /**z
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    Employee queryByLogin(String username, String password);

    PageResult queryByCondition(EmployeeQueryObject qo);

    /**
     * 查询用户的所有角色id
     * @param id
     * @return
     */
    List<Long> queryRoleIdsByEmpId(Long id);

    /**
     * 所有的部门经理信息
     * @return
     */
    List<Employee> listManager();

    /*根据潜在客户查询负责人*/
    List<Employee> selectByPotential();
    /*根据正式客户查询负责人*/
    List<Employee> selectByCustomer();

    // 查询用户根据客户负责人的Id
    List<Employee> selectByInCharge();

    PageResult sellerList();
}
