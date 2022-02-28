package cn.xy.crm.service.impl;

import cn.xy.crm.domain.Employee;
import cn.xy.crm.service.IEmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;

/**
 * 先测spring和mybatis,测试成功后测试springmvc
 *
 * @author z-xy
 * @version v1.0
 * @date created in 2021-12-19 10:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springmvc-context.xml")
public class EmployeeServiceImplTest {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Test
    public void testSave() {
        Employee employee = new Employee();
        employee.setUsername("zs");
        employee.setAdmin(false);
        employee.setEmail("xxx.@qq.com");
        employee.setInputtime(new Date(new java.util.Date().getTime()));
        employee.setPassword("1111");
        employee.setRealname("张三");
        employee.setState(true);
        employee.setTel("17839934036");

        iEmployeeService.save(employee);


    }
}