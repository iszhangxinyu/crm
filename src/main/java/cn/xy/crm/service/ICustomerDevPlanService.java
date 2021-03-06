package cn.xy.crm.service;

import cn.xy.crm.domain.CustomerDevPlan;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.QueryObject;

/**
 * Created by Administrator on 2016/9/20.
 */
public interface ICustomerDevPlanService {

    int save(CustomerDevPlan plan);

    int delete(Long id);

    CustomerDevPlan get(Long id);

    int update(CustomerDevPlan plan);

    PageResult listAll();

    /**
     * 正式客户开发计划列表查询
     * @param qo
     * @return
     */
    PageResult queryDevPlanByCondition(QueryObject qo);

    /**
     * 潜在客户计划列表
     * @param qo
     * @return
     */
    PageResult queryPontentialDevPlanByCondition(QueryObject qo);

}
