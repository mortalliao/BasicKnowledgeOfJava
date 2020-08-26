package abc.basic.knowledge.thread;

/**
 * @author Jim
 */
public class CreateThreadTest {
    public static void main(String[] args) {
        new ThreadTest().start();
        new ThreadTest().start();
    }
}

class ThreadTest extends Thread {
    private int i = 0;

    @Override
    public void run() {
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " is running: " + i);
        }
    }
}

