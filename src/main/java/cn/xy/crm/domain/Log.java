package cn.xy.crm.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 日志
 *
 * @author z-xy
 * @version v1.0
 * @date created in 2021-12-21 22:21
 */
@Setter
@Getter
public class Log {
    private Long id;
    /**
     * 操作用户
     */
    private Employee employee;
    /**
     * 操作时间
     */
    private Date optime;
    /**
     * 用户ip
     */
    private String opip;
    /**
     * 业务方法
     */
    private String function;
    /**
     * 业务参数
     */
    private String params;
}
