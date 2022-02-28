package cn.xy.crm.mapper;

import cn.xy.crm.domain.Salary;
import cn.xy.crm.query.QueryObject;

import java.util.List;

public interface SalaryMapper {
    int deleteByPrimaryKey(Long id);
    int insert(Salary record);
    Salary selectByPrimaryKey(Long id);
    List<Salary> selectAll();
    int updateByPrimaryKey(Salary record);
	void deleteAll();

	//个人薪资查询
	Long querySalaryByEidCount(Long id);
	//个人薪资查询
	List<Salary> querySalaryByEid(Long id);

	//查询全部工资
	List<Salary> queryByCondition(QueryObject qo);
	//查询全部工资条数
	Long queryByConditionCount(QueryObject qo);

}