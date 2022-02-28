package cn.xy.crm.mapper;

import cn.xy.crm.domain.SystemDictionaryItem;
import cn.xy.crm.query.QueryObject;

import java.util.List;

public interface SystemDictionaryItemMapper {
	int deleteByPrimaryKey(Long id);

	int insert(SystemDictionaryItem record);

	SystemDictionaryItem selectByPrimaryKey(Long id);

	List<SystemDictionaryItem> selectAll();

	int updateByPrimaryKey(SystemDictionaryItem record);

	/**
	 * @param qo
	 * @return
	 */
	Long queryCount(QueryObject qo);

	/**
	 * @param qo
	 * @return
	 */
	List<SystemDictionaryItem> queryForPageById(QueryObject qo);

	/**
	 * 查询字典对应的字典明细
	 * 
	 * @param id
	 *            字典ID
	 */
	List<SystemDictionaryItem> queryDicItem(Integer id);

    List<SystemDictionaryItem> queryBySn(String sn);
}