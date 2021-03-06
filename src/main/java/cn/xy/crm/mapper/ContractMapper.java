package cn.xy.crm.mapper;

import cn.xy.crm.domain.Contract;
import cn.xy.crm.query.QueryObject;

import java.util.List;

public interface ContractMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Contract record);

    Contract selectByPrimaryKey(Long id);

    List<Contract> selectAll();

    int updateByPrimaryKey(Contract record);

    List<Contract> queryByCondition(QueryObject qo);

    Long queryByConditionCount(QueryObject qo);

    int checked(Long id);

    int noChecked(Long id);
}