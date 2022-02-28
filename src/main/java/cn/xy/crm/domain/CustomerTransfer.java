package cn.xy.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * 客户移交信息
 * <p>
 * 市场部经理可将市场专员手中的客户移交给其他市场专员，该对象记录移交的细节
 *
 * @author zhangxinyu
 */
@Setter
@Getter
@Alias("CustomerTransfer")
public class CustomerTransfer {
    private Long id;
    /**
     * 客户
     */
    private Customer customer;
    /**
     * 移交人员
     */
    private Employee transuser;
    /**
     * 移交时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date transtime;
    /**
     * 旧市场专员
     */
    private Employee oldseller;
    /**
     * 新市场专员
     */
    private Employee newseller;
    /**
     * 移交的原因
     */
    private String transreason;


}