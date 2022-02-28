package cn.xy.crm.service;


import cn.xy.crm.domain.Customer;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.QueryObject;

import javax.servlet.ServletOutputStream;
import java.util.List;

/**
 * @author zhangxinyu
 */
public interface ICustomerService {

    int save(Customer c);

    int delete(Long id);

    Customer get(Long id);

    int update(Customer c);

    PageResult listAll();


    /**
     * 高级查询
     */
    PageResult queryByCondition(QueryObject qo);

    /**
     * 正式客户高级查询
     *
     * @param qo
     * @return
     */
    PageResult queryCustomerByCondition(QueryObject qo);


    /**
     * 资源池客户高级查询
     *
     * @param qo
     * @return
     */
    PageResult queryResourcePoolByCondition(QueryObject qo);

    PageResult selectByinChargeId(Long userId);

    /**
     * 潜在客户的共享或移交
     *
     * @param id
     * @param inchargeId
     * @return
     */
    int updateByChargeId(Long id, Long inchargeId);

    //
    int updateStatusFalseById(Long id);


    /**
     * 潜在客户转正
     *
     * @param id
     * @return
     */
    int updateStatusSuccessById(Long id);


    /**
     * 用户吸纳资源池客户
     *
     * @param inchargeId
     * @param id
     * @return
     */
    int customerAdmit(Long inchargeId, Long id);


    /**
     * 正式客户移入资源池
     *
     * @param inchargeId
     * @param id
     * @return
     */
    int moveToResourcePool(Long inchargeId, Long id);


    /**
     * 客户流失
     *
     * @param id
     * @param id1
     * @return
     */
    int lostCustomer(Long id, Long id1);

    /**
     * 查询所有的客户，包括所有开发状态
     * @return
     */
    PageResult selectForOrder();

    List<Customer> selectAll();

    /**
     * 导出客户信息
     *
     * @param outputStream
     * @return
     */
    int exportCustomer(ServletOutputStream outputStream);


}
