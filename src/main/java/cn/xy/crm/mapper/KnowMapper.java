package cn.xy.crm.mapper;


import cn.xy.crm.domain.Know;
import cn.xy.crm.query.KnowQueryObject;
import cn.xy.crm.query.QueryObject;

import java.util.List;

public interface KnowMapper {
    int deleteByPrimaryKey(Long id);
    int insert(Know record);
    Know selectByPrimaryKey(Long id);
    List<Know> selectAll();
    int updateByPrimaryKey(Know record);
	Long queryByConditionCount(KnowQueryObject qo);
	
	List<Know> queryByCondition(QueryObject qo);
	//根据id查询内容
	Know queryContextById(Long id);
}