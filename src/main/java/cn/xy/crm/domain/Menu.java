package cn.xy.crm.domain;


import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * 系统菜单
 *
 * @author z-xy
 */
@Setter
@Getter
@Alias("Menu")
public class Menu {
    private Long id;

    /**
     * 节点显示的文本你，即权限菜单
     */
    private String text;

    /**
     * 节点的图标，使用bootstrap
     */
    private String iconcls;

    /**
     * 节点选中状态
     */
    private Boolean checked;

    /**
     * 节点展开或者合拢，open or close
     */
    private String state;

    /**
     * 节点对应的请求：{"url":"/query"}
     */
    private String attributes;

    /**
     * 子节点
     */
    private List<Menu> children;

    /**
     * 节点权限：cn.xy.crm.web.xxxController:index
     */
    private String function;
}