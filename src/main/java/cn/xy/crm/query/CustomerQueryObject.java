package cn.xy.crm.query;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhangxinyu
 */
@Setter
@Getter
public class CustomerQueryObject extends QueryObject {
    private Long userId;
    /**
     * 姓名和电话
     */
    private String keyword;
    /**
     * -2:流失，-1:开发失败，0:潜在客户，1:正式客户，2:资源池客户
     */
    private Integer status;
}