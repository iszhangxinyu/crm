package cn.xy.crm.mapper;

import cn.xy.crm.domain.Vacate;
import cn.xy.crm.query.QueryObject;

import java.util.List;

public interface VacateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Vacate record);

    Vacate selectByPrimaryKey(Long id);

    List<Vacate> selectAll();

    int updateByPrimaryKey(Vacate record);

    Long queryByConditionCount(QueryObject qo);

    List<Vacate> queryByCondition(QueryObject qo);

    Long queryVacateByEidCount(QueryObject qo);

    List<Vacate> queryVacateByEid(QueryObject qo);


}