package cn.xy.crm.util;

import cn.xy.crm.domain.Employee;
import cn.xy.crm.domain.Log;
import cn.xy.crm.service.ILogService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 日志
 *
 * @author z-xy
 * @version v1.0
 * @date created in 2021-12-21 22:15
 */
public class LogUtil {

    @Autowired
    private ILogService logService;

    /**
     * 后置通知
     */
    public void writeLog(JoinPoint joinPoint) {
        // 日志的业务不能执行后置通知，否则会导致死循环
        if (joinPoint.getTarget() instanceof ILogService) {
            return;
        }
        Log log = new Log();
        HttpServletRequest currentRequest = UserContext.get();
        Employee currentEmployee = (Employee) currentRequest.getSession().getAttribute(UserContext.USER_IN_SESSION);
        log.setEmployee(currentEmployee);
        log.setOpip(currentRequest.getRemoteAddr());
        log.setOptime(new Date());
        // 被代理类：cn.xy.crm.service.impl.EmployeeServiceImpl@6e765246
        Object target = joinPoint.getTarget();
        // 方法签名：Employee cn.xy.crm.service.IEmployeeService.queryByLogin(String,String),无法显示参数名称
        Signature signature = joinPoint.getSignature();
        // cn.xy.crm.service.impl.EmployeeServiceImpl queryByLogin
        String function = target.getClass().getName() + ":" + signature.getName();
        // String[] parameterNames = ((MethodSignature) signature).getParameterNames();
        log.setFunction(function);
        Object[] args = joinPoint.getArgs();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // 不序列空值
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            String params = objectMapper.writeValueAsString(args);
            log.setParams(params);
            logService.save(log);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
