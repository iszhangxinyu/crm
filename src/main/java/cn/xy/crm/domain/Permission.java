package cn.xy.crm.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 权限
 *
 * @author z-xy
 */
@Setter
@Getter
public class Permission {
    private Long id;

    private String name;

    /**
     * 权限表达式：cn.xy.crm.web.xxxController:save
     */
    private String resource;
}