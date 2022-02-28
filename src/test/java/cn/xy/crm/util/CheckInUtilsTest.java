package cn.xy.crm.util;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhangxinyu
 * @version v1.0
 * @date created in 2022-02-19 12:45
 */
public class CheckInUtilsTest {

    @Test
    public void checkSignOutTime() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2022-01-19");

        Calendar normalSignOutTime = Calendar.getInstance();
        normalSignOutTime.setTime(new Date());
        normalSignOutTime.set(Calendar.HOUR_OF_DAY, 17);
        normalSignOutTime.set(Calendar.MINUTE, 30);
        normalSignOutTime.set(Calendar.SECOND, 0);
        String format = sdf.format(normalSignOutTime.getTime());
        System.out.println("format=" + format);

        int i = date.compareTo(normalSignOutTime.getTime());
        System.out.println(i);
    }

    @Test
    public void testString() {
        String s = "xcxc:index";
        int i = s.lastIndexOf(":");
        String substring = s.substring(0,i);
        System.out.println(substring);
    }
}