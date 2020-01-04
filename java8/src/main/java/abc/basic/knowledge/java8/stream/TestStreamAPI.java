package abc.basic.knowledge.java8.stream;

import abc.basic.knowledge.java8.lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Jim
 */
public class TestStreamAPI {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.55),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77)
    );

    /**
     * 给定一个数字列表, 返回一个由每个数的平方构成的列表
     */
    @Test
    public void test1() {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, 6};

        Arrays.stream(nums)
                .map((x) -> x * x)
                .forEach(System.out::println);
    }

    /**
     * 用map和reduce方法 数一数流中有多少个Employee
     */
    @Test
    public void test2() {
        Optional<Integer> count = employees.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);

        System.out.println(count.get());
    }


}
