package cn.xy.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xy.crm.domain.Know;
import cn.xy.crm.page.AjaxResult;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.KnowQueryObject;
import cn.xy.crm.service.IKnowService;
@Controller
public class KnowController {
	@Autowired
    private IKnowService KnowService;
/*	@RequestMapping("/know_list")
	@ResponseBody
	public List<Know> list(){
		List<Know> result = null;
		result = KnowService.selectAll();
		return result;
	}*/
	
	@RequestMapping("/know_list")
	@ResponseBody
	public PageResult list(KnowQueryObject qo){
		PageResult result = null;
		if(qo.getKeyword() != null&& !"".equals(qo.getKeyword())){
			result = KnowService.querySearch(qo);
		}else{
			result = KnowService.query(qo);
		}
		return result;
	}
	
	
	
	@RequestMapping("/konw_listAll")
	@ResponseBody
	public Know listAll(Long id){
		Know result  = null;
		result = KnowService.queryContextById(id);
		return result;
	}
	


}
