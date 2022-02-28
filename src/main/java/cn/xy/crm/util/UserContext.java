package cn.xy.crm.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author z-xy
 * @version v1.0
 * @date created in 2021-12-19 15:04
 */
public class UserContext {
    /**
     * 当前登录用户session
     */
    public static final String USER_IN_SESSION = "USER_IN_SESSION";

    /**
     * 当前登录用户权限session
     */
    public static final String PERMISSION_IN_SESSION = "PERMISSION_IN_SESSION";

    public static final String MENU_IN_SESSIOIN = "MENU_IN_SESSION";

    /**
     * 服务器为每个用户开启一个线程，把每个用户的请求保存到自己的线程中
     */
    private static ThreadLocal<HttpServletRequest> tl = new ThreadLocal<>();

    public static void set(HttpServletRequest request) {
        tl.set(request);
    }

    public static HttpServletRequest get() {
        return tl.get();
    }
}
