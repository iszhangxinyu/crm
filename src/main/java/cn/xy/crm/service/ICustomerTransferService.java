package cn.xy.crm.service;

import cn.xy.crm.domain.CustomerTransfer;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.QueryObject;


public interface ICustomerTransferService {
    int save(CustomerTransfer e);

    int delete(Long id);

    CustomerTransfer get(Long id);

    int update(CustomerTransfer e);

    PageResult listAll();

    PageResult queryByCondition(QueryObject qo);
}
