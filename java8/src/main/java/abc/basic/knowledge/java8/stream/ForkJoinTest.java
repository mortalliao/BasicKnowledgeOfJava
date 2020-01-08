package abc.basic.knowledge.java8.stream;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @author Jim
 */
public class ForkJoinTest {

    /**
     * ForkJoin框架
     */
    @Test
    public void test1() {
        Instant start = Instant.now();

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0, 100000000L);

        Long sum = pool.invoke(task);
        System.out.println(sum);

        Instant end = Instant.now();

        System.out.println("耗费时间: " + Duration.between(start, end).toMillis());
    }

    @Test
    public void test2() {
        Instant start = Instant.now();

        long sum = 0L;

        for (int i = 0; i <= 100000000L; i++) {
            sum += i;
        }

        System.out.println(sum);

        Instant end = Instant.now();

        System.out.println("耗费时间: " + Duration.between(start, end).toMillis());
    }

    @Test
    public void test3() {
        Instant start = Instant.now();

        LongStream.rangeClosed(0, 100000000L)
                .parallel()
                .reduce(0, Long::sum);

        Instant end = Instant.now();

        System.out.println("耗费时间: " + Duration.between(start, end).toMillis());
    }
}
