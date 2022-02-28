package cn.xy.crm.service;


import cn.xy.crm.domain.ContractChartVO;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.QueryObject;

import java.util.List;

public interface IContractChartService {




    PageResult selectByCondition(QueryObject qo);

    List<String> selectTimeYear(QueryObject qo);


    List<Long> selectAmountYear(QueryObject qo);

    List<ContractChartVO> selectPie(QueryObject qo);





}
