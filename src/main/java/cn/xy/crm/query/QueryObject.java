package cn.xy.crm.query;

import lombok.Getter;
import lombok.Setter;

/**
 * 页面传递查询参数对象
 *
 * @author z-xy
 * @version v1.0
 * @date created in 2021-12-19 9:03
 */
@Setter
@Getter
public class QueryObject {
    /**
     * 页码
     */
    private Integer page;

    /**
     * 每页显示多少行
     */
    private Integer rows;

    /**
     * 分页起始行
     *
     * @return 分页
     */
    public Integer getStart() {
      // return (this.page - 1) * this.rows;
        return this.page == null ? 0 : (this.page - 1) * this.rows;
    }
}
