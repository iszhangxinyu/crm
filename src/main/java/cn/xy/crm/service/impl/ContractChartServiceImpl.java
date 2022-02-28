package cn.xy.crm.service.impl;

import cn.xy.crm.domain.Contract;
import cn.xy.crm.domain.ContractChartVO;
import cn.xy.crm.mapper.ContractChartMapper;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.QueryObject;
import cn.xy.crm.service.IContractChartService;
import cn.xy.crm.util.PermissionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractChartServiceImpl implements IContractChartService {

    @Autowired
    private ContractChartMapper dao;


    @Override
    public PageResult selectByCondition(QueryObject qo) {
        if (PermissionUtils.checkPermission("cn.xy.crm.web.controller.CustomerController:all")) {

        }
        Long count = dao.selectByConditionCount(qo);
        if (count > 0) {
            List<Contract> result = dao.selectByCondition(qo);
            return new PageResult(count, result);
        } else {
            return PageResult.EMPTY;
        }
    }

    @Override
    public List<String> selectTimeYear(QueryObject qo) {
        return dao.selectTimeYear(qo);
    }


    @Override
    public List<Long> selectAmountYear(QueryObject qo) {
        return dao.selectAmountYear(qo);
    }

    @Override
    public List<ContractChartVO> selectPie(QueryObject qo) {
        return dao.selectPie(qo);
    }
}
