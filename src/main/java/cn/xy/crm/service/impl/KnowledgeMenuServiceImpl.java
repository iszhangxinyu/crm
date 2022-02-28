package cn.xy.crm.service.impl;

import cn.xy.crm.domain.KnowledgeMenu;
import cn.xy.crm.mapper.KnowledgeMenuMapper;
import cn.xy.crm.service.IKnowledgeMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KnowledgeMenuServiceImpl implements IKnowledgeMenuService{
     @Autowired
	 private KnowledgeMenuMapper dao;

	@Override
	public List<KnowledgeMenu> queryKnowledgeMenu() {
		return dao.selectRoot();
	}

}
