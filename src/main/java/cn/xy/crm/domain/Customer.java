package cn.xy.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * 客户信息
 *
 * @author zhangxinyu
 * @version v1.0
 * @date created in 2022-02-12 9:36
 */
@Setter
@Getter
@Alias("Customer")
public class Customer {
    /**编号 */
    private Long id;
    /**姓名 */
    private String name;
    /** 年龄 */
    private Integer age;
    /** 性别: */
    private Integer gender;
    /** 电话 */
    private String tel;
    /** 邮箱 */
    private String email;
    /** QQ */
    private String qq;
    /** 微信 */
    private String wechat;
    /**
     * 字典：职业
     */
    private String job;
    /**
     * 字典：收入水平
     */
    private String salarylevel;
    /**
     * 字典：客户来源
     */
    private String customersource;
    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date inputtime;
    /**
     * -2:流失
     * -1:开发失败
     * 0:潜在客户
     * 1:正式客户
     * 2:资源池客户
     */
    private Integer status;
    /**转正时间*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date becometime;
    /**
     * 创建人
     * 市场专员和销售主管皆可创建
     */
    private Employee inputuser;
    /**
     * 负责人：创建时为当前登录用户，销售主管可分配给市场专员
     */
    private Employee inchargeuser;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", wechat='" + wechat + '\'' +
                ", job='" + job + '\'' +
                ", salarylevel='" + salarylevel + '\'' +
                ", customersource='" + customersource + '\'' +
                ", inputtime=" + inputtime +
                ", status=" + status +
                ", becometime=" + becometime +
                '}';
    }
}
