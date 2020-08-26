package abc.basic.knowledge.thread;

/**
 * @author Jim
 */
public class CreateRunnableTest {

    public static void main(String[] args) {
        RunableTest runableTest = new RunableTest();
        new Thread(runableTest, "线程1").start();
        new Thread(runableTest).start();
    }
}

class RunableTest implements Runnable {
    private int i = 0;

    @Override
    public void run() {
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " is running: " + i);
        }
    }
}
