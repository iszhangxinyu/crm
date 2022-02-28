package cn.xy.crm.service;

import cn.xy.crm.domain.Permission;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.PermissionQueryObject;

import java.util.List;

/**
 * @author z-xy
 * @version v1.0
 * @date created in 2021-12-23 16:36
 */
public interface
IPermissionService {
    /**
     * 根据条件查询权限列表
     *
     * @param qo
     * @return
     */
    PageResult queryByCondition(PermissionQueryObject qo);

    /**
     * 获取角色对应的所有权限
     *
     * @param id
     * @return
     */
    PageResult queryPermissionsByRid(Long id);

    /**
     * 获取系统所有的权限对象
     * @return
     */
    List<Permission> selectAll();

    List<String> queryPermissionByEmpId(Long eid);

    Permission queryByResource(String function);
}
