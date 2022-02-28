package cn.xy.crm.mapper;

import cn.xy.crm.domain.Customer;
import cn.xy.crm.query.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Customer record);

    Customer selectByPrimaryKey(Long id);

    List<Customer> selectAll();

    int updateByPrimaryKey(Customer record);

    List<Customer> selectByinChargeId(Long userId);

    // List<Customer> queryByCondition(QueryObject qo, @Param("userId") Long userId);

    //Long queryByConditionCount(@Param("qo")QueryObject qo,@Param("userId")Long userId);
    // 潜在客户高级查询
    Long queryByConditionCount(QueryObject qo);

    List<Customer> queryByCondition(QueryObject qo);

    // 客户资源池高级查询
    Long queryResourcePoolByConditionCount(QueryObject qo);

    List<Customer> queryResourcePoolByCondition(QueryObject qo);


    // 正式客户高级查询
    List<Customer> queryCustomerByCondition(QueryObject qo);

    Long queryCustomerByConditionCount(QueryObject qo);


    int updateByChargeId(@Param("id") Long id, @Param("inchargeId") Long inchargeId);

    int updateStatusFalseById(Long id);

    int updateStatusSuccessById(Long id);

    // 吸纳资源池的用户
    int customerAdmit(@Param("inchargeId") Long inchargeId, @Param("id") Long id);

    // 移入资源池
    int moveToResourcePool(@Param("inchargeId") Long inchargeId, @Param("id") Long id);

    int lostCustomer(@Param("inchargeId") Long inChargeId, @Param("id") Long id);

    Long selectAllCount();
    /*获取正式客户*/
    List<Customer> listAllFormalCustomer();

}