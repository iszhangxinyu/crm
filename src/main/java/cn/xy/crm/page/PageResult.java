package cn.xy.crm.page;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页结果集
 *
 * @author z-xy
 * @version v1.0
 * @date created in 2021-12-19 9:42
 */
@Setter
@Getter
public class PageResult {
    /**
     * 数据库数据总条数
     */
    private Long total;
    /**
     * 分页数据集
     */
    private List rows;

    /**
     * 返回一个空的Page对象
     */
    public static final PageResult EMPTY = new PageResult(0L, Collections.emptyList());

    private Map<String, Object> data = new HashMap();

    public PageResult() {
    }

    public PageResult(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }
}
