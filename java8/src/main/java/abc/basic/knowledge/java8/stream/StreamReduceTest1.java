package abc.basic.knowledge.java8.stream;

import abc.basic.knowledge.java8.lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Jim
 * <pre>
 *     归约
 *     reduce(T identity, BinaryOperator) / reduce(BinaryOperator)
 *     可以将流中元素反复结合起来, 得到一个值.
 *
 * </pre>
 */
public class StreamReduceTest1 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.55),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77)
    );

    @Test
    public void test() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }

    @Test
    public void test1(){
        Optional<Double> optional = employees.stream().map(Employee::getSalary).reduce(Double::sum);

    }
}
