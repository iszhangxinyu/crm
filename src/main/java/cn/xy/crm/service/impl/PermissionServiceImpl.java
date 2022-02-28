package cn.xy.crm.service.impl;

import cn.xy.crm.domain.Permission;
import cn.xy.crm.mapper.PermissionMapper;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.PermissionQueryObject;
import cn.xy.crm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author z-xy
 * @version v1.0
 * @date created in 2021-12-23 16:36
 */
@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public PageResult queryByCondition(PermissionQueryObject qo) {
        Long count = permissionMapper.queryByConditionCount(qo);
        if (count == 0L) {
            return PageResult.EMPTY;
        }
        List<Permission> permissionList = permissionMapper.queryByCondition(qo);
        return new PageResult(count, permissionList);
    }

    @Override
    public PageResult queryPermissionsByRid(Long id) {
        Long total = permissionMapper.queryCountForRole(id);
        if (total == 0L) {
            return PageResult.EMPTY;
        }
        List<Permission> permissionList = permissionMapper.queryPermissionsForRole(id);
        return new PageResult(total, permissionList);
    }

    @Override
    public List<Permission> selectAll() {
        return permissionMapper.selectAll();
    }

    @Override
    public List<String> queryPermissionByEmpId(Long eid) {
        return permissionMapper.queryPermissionByEmpId(eid);
    }

    @Override
    public Permission queryByResource(String function) {
        return permissionMapper.queryByResource(function);
    }
}
