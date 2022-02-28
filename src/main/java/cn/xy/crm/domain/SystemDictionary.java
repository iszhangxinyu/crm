package cn.xy.crm.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

/**
 * 数据字典
 * @author z-xy
 */
@Getter@Setter
@Alias("SystemDictionary")
public class SystemDictionary {
    private Long id;

    private String sn;

    private String name;

    private String intro;

}