package cn.xy.crm.service.impl;

import cn.xy.crm.domain.Customer;
import cn.xy.crm.domain.CustomerVO;
import cn.xy.crm.mapper.CustomerChartMapper;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.CustomerChartQueryObject;
import cn.xy.crm.query.QueryObject;
import cn.xy.crm.service.ICustomerChartService;
import cn.xy.crm.util.PermissionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerChartServiceImpl implements ICustomerChartService {
    @Autowired
    CustomerChartMapper dao;


    @Override
    public List<String> selectTimeYear(QueryObject qo) {
        if (PermissionUtils.checkPermission("cn.xy.crm.web.controller.CustomerController:all")) {
            CustomerChartQueryObject chartQo = (CustomerChartQueryObject) qo;
            chartQo.setUserId(null);
        }
        return dao.selectTimeYear(qo);
    }


    public List<Long> selectAmountYear(QueryObject qo) {
        if (PermissionUtils.checkPermission("cn.xy.crm.web.controller.CustomerController:all")) {
            CustomerChartQueryObject chartQo = (CustomerChartQueryObject) qo;
            chartQo.setUserId(null);
        }
        return dao.selectAmountYear(qo);
    }

    @Override
    public List<CustomerVO> selectPie(QueryObject qo) {
        if (PermissionUtils.checkPermission("cn.xy.crm.web.controller.CustomerController:all")) {
            CustomerChartQueryObject chartQo = (CustomerChartQueryObject) qo;
            chartQo.setUserId(null);
        }
        return dao.selectPie(qo);
    }


    @Override
    public PageResult selectByCondition(QueryObject qo) {
        if (PermissionUtils.checkPermission("cn.xy.crm.web.controller.CustomerController:all")) {
            CustomerChartQueryObject chartQo = (CustomerChartQueryObject) qo;
            chartQo.setUserId(null);
        }
        Long count = dao.queryByConditionCount(qo);
        if (count > 0) {
            List<Customer> result = dao.queryByCondition(qo);
            return new PageResult(count, result);
        } else {
            return PageResult.EMPTY;
        }
    }


}
