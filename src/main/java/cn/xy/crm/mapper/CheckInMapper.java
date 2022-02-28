package cn.xy.crm.mapper;

import cn.xy.crm.domain.CheckIn;
import cn.xy.crm.query.QueryObject;

import java.util.List;

public interface CheckInMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CheckIn record);

    CheckIn selectByPrimaryKey(Long id);

    List<CheckIn> selectAll();

    int updateByPrimaryKey(CheckIn record);

    Long queryByConditionCount(QueryObject qo);

    List<CheckIn> queryByCondition(QueryObject qo);


    Long queryCheckInByEidCount(Long id);

    /**
     * 查询当前用户的考勤记录
     * @param id
     * @return
     */
    List<CheckIn> queryCheckInByEid(Long id);
}