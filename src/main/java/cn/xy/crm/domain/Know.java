package cn.xy.crm.domain;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
@Alias("Know")
public class Know {
    private Long id;
    private String context;
	@Override
	public String toString() {
		return "Know [id=" + id + ", context=" + context + "]";
	}
    
    
}