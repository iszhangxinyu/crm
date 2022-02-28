package cn.xy.crm.service;

import cn.xy.crm.domain.Calendar;

import java.util.List;


public interface ICalendarService {

    int deleteByPrimaryKey(Long id);

    int insert(Calendar record);

    Calendar selectByPrimaryKey(Long id);

    List<Calendar> selectAll();

    int updateByPrimaryKey(Calendar record);

    int updateDayDelta(Long id, int startInt, int endInt);
}
