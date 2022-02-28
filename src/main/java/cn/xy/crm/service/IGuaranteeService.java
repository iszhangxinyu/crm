package cn.xy.crm.service;

import cn.xy.crm.domain.Guarantee;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.QueryObject;

import java.util.List;

public interface IGuaranteeService {

    /**
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * @param record
     * @return
     */
    int save(Guarantee record);

    /**
     * @param id
     * @return
     */
    Guarantee selectByPrimaryKey(Long id);

    /**
     * @return
     */
    List<Guarantee> selectAll();

    /**
     * @param record
     * @return
     */
    int update(Guarantee record);

    /**
     * 所有的保修单
     * 动态查询+分页
     *
     * @param qo
     * @return
     */
    PageResult queryByCondition(QueryObject qo);

    /**
     * 修改延保时间
     * @param id
     * @return
     */
    int updateTime(Long id);

}
