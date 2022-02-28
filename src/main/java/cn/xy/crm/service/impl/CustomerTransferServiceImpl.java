package cn.xy.crm.service.impl;

import cn.xy.crm.domain.CustomerTransfer;
import cn.xy.crm.mapper.CustomerTransferMapper;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.QueryObject;
import cn.xy.crm.service.ICustomerTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/21.
 */
@Service
public class CustomerTransferServiceImpl implements ICustomerTransferService {

    @Autowired
    private CustomerTransferMapper dao;

    @Override
    public int save(CustomerTransfer transfer) {
        return dao.insert(transfer);
    }

    @Override
    public int delete(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public CustomerTransfer get(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public int update(CustomerTransfer transfer) {
        return dao.updateByPrimaryKey(transfer);
    }

    @Override
    public PageResult listAll() {
        return new PageResult(Long.parseLong(dao.selectAll().size() + ""), dao.selectAll());
    }

    @Override
    public PageResult queryByCondition(QueryObject qo) {
        // 根据查询条件查询出总条数
        Long count = dao.queryByConditonCount(qo);
        if (count == 0) {
            return PageResult.EMPTY;
        } else {
            // 返回查询的结果集
            List<CustomerTransfer> listData = dao.queryByCondition(qo);
            return new PageResult(count, listData);
        }
    }
}
