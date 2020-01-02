package abc.basic.knowledge.java8.stream;

import abc.basic.knowledge.java8.lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author Jim
 *
 * <pre>
 *
 *     查找与匹配
 *
 *     allMatch - 检查是否匹配所有元素
 *     anyMatch - 检查是否至少匹配一个元素
 *     noneMatch - 检查是否没有匹配所有元素
 *     findFirst - 返回第一个元素
 *     findAny - 返回当前流中的任意元素
 *     count - 返回流中元素的总个数
 *     max - 返回流中最大值
 *     min - 返回流中最小值
 *
 * </pre>
 */
public class StreamEndTest1 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Employee.Status.FREE),
            new Employee("李四", 38, 5555.55, Employee.Status.BUSY),
            new Employee("王五", 50, 6666.66, Employee.Status.VOCATION),
            new Employee("赵六", 16, 3333.33, Employee.Status.FREE),
            new Employee("田七", 8, 7777.77, Employee.Status.BUSY)
    );

    @Test
    public void test1() {
        boolean b1 = employees.stream()
                .allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);

        boolean b2 = employees.stream()
                .anyMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b2);

        boolean b3 = employees.stream()
                .noneMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b3);
    }

    @Test
    public void test2() {
        Optional<Employee> optional = employees.stream()
//                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .findFirst();
        System.out.println(optional.get());
    }

    @Test
    public void test3() {
        Optional<Employee> optional = employees.parallelStream()
                .filter((e) -> e.getStatus().equals(Employee.Status.FREE))
                .findAny();
        System.out.println(optional.get());
    }

    @Test
    public void test4() {
        Long count = employees.stream()
                .count();
        System.out.println(count);

        Optional<Employee> optional = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(optional.get());

        Optional<Double> min = employees.stream()
                .map(Employee::getSalary)
                .min(Double::compare);
        System.out.println(min.get());
    }
}
