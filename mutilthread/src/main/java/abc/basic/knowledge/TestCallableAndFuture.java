package abc.basic.knowledge;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author Jim
 */
public class TestCallableAndFuture {

    @Test
    public void test() {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<String> future = threadPool.submit(
                new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        Thread.sleep(2000);
                        return "hello";
                    }
                }
        );

        System.out.println("等待结果");

        try {
            System.out.println("拿到结果: " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * CompletionService用于提交一组Callable任务, 其take方法返回已完成的一个Callable任务对应的Future对象
     */
    @Test
    public void test1() {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(threadPool);
        for (int i = 1; i <= 10; i++) {
            final int seq = i;
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(new Random().nextInt(5000));
                    return seq;
                }
            });
        }

        for (int i = 0; i < 10; i++) {
            try {
                Integer integer = completionService.take().get();
                System.out.println(integer);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
