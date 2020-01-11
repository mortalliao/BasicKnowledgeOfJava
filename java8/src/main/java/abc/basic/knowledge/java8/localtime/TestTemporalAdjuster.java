package abc.basic.knowledge.java8.localtime;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @author Jim
 *
 * <pre>
 *
 *     TemporalAdjuster : 时间校正器, 例如: 将日期调整到"下周日"等操作
 *
 *     TemportalAdjusters : 该类通过静态方法提供了大量的常用TemporalAdjuster的实现
 *
 * </pre>
 */
public class TestTemporalAdjuster {

    // 任意指定
    @Test
    public void test1() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(10);
        System.out.println(localDateTime1);

        LocalDateTime localDateTime2 = localDateTime.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(localDateTime2);

        //自定义: 下一个工作日
        LocalDateTime localDateTime4 = localDateTime.with((l) -> {
            LocalDateTime localDateTime3 = (LocalDateTime) l;
            DayOfWeek dayOfWeek = localDateTime3.getDayOfWeek();

            if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
                return localDateTime3.plusDays(3);
            } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                return localDateTime3.plusDays(2);
            } else {
                return localDateTime3.plusDays(1);
            }
        });
        System.out.println(localDateTime4);
    }

    // DateTimeFormatter : 格式化时间/日期
    @Test
    public void test2() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE;
        LocalDateTime localDateTime = LocalDateTime.now();

        String strDate = localDateTime.format(dateTimeFormatter);
        System.out.println(strDate);
    }

    @Test
    public void test3() {
        LocalDateTime localDateTime = LocalDateTime.now();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String strDate = dateTimeFormatter.format(localDateTime);
        System.out.println(strDate);

        LocalDateTime newLocalDateTime = LocalDateTime.parse(strDate);
        System.out.println(newLocalDateTime);

    }
}
