package abc.basic.knowledge.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Jim
 */
public class CreateCallableTest {

    public static void main(String[] args) {
        CallableTest callableTest = new CallableTest();
        FutureTask futureTask = new FutureTask<>(callableTest);
        new Thread(futureTask).start();
        try {
            System.out.println("子线程的返回值: " + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

class CallableTest implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i < 101; i++) {
            sum += i;
        }
        System.out.println(Thread.currentThread().getName() + " is running: " + sum);
        return sum;
    }
}
