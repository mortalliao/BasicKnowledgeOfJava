package abc.basic.knowledge.io.simpledateformat;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 * Date:表示特定的瞬间，精确到毫秒。
 *
 *  构造方法：
 *          Date():根据当前的默认毫秒值创建日期对象
 *          Date(long date)：根据给定的毫秒值创建日期对象
 *
 *  public long getTime():获取时间，以毫秒为单位
 *  public void setTime(long time):设置时间
 *
 *  从Date得到一个毫秒值
 *          getTime()
 *  把一个毫秒值转换为Date
 *          构造方法
 *          setTime(long time)
 *
 *
 *  SimpleDateFormat
 *
 *  Date     --  String(格式化)
 *          public final String format(Date date)
 *
 *   String -- Date(解析)
 *          public Date parse(String source)
 *
 *   DateForamt:可以进行日期和字符串的格式化和解析，但是由于是抽象类，所以使用具体子类SimpleDateFormat。
 *
 *  SimpleDateFormat的构造方法：
 *          SimpleDateFormat():默认模式
 *          SimpleDateFormat(String pattern):给定的模式
 *              这个模式字符串该如何写呢?
 *              通过查看API，我们就找到了对应的模式
 *                  年 y
 *                  月 M
 *                  日 d
 *                  时 H
 *                  分 m
 *                  秒 s
 *
 *  </pre>
 */
public class SimpleDateFormatTest {

    @Test
    public void test1() throws ParseException {
        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String s = sdf.format(date);
        System.out.println(s);

        String str = "2345-11-12 12:12:12";
        Date d = sdf.parse(str);
        System.out.println(d);
    }

    public static String dateToString(Date d, String format) {
        // SimpleDateFormat sdf = new SimpleDateFormat(format);
        // return sdf.format(d);
        return new SimpleDateFormat(format).format(d);
    }

    public static Date stringToDate(String s, String format)
            throws ParseException {
        return new SimpleDateFormat(format).parse(s);
    }
}
