package cn.xy.crm.mapper;

import cn.xy.crm.domain.CustomerTransfer;
import cn.xy.crm.domain.Department;
import cn.xy.crm.query.QueryObject;

import java.util.List;

public interface CustomerTransferMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CustomerTransfer record);

    CustomerTransfer selectByPrimaryKey(Long id);

    List<CustomerTransfer> selectAll();

    int updateByPrimaryKey(CustomerTransfer record);

    Long queryByConditonCount(QueryObject qo);

    List<CustomerTransfer> queryByCondition(QueryObject qo);
}