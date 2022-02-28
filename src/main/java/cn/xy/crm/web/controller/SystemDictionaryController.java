package cn.xy.crm.web.controller;

import cn.xy.crm.domain.SystemDictionary;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.SystemDictionaryItemQueryObject;
import cn.xy.crm.query.SystemDictionaryQueryObject;
import cn.xy.crm.service.ISystemDictionaryItemService;
import cn.xy.crm.service.ISystemDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author xinyu
 */
@Controller
public class SystemDictionaryController {
    @Autowired
    private ISystemDictionaryService systemDictionaryService;
    @Autowired
    private ISystemDictionaryItemService systemDictionaryItemService;

    @RequestMapping("/systemDictionary")
    public String index() {
        return "systemDictionary";
    }

    @RequestMapping("/systemDictionaryList")
    @ResponseBody
    public PageResult list(SystemDictionaryQueryObject qo) {
        return systemDictionaryService.queryForPage(qo);
    }

    @RequestMapping("/querySystemDictionaryItemById")
    @ResponseBody
    public PageResult itemList(SystemDictionaryItemQueryObject qo) {
        return systemDictionaryItemService.queryItemById(qo);
    }

    @RequestMapping("/sysDic_queryAllDic")
    @ResponseBody
    public List<SystemDictionary> queryAllDic() {
        return systemDictionaryService.selectAll();
    }
}
