package cn.xy.crm.service;

import cn.xy.crm.domain.Salary;
import cn.xy.crm.page.PageResult;
import cn.xy.crm.query.QueryObject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ISalaryService {


    int save(Salary salary);

    int delete(Long id);

    Salary get(Long id);

    int update(Salary salary);

    List<Salary> listAll();

    /**
     *
     * @param qo
     * @return
     */
    PageResult queryByCondition(QueryObject qo);

    /**
     *
     * @param id
     * @return
     */
    PageResult querySalaryByEid(Long id);


    /**
     * 上传工资表
     * @param file
     */
    void uploadSalary(MultipartFile file);


}
