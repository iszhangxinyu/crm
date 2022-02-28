package cn.xy.crm.mapper;

import cn.xy.crm.domain.Contract;
import cn.xy.crm.domain.ContractChartVO;
import cn.xy.crm.query.QueryObject;

import java.util.List;

public interface ContractChartMapper {

    List<Contract> selectByCondition(QueryObject qo);

    Long selectByConditionCount(QueryObject qo);

    List<String> selectTimeYear(QueryObject qo);

    List<Long> selectAmountYear(QueryObject qo);

    List<ContractChartVO> selectPie(QueryObject qo);


}