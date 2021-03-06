package cn.xy.crm.web.controller;

import cn.xy.crm.domain.CustomerVO;
import cn.xy.crm.domain.Employee;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.CustomerChartQueryObject;
import cn.xy.crm.service.ICustomerChartService;
import cn.xy.crm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CustomerChartController2 {

    @Autowired
    ICustomerChartService customerService;

    CustomerChartQueryObject qq;

    @RequestMapping("/customerChart_pie2")
    @ResponseBody
    public List listYear1(CustomerChartQueryObject qo) {
        Employee employee = (Employee) UserContext.get().getSession().getAttribute(UserContext.USER_IN_SESSION);
        qo.setUserId(employee.getId());

        qo.setStatus(true);
        Map map = new HashMap();
        List list = new ArrayList();
        List<Object[]> datas = new ArrayList<>();
        CustomerVO vo = new CustomerVO();
        List<CustomerVO> listVO = customerService.selectPie(qo);
        for (CustomerVO customerVO : listVO) {
            datas.add(new Object[]{customerVO.getTime(), customerVO.getAmountCustomer()});
        }
        list.add(datas);
        return list;
    }

    @RequestMapping("/groupChart")
    @ResponseBody
    public List listYearChart(CustomerChartQueryObject qo) {
        Employee employee = (Employee) UserContext.get().getSession().getAttribute(UserContext.USER_IN_SESSION);
        qo.setUserId(employee.getId());

        qo.setStatus(true);
        Map map = new HashMap();
        List list = new ArrayList();
        List<String> time = new ArrayList();
        List<Long> amountCustomer = new ArrayList();
        time = customerService.selectTimeYear(qo);
        amountCustomer = customerService.selectAmountYear(qo);
        map.put("amountCustomers", amountCustomer);
        map.put("times", time);
        list.add(map);
        return list;
    }
    @RequestMapping("/ppp")
    @ResponseBody
    public CustomerChartQueryObject listYear11(CustomerChartQueryObject qo) {
        qo.setKeyword(qq.getKeyword());
        qo.setBeginDate(qq.getBeginDate());
        qo.setEndDate(qq.getEndDate());
        qo.setTypee(qq.getTypee());

        return qo;
    }


    @RequestMapping("/customerChart2_list")
    @ResponseBody
    public PageResult listChart(CustomerChartQueryObject qo) {
        Employee employee = (Employee) UserContext.get().getSession().getAttribute(UserContext.USER_IN_SESSION);
        qo.setUserId(employee.getId());
        PageResult result = null;
        try {
            qo.setStatus(true);
            result = customerService.selectByCondition(qo);

            qq = qo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping("/customerChart")
    public String indexChart() {
        return "customerChart2";
    }

    @RequestMapping("/customerChart2_pictrue1")
    public String pictrue2(CustomerChartQueryObject qo, HttpServletRequest request) {
        getTime(qo,request);
        return "customerChartLine";
    }

    @RequestMapping("/customerChart2_pictrue2")
    public String pictrue1(CustomerChartQueryObject qo, HttpServletRequest request) {
        getTime(qo,request);
        return "customerChartPic";
    }

    @RequestMapping("/customerChart2_pictrue3")
    public String pictrue3(CustomerChartQueryObject qo, HttpServletRequest request) {
        getTime(qo,request);
        return "customerChartCloumn";
    }

    public static void getTime(CustomerChartQueryObject qo, HttpServletRequest request){
        Employee employee = (Employee) UserContext.get().getSession().getAttribute(UserContext.USER_IN_SESSION);
        qo.setUserId(employee.getId());

        request.setAttribute("userId",qo.getUserId());
    }


}


