package cn.xy.crm.mapper;

import cn.xy.crm.domain.Role;
import cn.xy.crm.query.RoleQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author z-xy
 */
public interface RoleMapper {
    /**
     * 根据id删除角色
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 删除rid对应的权限关系
     *
     * @param id
     * @return
     */
    int deleteRelationByRid(Long id);

    /**
     * 添加一个新的角色
     *
     * @param record
     * @return
     */
    int insert(Role record);

    Role selectByPrimaryKey(Long id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    void addRelation(@Param("rid") Long rid, @Param("pid") Long pid);

    Long queryRoleCount(RoleQueryObject qo);

    List<Role> queryRoleForPage(RoleQueryObject qo);

    List<Role> queryRoleByEid(Long eid);

    List<Long> queryEmpIdsByRId(Long id);

    /**
     * 删除分配给用户的角色关系
     *
     * @param rid
     * @return
     */
    int deleteEmpRelationByRid(Long rid);
}