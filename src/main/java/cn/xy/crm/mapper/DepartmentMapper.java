package cn.xy.crm.mapper;

import cn.xy.crm.domain.Department;
import cn.xy.crm.query.DepartmentQueryObject;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Department record);

    Department selectByPrimaryKey(Long id);

    List<Department> selectAll();

    int updateByPrimaryKey(Department record);

    Long queryCount(DepartmentQueryObject qo);

    List<Department> queryPage(DepartmentQueryObject qo);

    List<Department> selectRoot();

    List<Department> seletByPid();

    List<Department> getByMid(Long id);
}