package cn.xy.crm.mapper;

import cn.xy.crm.domain.OrderBill;
import cn.xy.crm.query.QueryObject;

import java.util.List;

public interface OrderBillMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderBill record);

    OrderBill selectByPrimaryKey(Long id);

    List<OrderBill> selectAll();

    int updateByPrimaryKey(OrderBill record);

    List<OrderBill> queryByCondition(QueryObject qo);

    Long queryByConditionCount(QueryObject qo);

    int checked(Long id);

    int noChecked(Long id);

    void updateStatus(Long id);
}