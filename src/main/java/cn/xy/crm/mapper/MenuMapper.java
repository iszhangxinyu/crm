package cn.xy.crm.mapper;

import cn.xy.crm.domain.Menu;

import java.util.List;

public interface MenuMapper {
    /**
     * 查询所有的根节点
     *
     * @return
     */
    List<Menu> selectRoot();

    /**
     * 根据父节点查所有的子节点
     * @param pid
     * @return
     */
    List<Menu> selectByPid(Long pid);

}