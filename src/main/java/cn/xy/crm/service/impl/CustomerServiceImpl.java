package cn.xy.crm.service.impl;

import cn.xy.crm.domain.Customer;
import cn.xy.crm.mapper.CustomerMapper;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.CustomerQueryObject;
import cn.xy.crm.query.CustomerResourcePoolQueryObject;
import cn.xy.crm.query.PotentialCustomerQueryObject;
import cn.xy.crm.query.QueryObject;
import cn.xy.crm.service.ICustomerService;
import cn.xy.crm.util.PermissionUtils;
import jxl.Workbook;
import jxl.write.Alignment;
import jxl.write.Label;
import jxl.write.VerticalAlignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Administrator on 2016/9/15.
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerMapper dao;

    @Override
    public int save(Customer c) {

        return dao.insert(c);
    }

    @Override
    public int delete(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public Customer get(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public int update(Customer e) {

        return dao.updateByPrimaryKey(e);
    }

    @Override
    public PageResult listAll() {
        return new PageResult(Long.parseLong(dao.selectAll().size() + ""), dao.selectAll());
    }


    /**
     * 潜在客户高级查询+分页
     *
     * 市场专员只能查询自己负责的潜在客户，销售主管可以查看所有
     *
     * @param qo 页面查询参数对象
     */
    @Override
    public PageResult queryByCondition(QueryObject qo) {
        String permission = "cn.xy.crm.web.controller.PotentialCustomerController:ALL";
        // 如果是营销主管的话可以查询所有
        if (PermissionUtils.checkPermission(permission)) {
            PotentialCustomerQueryObject customerQo = (PotentialCustomerQueryObject) qo;
            customerQo.setUserId(null);
        }
        // 根据查询条件查询出总条数
        Long count = dao.queryByConditionCount(qo);
        if (count == 0) {
            return PageResult.EMPTY;
        } else {
            // 返回查询的结果集
            List<Customer> listData = dao.queryByCondition(qo);
            return new PageResult(count, listData);
        }
    }

    /**
     * 潜在客户  sql默认状态是0
     * 正式客户资源池高级查询
     *
     * @param qo
     * @return
     */
    @Override
    public PageResult queryCustomerByCondition(QueryObject qo) {
        // 如果是营销主管的话可以查询所有
        if (PermissionUtils.checkPermission("cn.xy.crm.web.controller.CustomerController:all")) {
            CustomerQueryObject customerQo = (CustomerQueryObject) qo;
            customerQo.setUserId(null);
        }
        // 根据查询条件查询出总条数
        Long count = dao.queryCustomerByConditionCount(qo);
        if (count == 0) {
            return PageResult.EMPTY;
        } else {
            // 返回查询的结果集
            List<Customer> listData = dao.queryCustomerByCondition(qo);
            return new PageResult(count, listData);
        }

    }

    @Override
    public PageResult queryResourcePoolByCondition(QueryObject qo) {
        // 所有用户都可以查询到资源池的内容
        CustomerResourcePoolQueryObject customerQo = (CustomerResourcePoolQueryObject) qo;
        customerQo.setUserId(null);
        // 根据查询条件查询出总条数
        Long count = dao.queryResourcePoolByConditionCount(qo);
        if (count == 0) {

            return PageResult.EMPTY;
        } else {
            // 返回查询的结果集
            List<Customer> listData = dao.queryResourcePoolByCondition(qo);
            return new PageResult(count, listData);
        }
    }

    //根据负责人的ID取到潜在用户的列表
    @Override
    public PageResult selectByinChargeId(Long userId) {
        return new PageResult(Long.parseLong(dao.selectByinChargeId(userId).size() + ""),
                dao.selectByinChargeId(userId));

    }


    @Override
    public List<Customer> selectAll() {
        return dao.selectAll();
    }

    @Override
    public int exportCustomer(ServletOutputStream outputStream) {
        WritableWorkbook wb = null;
        WritableSheet sheet = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 1.需要建立一个Excel工作的对象
        try {
            wb = Workbook.createWorkbook(outputStream);
            // 2.创建sheet主页
            sheet = wb.createSheet("第一个sheet页", 0);

            //定义高和宽
            sheet.setColumnView(1, 20);
            sheet.setRowView(1, 200);
            //设置普通格式化
            WritableCellFormat st = new WritableCellFormat();
            //设置单元格风格
            st.setAlignment(Alignment.CENTRE);
            st.setVerticalAlignment(VerticalAlignment.CENTRE);

            // 查询数据库中所有的数据
            List<Customer> list = dao.listAllFormalCustomer();
            // 要插入到的Excel表格的行号，默认从0开始
            Label labelSn = new Label(0, 0, "编号");// 表示第
            Label labelNname = new Label(1, 0, "姓名");
            Label labelAge = new Label(2, 0, "年龄");
            Label labelSex = new Label(3, 0, "性别");
            Label labelTel = new Label(4, 0, "电话");
            Label labelEmail = new Label(5, 0, "邮箱");
            Label labelQQ = new Label(6, 0, "QQ");
            Label labelwechat = new Label(7, 0, "微信");
            Label labeljob = new Label(8, 0, "职业");
            Label labelsalaryLevel = new Label(9, 0, "收入水平");
            Label labelSource = new Label(10, 0, "客户来源");
            Label labelInputtime = new Label(11, 0, "创建时间");
            Label labelstatus = new Label(12, 0, "状态");
            Label labelBecomeTime = new Label(13, 0, "转正时间");
            Label labelInputUser = new Label(14, 0, "创建人");
            Label labelInputCharguser = new Label(15, 0, "负责人");

            sheet.addCell(labelSn);
            sheet.addCell(labelNname);
            sheet.addCell(labelAge);
            sheet.addCell(labelSex);
            sheet.addCell(labelTel);
            sheet.addCell(labelEmail);
            sheet.addCell(labelQQ);
            sheet.addCell(labelwechat);
            sheet.addCell(labeljob);
            sheet.addCell(labelsalaryLevel);
            sheet.addCell(labelSource);
            sheet.addCell(labelInputtime);
            sheet.addCell(labelstatus);
            sheet.addCell(labelBecomeTime);
            sheet.addCell(labelInputUser);
            sheet.addCell(labelInputCharguser);
            for (int i = 0; i < list.size(); i++) {
                Label labelSn_i = new Label(0, i + 1, list.get(i).getId()
                        + "", st);
                Label labelName_i = new Label(1, i + 1, list.get(i).getName()
                        + "", st);
                Label labelAge_i = new Label(2, i + 1, list.get(i).getAge()
                        + "", st);
                Label labelSex_i = new Label(3, i + 1, list.get(i).getGender()
                        + "", st);
                Label labelTel_i = new Label(4, i + 1, list.get(i).getTel()
                        + "", st);
                Label labelEmail_i = new Label(5, i + 1, list.get(i).getEmail()
                        + "", st);
                Label labelQQ_i = new Label(6, i + 1, list.get(i).getQq()
                        + "", st);
                Label labelwechat_i = new Label(7, i + 1, list.get(i).getWechat()
                        + "", st);
                Label labeljob_i = new Label(8, i + 1, list.get(i).getJob()
                        + "", st);
                Label labelsalaryLevel_i = new Label(9, i + 1, list.get(i).getSalarylevel()
                        + "", st);
                Label labelSource_i = new Label(10, i + 1, list.get(i).getCustomersource()
                        + "", st);
                String inputtime = sdf.format(list.get(i).getInputtime());
                Label labelInputtime_i = new Label(11, i + 1, inputtime);

                Label labelstatus_i = new Label(12, i + 1, list.get(i).getStatus()
                        + "", st);
                String becometime = sdf.format(list.get(i).getBecometime());
                Label labelBecometime_i = new Label(13, i + 1, becometime);
                Label labelInputUser_i = new Label(14, i + 1, list.get(i).getInputuser().getUsername(), st);
                Label labelInputCharguser_i = new Label(15, i + 1, list.get(i).getInchargeuser().getUsername(), st);
                sheet.addCell(labelSn_i);
                sheet.addCell(labelName_i);
                sheet.addCell(labelAge_i);
                sheet.addCell(labelSex_i);
                sheet.addCell(labelTel_i);
                sheet.addCell(labelEmail_i);
                sheet.addCell(labelQQ_i);
                sheet.addCell(labelwechat_i);
                sheet.addCell(labeljob_i);
                sheet.addCell(labelsalaryLevel_i);
                sheet.addCell(labelSource_i);
                sheet.addCell(labelInputtime_i);
                sheet.addCell(labelstatus_i);
                sheet.addCell(labelBecometime_i);
                sheet.addCell(labelInputUser_i);
                sheet.addCell(labelInputCharguser_i);
            }
            // 写进文档
            wb.write();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            // 关闭Excel工作簿对象
            try {
                if (wb != null) {
                    wb.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public int updateByChargeId(Long id, Long inchargeId) {
        return dao.updateByChargeId(id, inchargeId);
    }

    @Override
    public int updateStatusFalseById(Long id) {
        return dao.updateStatusFalseById(id);
    }

    @Override
    public int updateStatusSuccessById(Long id) {
        return dao.updateStatusSuccessById(id);
    }

    @Override
    public int customerAdmit(Long inchargeId, Long id) {
        return dao.customerAdmit(inchargeId, id);
    }

    @Override
    public int moveToResourcePool(Long inchargeId, Long id) {
        return dao.moveToResourcePool(inchargeId, id);
    }

    @Override
    public int lostCustomer(Long inChargeId, Long id) {
        return dao.lostCustomer(inChargeId, id);
    }


    @Override
    public PageResult selectForOrder() {
        Long total = dao.selectAllCount();
        List<Customer> rows = dao.selectAll();
        return new PageResult(total, rows);
    }
}


