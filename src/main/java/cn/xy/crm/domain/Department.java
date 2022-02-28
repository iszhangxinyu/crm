package cn.xy.crm.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.List;


/**
 * 部门
 *
 * @author z-xy
 */
@Setter
@Getter
@Alias("Department")
public class Department {
    private Long id;
    /**
     * 部门编号
     */
    private String sn;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 部门经理
     */
    private Employee manager;
    /**
     * 上级部门
     */
    private Department parent;
    /**
     * 属性菜单显示文本
     */
    private String text;
    /**
     * 部门状态 正常：1 停用：0
     */
    private Boolean state;
    /**
     * 子部门
     */
    private List<Department> children;
}