package cn.xy.crm.mapper;

import cn.xy.crm.domain.CustomerDevPlan;
import cn.xy.crm.query.QueryObject;

import java.util.List;

public interface CustomerDevPlanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CustomerDevPlan record);

    CustomerDevPlan selectByPrimaryKey(Long id);

    List<CustomerDevPlan> selectAll();

    int updateByPrimaryKey(CustomerDevPlan record);

    Long queryDevPlanByConditionCount(QueryObject qo);

    List<CustomerDevPlan> queryDevPlanByCondition(QueryObject qo);

    Long queryPotentialDevPlanByConditionCount(QueryObject qo);

    List<CustomerDevPlan> queryPotentialDevPlanByCondition(QueryObject qo);

    CustomerDevPlan selectByCustomerId(Long id);
}