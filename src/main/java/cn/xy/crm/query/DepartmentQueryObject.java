package cn.xy.crm.query;

import lombok.Getter;
import lombok.Setter;

/**
 * @author z-xy
 * @version v1.0
 * @date created in 2022-01-14 17:04
 */
@Getter@Setter
public class DepartmentQueryObject extends QueryObject{
    private String keyword;

    private Boolean state;
}
