package abc.basic.knowledge.keyword;

/**
 * @author Jim
 */
public class TestJoin {

    /**
     * <pre>
     * t.join()方法只会使主线程进入等待池并等待t线程执行完毕后才会被唤醒。并不影响同一时刻处在运行状态的其他线程。
     * 1. 没有join  A线程和B线程是交替执行的
     * 2. 使用t1.join()之后，B线程需要等A线程执行完毕之后才能执行。
     * t1.join()需要等t1.start()执行之后执行才有效果
     * 如果t1.join()放在t2.start()之后的话，仍然会是交替执行，然而并不是没有效果
     *
     *
     * t1.join是在main主线程上调用的，所以只会让main主线程暂时挂起，不会影响到t2线程
     * 这里只要记住，哪个线程挂起，取决于在哪个线程上调用x.join方法，而不是影响到所有的线程
     *
     * join()方法的底层是利用wait()方法实现的。
     * 可以看出，join方法是一个同步方法，
     * 当主线程调用t1.join()方法时，主线程先获得了t1对象的锁，随后进入方法，调用了t1对象的wait()方法，
     * 使主线程进入了t1对象的等待池，此时，A线程则还在执行，并且随后的t2.start()还没被执行，
     * 因此，B线程也还没开始。等到A线程执行完毕之后，主线程继续执行，走到了t2.start()，B线程才会开始执行。
     * </pre>
     */
    public static void main(String[] args) throws InterruptedException {
        ThreadTest t1 = new ThreadTest("A");
        ThreadTest t2 = new ThreadTest("B");
        t1.start();
        // t1.join();
        t2.start();
    }
}

class ThreadTest extends Thread {
    private String name;

    public ThreadTest(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + "-" + i);
        }
    }
}
