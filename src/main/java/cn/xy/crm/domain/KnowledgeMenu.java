package cn.xy.crm.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * 知识库
 *
 * @author zhangxinyu
 */
@Setter@Getter
@Alias("KnowledgeMenu")
public class KnowledgeMenu {
    private Long id;
    private String text;
    private Boolean state;
    private Boolean checked;
    private String attributes;
    private List<KnowledgeMenu> children;
}