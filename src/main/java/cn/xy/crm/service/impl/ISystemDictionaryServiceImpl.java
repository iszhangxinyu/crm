package cn.xy.crm.service.impl;

import cn.xy.crm.domain.SystemDictionary;
import cn.xy.crm.mapper.SystemDictionaryMapper;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.QueryObject;
import cn.xy.crm.service.ISystemDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ISystemDictionaryServiceImpl implements ISystemDictionaryService {
	@Autowired
	private SystemDictionaryMapper systemDictionaryDao;
	
	@Override
	public int insert(SystemDictionary record) {
		return 0;
	}

	@Override
	public SystemDictionary selectByPrimaryKey(Long id) {
		return null;
	}

	@Override
	public List<SystemDictionary> selectAll() {
		return systemDictionaryDao.selectAll();
	}

	@Override
	public int updateByPrimaryKey(SystemDictionary record) {
		return 0;
	}

	@Override
	public PageResult queryForPage(QueryObject qo) {
		Long count = systemDictionaryDao.queryCount();
		if(count == 0) {
			return new PageResult(0L, Collections.emptyList());
		} 
		List<SystemDictionary> records = systemDictionaryDao.queryForPage(qo);
		return new PageResult(count, records);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		 return 0;
	}

}
