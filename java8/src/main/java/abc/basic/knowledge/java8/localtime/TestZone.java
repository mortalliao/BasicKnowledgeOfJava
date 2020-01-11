package abc.basic.knowledge.java8.localtime;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * @author Jim
 *
 * <pre>
 *
 *     带时区的时间为分别为: ZonedDate, ZonedTime, ZonedDateTime
 *
 *     其中每个时区都对应着ID, 地区ID都为"{区域}/{城市}"的格式, 例如: Asia/Shangehai等
 *
 *     ZoneId : 该类中包含了所有的时区信息
 *          getAvaliableZoneIds() : 可以获取所有时区信息
 *          of(id) : 用指定的时区信息获取ZoneId对象
 *
 * </pre>
 */
public class TestZone {

    @Test
    public void test1() {
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);
    }

    @Test
    public void test2() {
        LocalDateTime localDateTime1 = LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
        System.out.println(localDateTime1);

        LocalDateTime localDateTime2 = LocalDateTime.now();
        ZonedDateTime zonedDateTime = localDateTime2.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime);

        ZonedDateTime zonedDateTime1 = localDateTime2.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime1);
    }

}
