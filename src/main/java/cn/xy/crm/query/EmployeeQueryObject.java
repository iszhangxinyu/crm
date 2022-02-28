package cn.xy.crm.query;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author z-xy
 * @version v1.0
 * @date created in 2021-12-19 9:51
 */
@Setter
@Getter
public class EmployeeQueryObject extends QueryObject {
    /**
     * 关键字
     */
    private String keyword;
    /**
     * 起始日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    /**
     * 结束日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    /**
     * 状态 1:在职 0:离职 null:全部
     */
    private Boolean state;
}
