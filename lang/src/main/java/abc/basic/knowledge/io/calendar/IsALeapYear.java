package abc.basic.knowledge.io.calendar;

import org.junit.Test;

import java.util.Calendar;
import java.util.Scanner;

/**
 * <pre>
 * Calendar:它为特定瞬间与一组诸如 YEAR、MONTH、DAY_OF_MONTH、HOUR 等 日历字段之间的转换提供了一些方法，
 *
 * 并为操作日历字段（例如获得下星期的日期）提供了一些方法。(月份从零开始数起)
 *
 * public int get(int field):返回给定日历字段的值。日历类中的每个日历字段都是静态的成员变量，并且是int类型。
 * public void add(int field,int amount):根据给定的日历字段和对应的时间，来对当前的日历进行操作。
 * public final void set(int year,int month,int date):设置当前日历的年月日
 *
 *
 *  Calendar c = Calendar.getInstance();
 *  </pre>
 */
public class IsALeapYear {

    @Test
    public void test1() {
        // 输入年份
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        // 设置日历对象的年月日
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, 2, 1);// 3月一日

        // 把时间往前推一天
        calendar.add(Calendar.DATE, -1);

        System.out.println(calendar.get(Calendar.DATE));
    }
}
