package cn.xy.crm.service;

import cn.xy.crm.domain.Role;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.RoleQueryObject;

import java.util.List;

/**
 * @author z-xy
 * @version v1.0
 * @date created in 2021-12-23 21:35
 */
public interface IRoleService {
    int save(Role role);

    int delete(Long rid);

    int update(Role role);

    Role get(Long rid);

    /**
     * 获取指定用户的所有角色
     *
     * @param qo
     * @return
     */
    PageResult queryRoleForPage(RoleQueryObject qo);

    /**
     * 修改角色信息
     */
    int modifyRoleInfo(Role role);

    /**
     * 查询所有的角色信息
     * @return
     */
    List<Role> queryRoleForEmp();
}
