package cn.xy.crm.mapper;

import cn.xy.crm.domain.Customer;
import cn.xy.crm.domain.CustomerVO;
import cn.xy.crm.query.QueryObject;

import java.util.List;

public interface CustomerChartMapper {

    List<Customer> queryByCondition(QueryObject qo);

    Long queryByConditionCount(QueryObject qo);


    List<String> selectTimeYear(QueryObject qo);

    List<Long> selectAmountYear(QueryObject qo);

    List<CustomerVO> selectPie(QueryObject qo);
}