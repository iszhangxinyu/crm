package cn.xy.crm.mapper;

import cn.xy.crm.domain.Permission;
import cn.xy.crm.query.PermissionQueryObject;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    Permission selectByPrimaryKey(Long id);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);

    Long queryByConditionCount(PermissionQueryObject qo);

    List<Permission> queryByCondition(PermissionQueryObject qo);

    Long queryCountForRole(Long id);

    List<Permission> queryPermissionsForRole(Long id);

    List<String> queryPermissionByEmpId(Long eid);

    Permission queryByResource(String function);
}