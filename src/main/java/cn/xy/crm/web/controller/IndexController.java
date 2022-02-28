package cn.xy.crm.web.controller;

import cn.xy.crm.domain.Employee;
import cn.xy.crm.domain.Menu;
import cn.xy.crm.service.IMenuService;
import cn.xy.crm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author z-xy
 * @version v1.0
 * @date created in 2021-12-19 14:10
 */
@Controller
public class IndexController {
    @Autowired
    private IMenuService menuService;
    @RequestMapping("/index")
    public String index(Model model) {
        Employee current = (Employee) UserContext.get().getSession().getAttribute(UserContext.USER_IN_SESSION);
        model.addAttribute("current", current);
        return "index";
    }

    @RequestMapping("/queryForMenu")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public List<Menu> queryForMenu() {
        return (List<Menu>)UserContext.get().getSession().getAttribute(UserContext.MENU_IN_SESSIOIN);
    }
}
