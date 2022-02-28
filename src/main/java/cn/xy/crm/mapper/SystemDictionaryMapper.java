package cn.xy.crm.mapper;


import cn.xy.crm.domain.SystemDictionary;
import cn.xy.crm.query.QueryObject;

import java.util.List;

public interface SystemDictionaryMapper {
	int deleteByPrimaryKey(Long id);

	int insert(SystemDictionary record);

	SystemDictionary selectByPrimaryKey(Long id);

	List<SystemDictionary> selectAll();

	int updateByPrimaryKey(SystemDictionary record);

	/**
	 * query the count of the table's record
	 * 
	 * @return
	 */
	Long queryCount();

	/**
	 * @param qo
	 * @return
	 */
	List<SystemDictionary> queryForPage(QueryObject qo);
}