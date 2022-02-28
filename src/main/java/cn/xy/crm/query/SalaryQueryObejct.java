package cn.xy.crm.query;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class SalaryQueryObejct extends QueryObject{

	
	 //查询条件
    private String keyword;
    private Integer year;
    private Integer month;
    private Long eid;
	
}
