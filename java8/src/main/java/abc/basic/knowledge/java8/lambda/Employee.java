package abc.basic.knowledge.java8.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Jim
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Employee {

    private String name;
    private Integer age;
    private double salary;
    private Status status;

    public Employee(Integer age) {
        this.age = age;
    }

    public Employee(String name, Integer age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public enum Status {
        FREE,
        BUSY,
        VOCATION
    }
}
