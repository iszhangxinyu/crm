package cn.xy.crm.web.interceptor;

import cn.xy.crm.domain.Employee;
import cn.xy.crm.util.PermissionUtils;
import cn.xy.crm.util.UserContext;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录拦截器
 * <p>
 * 拦截未登录用户，已登录用户判断其权限
 *
 * @author z-xy
 * @version v1.0
 * @date created in 2021-12-19 15:38
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Employee emp = (Employee) request.getSession().getAttribute(UserContext.USER_IN_SESSION);
        // 请求保存请求到当前线程中
        UserContext.set(request);
        if (emp == null) {
            response.sendRedirect("/login.jsp");
            return false;
        } else {
            // 静态资源不需要权限控制，只有handler是HandlerMethod类型才需要访问控制器的方法
            if (handler instanceof HandlerMethod) {
                HandlerMethod hm = (HandlerMethod) handler;
                String className = hm.getBean().getClass().getName();
                String methodName = hm.getMethod().getName();
                String function = className + ":" + methodName;
                if (PermissionUtils.checkPermission(function)) {
                    return true;
                } else {
                    // 普通请求定向到noPermission.jsp界面
                    // ajax请求返回json数据
                    if (hm.getMethod().isAnnotationPresent(ResponseBody.class)) {
                        response.sendRedirect("/nopermission.json");
                    } else {
                        response.sendRedirect("/nopermission.jsp");
                    }
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {

    }
}
