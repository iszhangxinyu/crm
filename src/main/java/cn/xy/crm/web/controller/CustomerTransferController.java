package cn.xy.crm.web.controller;

import cn.xy.crm.domain.Customer;
import cn.xy.crm.domain.CustomerTransfer;
import cn.xy.crm.domain.Employee;
import cn.xy.crm.page.AjaxResult;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.CustomerTransferQueryObject;
import cn.xy.crm.service.ICustomerService;
import cn.xy.crm.service.ICustomerTransferService;
import cn.xy.crm.service.IEmployeeService;
import cn.xy.crm.util.RequiredPermission;
import cn.xy.crm.util.UserContext;
import cn.xy.crm.vo.CustomerTransferVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 市场经理移交专员手中的客户，需要记录移交的原因细节
 *
 * @author zhangxinyu
 */
@Controller
public class CustomerTransferController extends BaseController {

    @Autowired
    private ICustomerTransferService customerTransferService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IEmployeeService employeeService;

    @RequiredPermission("查看客户移交")
    @RequestMapping("/customerTransfer")
    public String index() {
        return "customerTransfer";
    }

    /**
     * 移交正式客户
     *
     * @param qo
     * @return
     */
    @RequestMapping("/customerTransfer_list")
    @ResponseBody
    public PageResult list(CustomerTransferQueryObject qo) {
        PageResult result = null;
        result = customerTransferService.queryByCondition(qo);
        return result;
    }


    @RequestMapping("/customerTransfer_save")
    @ResponseBody
    public AjaxResult save(CustomerTransferVO vo) {
        Employee employee = (Employee) UserContext.get().getSession().getAttribute(UserContext.USER_IN_SESSION);
        AjaxResult result = null;
        // 移交的客户
        Customer c = customerService.get(vo.getCustomerId());
        // 新市场专员
        Employee emp = employeeService.get(vo.getInchargeuserId());
        try {
            //创建移交对象
            CustomerTransfer transfer = new CustomerTransfer();
            transfer.setCustomer(c);
            transfer.setOldseller(c.getInchargeuser());
            transfer.setNewseller(emp);
            transfer.setTranstime(new Date());
            transfer.setTransuser(employee);
            transfer.setTransreason(vo.getReason());
            // 创建移交记录
            customerTransferService.save(transfer);

            // 根据客户的ID去修改该客户的市场专员
            int effectCount = customerService.updateByChargeId(c.getId(), vo.getInchargeuserId());
            if (effectCount > 0) {
                result = new AjaxResult(true, "保存成功");
            } else {
                result = new AjaxResult(true, "保存失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(true, "保存异常");
        }

        return result;
    }

}


