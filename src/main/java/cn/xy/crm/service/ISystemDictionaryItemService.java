package cn.xy.crm.service;

import cn.xy.crm.domain.SystemDictionaryItem;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.QueryObject;

import java.util.List;

/**
 * @author xinyu
 * @date 2021/06/26
 */
public interface ISystemDictionaryItemService {
	
    int deleteByPrimaryKey(Long id);

    int insert(SystemDictionaryItem record);

    SystemDictionaryItem selectByPrimaryKey(Long id);

    List<SystemDictionaryItem> selectAll();

    int updateByPrimaryKey(SystemDictionaryItem record);

	/**
	 * @param qo
	 * @return
	 */
	PageResult queryItemById(QueryObject qo);

	/**
	 * @param id
	 */
	void forbiddenDictionaryItem(Long id);

	/**
	 * 查询字典对应的字典明细
	 */
	List<SystemDictionaryItem> queryDicItem(Integer id);

	/**
	 * 查询字典明细项
	 * @param sn 字典项代码
	 * @return 字典明细项集合
	 */
    List<SystemDictionaryItem> queryBySn(String sn);
}
