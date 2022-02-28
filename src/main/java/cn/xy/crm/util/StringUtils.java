package cn.xy.crm.util;

/**
 * Created by Administrator on 2016/9/23.
 */
public class StringUtils {

    public static Boolean hasLength(String str) {
        return str != null && !"".equals(str.trim());
    }
}
