package cn.xy.crm.service;

import cn.xy.crm.domain.SystemDictionary;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.QueryObject;

import java.util.List;

/**
 * @author xinyu
 * @date 2021/06/26
 */
public interface ISystemDictionaryService {
    int deleteByPrimaryKey(Long id);

    int insert(SystemDictionary record);

    SystemDictionary selectByPrimaryKey(Long id);

    List<SystemDictionary> selectAll();

    int updateByPrimaryKey(SystemDictionary record);

	/**
	 * @return
	 */
	PageResult queryForPage(QueryObject qo);
}
