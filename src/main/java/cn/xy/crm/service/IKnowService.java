package cn.xy.crm.service;

import cn.xy.crm.domain.Know;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.KnowQueryObject;

import java.util.List;

public interface IKnowService {
	 int delete(Long id);
	    int save(Know record);
	    Know selectByPrimaryKey(Long id);
	    List<Know> selectAll();
	    int update(Know record);
	    void indexWriterReload();
	    PageResult query(KnowQueryObject qo);
	    PageResult querySearch(KnowQueryObject qo);
		Know queryContextById(Long id);
}
