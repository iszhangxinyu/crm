package cn.xy.crm.mapper;

import cn.xy.crm.domain.Employee;
import cn.xy.crm.query.EmployeeQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author z-xy
 */
public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);

    Employee queryByLogin(@Param("username") String username, @Param("password") String password);

    Long queryByConditionCount(EmployeeQueryObject qo);

    List<Employee> queryByCondition(EmployeeQueryObject qo);

    /**
     * 修改employee的一行数据状态为0
     * @param id
     * @return
     */
    Long updateEmployeeState(Long id);

    /**
     * 关联员工和角色信息
     */
    void addRelation(@Param("eid") Long eid, @Param("rid") Long rid);

    List<Long> queryRoleIdsByEmpId(Long id);

    /**
     * 删除员工关联的角色信息
     * @param id
     */
    void deleteRelation(Long id);

    /**
     * 查询所有的部门经理
     * @return
     */
    List<Employee> listManager();

    List<Employee> selectByPotential();

    List<Employee> selectByCustomer();

    List<Employee> selectByInCharge();

    Long selectAllCount();
}