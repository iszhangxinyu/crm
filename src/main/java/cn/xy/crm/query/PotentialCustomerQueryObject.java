package cn.xy.crm.query;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2016/9/19.
 */
@Setter@Getter
public class PotentialCustomerQueryObject extends QueryObject {
    private Long userId;
    private String keyword; // 姓名 和电话
    private Integer status; // 开发状态
}
