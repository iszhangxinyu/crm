package cn.xy.crm.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色
 *
 * @author z-xy
 */
@Setter
@Getter
@Alias("Role")
public class Role {
    private Long id;
    private String name;
    private String sn;
    /**
     * 角色权限
     */
    private List<Permission> permissionList = new ArrayList<>();
}