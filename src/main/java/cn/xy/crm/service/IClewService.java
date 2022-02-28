package cn.xy.crm.service;

import cn.xy.crm.domain.Clew;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.ClewQueryObject;


/**
 * @author zhangxinyu
 */
public interface IClewService {
    int save(Clew c);

    int delete(Long id);

    Clew get(Long id);

    int update(Clew c);

    PageResult listAll();


    void luceneWriteIndex();

    PageResult querybyLuceneAll(String keyword);

    public PageResult querybyLuceneCondition(ClewQueryObject qo);

    int deleteLuceneById(Long id);

    int reload();

    String getContentById(Long id);
}
