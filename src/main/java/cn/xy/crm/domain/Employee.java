package cn.xy.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 员工
 *
 * @author z-xy
 */
@Setter
@Getter
@Alias("Employee")
public class Employee {
    private Long id;

    private String username;

    private String realname;

    private String password;

    private String tel;

    private String email;

    /**
     * 员工所属部门
     */
    private Department dept;

    @JsonFormat(pattern = "yyy-MM-dd", timezone = "GMT+8")
    private Date inputtime;

    /**
     * 1正常，0离职
     */
    private Boolean state;

    /**
     * 1超级管理员，0普通职工
     */
    private Boolean admin;

    /** 员工角色列表 */
    private List<Role> roleList = new ArrayList<>();
}