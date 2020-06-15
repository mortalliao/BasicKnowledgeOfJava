package abc.basic.knowledge.threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jim
 */
public class ThreadLocalTest {

    private static final AtomicInteger nextId = new AtomicInteger(0);

    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return nextId.getAndIncrement();
        }
    };

    public static int get() {
        return threadLocal.get();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println("threadName=" + Thread.currentThread().getName() + ",threadId=" + ThreadLocalTest.get());
                }
            }).start();
        }
    }

}
