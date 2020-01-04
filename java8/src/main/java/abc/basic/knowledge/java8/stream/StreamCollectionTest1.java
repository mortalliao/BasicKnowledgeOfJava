package abc.basic.knowledge.java8.stream;

import abc.basic.knowledge.java8.lambda.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Jim
 * <pre>
 *     收集
 *     collect - 将流转换为其他形式, 接收一个Collector接口实现, 用于给Stream中元素做汇总的方法
 * </pre>
 */
public class StreamCollectionTest1 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.55),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77),
            new Employee("田七", 8, 7777.77)
    );

    @Test
    public void test1() {
        List<String> list = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        list.forEach(System.out::println);
    }

    @Test
    public void test2() {
        Set<String> set = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());

        set.forEach(System.out::println);

    }

    @Test
    public void test3() {
        HashSet<String> hashSet = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));

        hashSet.forEach(System.out::println);
    }

    @Test
    public void test4() {
        // 总数
        Long count = employees.stream()
                .collect(Collectors.counting());
        System.out.println(count);
    }

    @Test
    public void test5() {
        // 平均值
        Double avg = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);
    }

    @Test
    public void test6() {
        // 总和
        Double sum = employees.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);
    }

    @Test
    public void test7() {
        // 最大值
        Optional<Employee> max = employees.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println(max.get());
    }

    @Test
    public void test8() {
        // 最大值
        Optional<Employee> min = employees.stream()
                .collect(Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println(min.get());
    }

    /**
     * 分组
     */
    @Test
    public void test9() {
        Map<Employee.Status, List<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);
    }

    /**
     * 多级分组
     */
    @Test
    public void test10() {
        Map<Employee.Status, Map<String, List<Employee>>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
                    if (e.getAge() <= 35) {
                        return "青年";
                    } else if (e.getAge() <= 50) {
                        return "中年";
                    } else {
                        return "老年";
                    }
                })));
        System.out.println(map);
    }

    /**
     * 分区
     */
    @Test
    public void test11() {
        Map<Boolean, List<Employee>> map = employees.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 8000));

        System.out.println(map);
    }

    @Test
    public void test12() {
        DoubleSummaryStatistics summaryStatistics = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println(summaryStatistics.getAverage());
        System.out.println(summaryStatistics.getSum());
        System.out.println(summaryStatistics.getMax());
    }

    @Test
    public void test13() {
        String str = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",", "===", "==="));

        System.out.println(str);
    }
}
