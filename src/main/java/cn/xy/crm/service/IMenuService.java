package cn.xy.crm.service;

import cn.xy.crm.domain.Menu;

import java.util.List;

/**
 * @author z-xy
 * @version v1.0
 * @date created in 2022-01-13 14:44
 */
public interface IMenuService {
    /**
     * 查询所有的一级菜单
     * @return
     */
    List<Menu> queryForMenu();
}
