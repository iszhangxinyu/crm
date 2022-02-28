package cn.xy.crm.web.controller;

import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.PermissionQueryObject;
import cn.xy.crm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author z-xy
 * @version v1.0
 * @date created in 2021-12-23 16:33
 */
@Controller
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/permission_list")
    @ResponseBody
    public PageResult permission_list(PermissionQueryObject qo) {
        PageResult pageResult = null;
        pageResult =  permissionService.queryByCondition(qo);
        return pageResult;
    }
}
