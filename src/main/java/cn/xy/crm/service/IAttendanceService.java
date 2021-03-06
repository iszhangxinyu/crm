package cn.xy.crm.service;

import cn.xy.crm.domain.Attendance;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.QueryObject;

import javax.servlet.ServletOutputStream;
import java.util.List;


public interface IAttendanceService {

    int save(Attendance attendance);

    int delete(Long id);

    Attendance get(Long id);

    int update(Attendance attendance);

    List<Attendance> listAll();

    /**
     * 查询所有的考勤统计
     *
     * @param qo
     * @return
     */
    PageResult queryByCondition(QueryObject qo);

    int updateAttendance();

    /**
     * 查询员工的考勤统计
     *
     * @param id
     * @return
     */
    PageResult queryAttendanceByEid(Long id);

    /**
     * 导出员工考勤统计到execl中
     *
     * @param outputStream
     * @return
     */
    int exportAttendance(ServletOutputStream outputStream);


}
