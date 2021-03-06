package cn.xy.crm.query;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
public class TaskQueryObject extends QueryObject {
    private Long handleUserId;
    private String keyword;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date end;
}
