package abc.basic.knowledge.java8.localtime;

import org.junit.Test;

import java.time.*;

/**
 * @author Jim
 */
public class TestLocalDateTime {

    // 1. LocalDate  LocalTime  LocalDateTime
    @Test
    public void test() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = LocalDateTime.of(2100, 12, 31, 13, 22, 33);
        System.out.println(localDateTime1);

        LocalDateTime localDateTime2 = localDateTime.plusYears(2);
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = localDateTime.minusMonths(2);
        System.out.println(localDateTime3);

        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getSecond());
    }

    // 2. Instant : 时间戳(以Unix 元年: 1970年1月1日00:00:00到某个时间之间的毫秒值)
    @Test
    public void test2() {
        // 默认获取UTC 时区(世界协调时间 格林威治时间, 本初子午线)
        Instant instant = Instant.now();
        System.out.println(instant);

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        System.out.println(instant.toEpochMilli());

        Instant instant1 = Instant.ofEpochSecond(60);
        System.out.println(instant1);
    }

    // 3.
    // Duration : 计算两个"时间"之间的间隔
    @Test
    public void test3() throws InterruptedException {
        Instant instant1 = Instant.now();

        Thread.sleep(1000);

        Instant instant2 = Instant.now();

        Duration duration = Duration.between(instant1, instant2);
        System.out.println(duration.toMillis());
    }

    @Test
    public void test4() {
        LocalTime localTime1 = LocalTime.now();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LocalTime localTime2 = LocalTime.now();

        Duration duration = Duration.between(localTime1, localTime2);
        System.out.println(duration.toMillis());
    }

    // Period : 计算两个"日期"之间的间隔
    @Test
    public void test5() {
        LocalDate localDate1 = LocalDate.of(2015, 1, 1);

        LocalDate localDate2 = LocalDate.now();

        Period period = Period.between(localDate1, localDate2);
        System.out.println(period);

        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }
}
