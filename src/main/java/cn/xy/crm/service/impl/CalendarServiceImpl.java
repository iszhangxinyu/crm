package cn.xy.crm.service.impl;

import cn.xy.crm.domain.Calendar;
import cn.xy.crm.mapper.CalendarMapper;
import cn.xy.crm.service.ICalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarServiceImpl implements ICalendarService {

    @Autowired
    private CalendarMapper dao;

    public int deleteByPrimaryKey(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    public int insert(Calendar record) {
        return dao.insert(record);
    }

    public Calendar selectByPrimaryKey(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    public List<Calendar> selectAll() {
        return dao.selectAll();
    }

    public int updateByPrimaryKey(Calendar record) {
        return dao.updateByPrimaryKey(record);
    }

    public int updateDayDelta(Long id, int startInt, int endInt) {
        return dao.updateDayDelta(id,startInt,endInt);
    }
}
