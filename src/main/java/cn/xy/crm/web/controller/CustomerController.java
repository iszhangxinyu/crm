package cn.xy.crm.web.controller;

import cn.xy.crm.domain.Customer;
import cn.xy.crm.domain.CustomerTransfer;
import cn.xy.crm.domain.Employee;
import cn.xy.crm.domain.SystemDictionaryItem;
import cn.xy.crm.page.AjaxResult;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.CustomerQueryObject;
import cn.xy.crm.service.*;
import cn.xy.crm.util.RequiredPermission;
import cn.xy.crm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 *
 * @author  zhangxinyu
 * @date 2016/9/19
 */
@Controller
public class CustomerController extends BaseController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private ICustomerTransferService transferService;

    @Autowired
    private IEmployeeService employeeService;


    @Autowired
    private ISystemDictionaryItemService systemDictionaryItemService;

    @RequiredPermission("查看正式客户")
    @RequestMapping("/customer")
    public String index() {
        return "customer";
    }

    /**
     * 客户信息列表
     * @param qo
     * @return
     */
    @RequestMapping("/customer_list")
    @ResponseBody
    public PageResult list(CustomerQueryObject qo) {
        PageResult result = null;
        Employee e = (Employee) UserContext.get().getSession().getAttribute(UserContext.USER_IN_SESSION);
        try {
            qo.setUserId(e.getId());
            result = customerService.queryCustomerByCondition(qo);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return result;
    }

    /**
     * 客户来源等信息字典项
     * @param sn
     * @return
     */
    @RequestMapping("/customer_query")
    @ResponseBody
    public List<SystemDictionaryItem> queryBySn(String sn) {
        return systemDictionaryItemService.queryBySn(sn);

    }

    /**
     * 新增客户
     * @param c
     * @return
     */
    @RequestMapping("/customer_save")
    @ResponseBody
    public AjaxResult save(Customer c) {
        Employee employee = getCurrentLoginUseer();

        AjaxResult result = null;
        try {
            c.setStatus(0);
            c.setInputtime(new Date());
            c.setInputuser(employee);
            c.setInchargeuser(employee);
            int effectCount = customerService.save(c);

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

    @RequestMapping("/customer_update")
    @ResponseBody
    public AjaxResult update(Customer c) {
        AjaxResult result = null;
        try {
            c.setStatus(0);
            int effectCount = customerService.update(c);

            if (effectCount > 0) {
                result = new AjaxResult(true, "更新成功");
            } else {
                result = new AjaxResult(true, "更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(true, "更新异常");
        }

        return result;
    }

    /**
     * 为定金订单模块，添加订单查询客户
     * @return
     */
    @RequestMapping("/customer_queryForOrder")
    @ResponseBody
    public PageResult queryForOrder() {
        PageResult result = null;
        result = customerService.selectForOrder();
        return result;
    }

    private Employee getCurrentLoginUseer() {
        return (Employee) UserContext.get().getSession().getAttribute(UserContext.USER_IN_SESSION);
    }


    /**
     * 市场专员可共享客户给其他专员
     * 销售主管可移交客户给市场专员
     * @param c
     * @param inchargeId
     * @param reason
     * @return
     */
    @RequestMapping("/customer_updateInCharge")
    @ResponseBody
    public AjaxResult updateInCharge(Customer c, Long inchargeId, String reason) {
        // 获取当前登录对象
        Employee employee = this.getCurrentLoginUseer();
        AjaxResult result = null;
        if (c.getInchargeuser().getId().equals(inchargeId)) {
            result = new AjaxResult(false, "您不能自己共享或移交给自己");
            return result;
        }
        try {
            //创建移交对象,用于保存移交记录
            CustomerTransfer transfer = new CustomerTransfer();
            transfer.setCustomer(c);
            transfer.setOldseller(c.getInchargeuser());
            transfer.setNewseller(employeeService.get(inchargeId));
            transfer.setTranstime(new Date());
            transfer.setTransuser(employee);
            transfer.setTransreason(reason);
            // 创建移交记录
            transferService.save(transfer);

            int effectCount = customerService.updateByChargeId(c.getId(), inchargeId);
            if (effectCount > 0) {
                result = new AjaxResult(true, "操作成功");
            } else {
                result = new AjaxResult(false, "操作失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "操作异常");
        }

        return result;

    }

    /**
     * 将无法跟进的客户移入资源池
     * @param id 客户id
     * @return
     */
    @RequestMapping("/customer_moveResourcepool")
    @ResponseBody
    public AjaxResult moveToResourcePool(Long id) {
        // 获取当前登录对象
        Employee employee = this.getCurrentLoginUseer();
        AjaxResult result = null;
        try {
            int effectCount = customerService.moveToResourcePool(employee.getId(), id);
            if (effectCount > 0) {
                result = new AjaxResult(true, "操作成功");
            } else {
                result = new AjaxResult(true, "操作失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(true, "操作异常");
        }

        return result;
    }


    /**
     * 流失客户
     * @param id
     * @return
     */
    @RequestMapping("/customer_lost")
    @ResponseBody
    public AjaxResult customerLost(Long id) {
        // 获取当前登录对象
        Employee employee = this.getCurrentLoginUseer();
        AjaxResult result = null;
        try {
            int effectCount = customerService.lostCustomer(employee.getId(), id);
            if (effectCount > 0) {
                result = new AjaxResult(true, "操作成功");
            } else {
                result = new AjaxResult(true, "操作失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(true, "操作异常");
        }

        return result;
    }

    /**
     * 导出客户信息
     * @param response
     * @return
     */
    @RequestMapping("/customer_export")
    @ResponseBody
    public AjaxResult export(HttpServletResponse response) {
        AjaxResult result = null;
        try {
            response.setHeader("Content-Disposition", "attachment;filename=SignInTable.xls");
            ServletOutputStream outputStream = response.getOutputStream();
            int effectRows = customerService.exportCustomer(outputStream);
            if (effectRows > 0) {
                result = new AjaxResult(true, "导出成功");
            } else {
                result = new AjaxResult(false, "导出失败 ! 请关闭该文件后重新导出 !");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            result = new AjaxResult(false, "导出异常");
        }
        return result;
    }


}
