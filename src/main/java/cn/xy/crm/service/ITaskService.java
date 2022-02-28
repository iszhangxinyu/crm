package cn.xy.crm.service;

import cn.xy.crm.domain.Task;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.TaskQueryObject;

import java.util.List;


public interface ITaskService {
	int save(Task task);
	int update(Task task);
	int delete(Long id);
	Task get(Long id);
	List<Task> selectAll();
	PageResult selectByCondition(TaskQueryObject qo);

    int change(Task todayTask);
}
