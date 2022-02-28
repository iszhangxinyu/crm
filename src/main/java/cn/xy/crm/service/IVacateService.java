package cn.xy.crm.service;

import cn.xy.crm.domain.Vacate;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.QueryObject;

import java.util.List;

public interface IVacateService {

    int save(Vacate vacate);

    int update(Vacate vacate);

    Vacate get(Long id);

    List<Vacate> listAll();

    PageResult queryByCondition(QueryObject qo);

    /**
     * 普通员工查询自己的请假记录
     */
    PageResult queryVacateByEid(QueryObject qo);

    int delete(Long id);

    int audit(Vacate vacate);


}
