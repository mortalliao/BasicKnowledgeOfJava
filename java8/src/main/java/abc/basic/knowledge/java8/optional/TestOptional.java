package abc.basic.knowledge.java8.optional;

import abc.basic.knowledge.java8.lambda.Employee;
import org.junit.Test;

import java.util.Optional;

/**
 * @author Jim
 * <pre>
 *
 *     Optional容器类的常用方法:
 *
 *     Optional.of(T t) : 创建一个Optional实例
 *     Optional.empty() : 创建一个空的Optional实例
 *     Optional.ofNullable(T t) : 若t不为null, 创建Optional实例, 否则创建空实例
 *
 *     isPresent() : 判断是否包含值
 *     orElse(T t) : 如果调用对象包含值, 返回改值, 否则返回t
 *     orElseGet(Supplier s) : 如果调用对象包含值, 返回该值, 否则返回s获取的值
 *     map(Function f) : 如果有值对其处理, 并返回处理后的Optional, 否则返回Optional.empty()
 *     flatMap(Function mapper) : 与map类似, 要求返回值必须是Optional
 *
 * </pre>
 */
public class TestOptional {

    @Test
    public void test1() {
//        Optional<Employee> optional = Optional.of(new Employee());
        Optional<Employee> optional = Optional.of(null);
        Employee employee = optional.get();
        System.out.println(employee);
    }

    @Test
    public void test2() {
        Optional<Employee> optional = Optional.empty();
        System.out.println(optional.get());
    }

    @Test
    public void test3() {
//        Optional<Employee> optional = Optional.ofNullable(new Employee());
        Optional<Employee> optional = Optional.ofNullable(null);
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }

        Employee employee = optional.orElse(new Employee("张三", 18, 888.88, Employee.Status.FREE));
        System.out.println(employee);

        Employee emp = optional.orElseGet(() -> new Employee());
        System.out.println(emp);
    }

    @Test
    public void test4() {
        Optional<Employee> optional = Optional.ofNullable(new Employee("张三", 18, 888.88, Employee.Status.FREE));

        Optional<String> str = optional.map((e) -> e.getName());
        System.out.println(str.get());
    }
}
