package cn.xy.crm.service.impl;

import cn.xy.crm.domain.SystemDictionaryItem;
import cn.xy.crm.mapper.SystemDictionaryItemMapper;
import cn.xy.crm.mapper.SystemDictionaryMapper;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.QueryObject;
import cn.xy.crm.service.ISystemDictionaryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author zhangxinyu
 */
@Service
public class ISystemDictionaryItemServiceImpl implements ISystemDictionaryItemService {
	@Autowired
	private SystemDictionaryMapper systemDictionaryMapper;
	@Autowired
	private SystemDictionaryItemMapper systemDictionaryItemDao;

	@Override
	public PageResult queryItemById(QueryObject qo) {
		Long count = systemDictionaryItemDao.queryCount(qo);
		if (count == 0) {
			return new PageResult(0L, Collections.emptyList());
		}
		List<SystemDictionaryItem> itemList = systemDictionaryItemDao.queryForPageById(qo);
		return new PageResult((long) count.intValue(), itemList);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		return systemDictionaryItemDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SystemDictionaryItem record) {
		return systemDictionaryItemDao.insert(record);
	}

	@Override
	public SystemDictionaryItem selectByPrimaryKey(Long id) {
		return systemDictionaryItemDao.selectByPrimaryKey(id);
	}

	@Override
	public List<SystemDictionaryItem> selectAll() {
		return systemDictionaryItemDao.selectAll();
	}

	@Override
	public int updateByPrimaryKey(SystemDictionaryItem record) {
		return systemDictionaryItemDao.updateByPrimaryKey(record);
	}

	/**
	 * 禁用字典明细
	 */
	@Override
	public void forbiddenDictionaryItem(Long id) {
		SystemDictionaryItem item = systemDictionaryItemDao.selectByPrimaryKey(id);
		item.setState(true);
		systemDictionaryItemDao.updateByPrimaryKey(item);
	}

	@Override
	public List<SystemDictionaryItem> queryDicItem(Integer id) {
		return systemDictionaryItemDao.queryDicItem(id);
	}

	@Override
	public List<SystemDictionaryItem> queryBySn(String sn) {
		return systemDictionaryItemDao.queryBySn(sn);
	}

}
