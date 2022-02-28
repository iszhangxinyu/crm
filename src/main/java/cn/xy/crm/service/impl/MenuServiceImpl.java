package cn.xy.crm.service.impl;

import cn.xy.crm.domain.Menu;
import cn.xy.crm.mapper.MenuMapper;
import cn.xy.crm.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author z-xy
 * @version v1.0
 * @date created in 2022-01-13 14:50
 */
@Service
public class MenuServiceImpl implements IMenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> queryForMenu() {
        return menuMapper.selectRoot();
    }
}
