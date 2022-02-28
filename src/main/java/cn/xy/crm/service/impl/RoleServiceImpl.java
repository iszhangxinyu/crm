package cn.xy.crm.service.impl;

import cn.xy.crm.domain.Permission;
import cn.xy.crm.domain.Role;
import cn.xy.crm.mapper.EmployeeMapper;
import cn.xy.crm.mapper.RoleMapper;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.RoleQueryObject;
import cn.xy.crm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author z-xy
 * @version v1.0
 * @date created in 2021-12-23 21:36
 */
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public int save(Role role) {
        int effect = roleMapper.insert(role);
        for (Permission permission : role.getPermissionList()) {
            roleMapper.addRelation(role.getId(), permission.getId());
        }
        return effect;
    }

    /**
     * 要删除一个角色，要考虑
     * 分配给用户的角色关系列表，分配给角色的权限关系列表
     * 使用外键关联，这样不用考虑这些问题
     * @param rid
     * @return
     */
    @Override
    public int delete(Long rid) {
        return roleMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public int update(Role role) {
        return 0;
    }

    @Override
    public Role get(Long rid) {
        return null;
    }

    @Override
    public PageResult queryRoleForPage(RoleQueryObject qo) {
        Long total = roleMapper.queryRoleCount(qo);
        if (total == 0L) {
            return PageResult.EMPTY;
        }
        List<Role> roleList = roleMapper.queryRoleForPage(qo);
        return new PageResult(total, roleList);
    }

    @Override
    public int modifyRoleInfo(Role role) {
        // 修改角色的信息
        int effect = roleMapper.updateByPrimaryKey(role);
        // 删除旧的权限的信息
        roleMapper.deleteRelationByRid(role.getId());
        // 添加新的
        for (Permission permission : role.getPermissionList()) {
            roleMapper.addRelation(role.getId(), permission.getId());
        }
        return effect;
    }

    @Override
    public List<Role> queryRoleForEmp() {
        return roleMapper.selectAll();
    }
}
