package abc.basic.knowledge.java8.stream;

import abc.basic.knowledge.java8.lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jim
 *
 * <pre>
 *     排序
 *
 *     sorted() - 自然排序(Comparable)
 *     sorted(Comparator com) - 定制排序(Comparator)
 *
 * </pre>
 */
public class StreamSortTest {

    @Test
    public void test1() {
        List<String> list = Arrays.asList("ccc", "aaa", "bbb", "ddd", "eee");

        list.stream()
                .sorted()
                .forEach(System.out::println);
    }

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.55),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77)
    );

    @Test
    public void test2() {
        employees.stream()
                .sorted((e1, e2) -> {
                    if (e1.getAge().equals(e2.getAge())) {
                        return e1.getName().compareTo(e2.getName());
                    } else {
                        return e1.getAge().compareTo(e2.getAge());
                    }
                }).forEach(System.out::println);
    }
}
