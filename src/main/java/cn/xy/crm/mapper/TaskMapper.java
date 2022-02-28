package cn.xy.crm.mapper;


import cn.xy.crm.domain.Task;
import cn.xy.crm.query.QueryObject;

import java.util.List;

public interface TaskMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Task record);

    Task selectByPrimaryKey(Long id);

    List<Task> selectAll();

    int updateByPrimaryKey(Task record);
    Long getCount(QueryObject qo);
	List<Task> selectByCondition(QueryObject qo);

	void deleteALL(Task task);
}