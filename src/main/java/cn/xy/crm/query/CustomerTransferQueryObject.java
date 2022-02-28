package cn.xy.crm.query;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/14.
 */
@Setter
@Getter
public class CustomerTransferQueryObject extends QueryObject {
    private String keyword; // 关键字查询
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate; // 开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate; // 结束时间
}
