package cn.xy.crm.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xy.crm.domain.CheckIn;
import cn.xy.crm.domain.Employee;
import cn.xy.crm.page.AjaxResult;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.CheckInQueryObject;
import cn.xy.crm.service.ICheckInService;
import cn.xy.crm.util.PermissionUtils;
import cn.xy.crm.util.RequiredPermission;
import cn.xy.crm.util.UserContext;

@Controller
public class FastCheckInController extends BaseController {

	@Autowired
	private ICheckInService checkInService;

	@RequestMapping("/fastCheckIn")
	public String index() {
		return "fastCheckIn";
	}

}
