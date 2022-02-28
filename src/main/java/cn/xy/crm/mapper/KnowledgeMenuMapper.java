package cn.xy.crm.mapper;

import cn.xy.crm.domain.KnowledgeMenu;
import cn.xy.crm.domain.Menu;

import java.util.List;

public interface KnowledgeMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(KnowledgeMenu record);

    KnowledgeMenu selectByPrimaryKey(Long id);

    List<KnowledgeMenu> selectAll();

    int updateByPrimaryKey(KnowledgeMenu record);
    //查询父菜单
    List<KnowledgeMenu> selectRoot();
    //查询子菜单
    List<KnowledgeMenu> selectByPid();
}