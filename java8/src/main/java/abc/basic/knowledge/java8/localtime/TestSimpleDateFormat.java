package abc.basic.knowledge.java8.localtime;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Jim
 *
 * <pre>
 *
 *     LocalDate, LocalTime, LocalDateTime类的实例是不可变对象
 *     分别表示使用ISO-8601日历系统的日期, 时间, 日期和时间
 *     提供了简单的日期和时间, 并不包含当前的时间信息, 也不包含与时区相关的信息
 *
 *     注: ISO-8601日历系统是国际标准化组织制定的现代公民的日期和时间的表示法
 *
 * </pre>
 */
public class TestSimpleDateFormat {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        Callable<Date> task = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return simpleDateFormat.parse("21001212");
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<Date>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
        }

        for (Future<Date> future : results) {
            System.out.println(future.get());
        }
    }

    @Test
    public void test1() throws ExecutionException, InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        Callable<Date> task = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return DateFormatThreadLocal.convert("21001212");
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<Date>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
        }

        for (Future<Date> future : results) {
            System.out.println(future.get());
        }

        pool.shutdown();
    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        Callable<LocalDate> task = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return LocalDate.parse("21001212", dateTimeFormatter);
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<LocalDate>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
        }

        for (Future<LocalDate> future : results) {
            System.out.println(future.get());
        }
    }
}
