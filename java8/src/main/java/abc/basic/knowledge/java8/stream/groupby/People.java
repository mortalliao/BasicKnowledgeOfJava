package abc.basic.knowledge.java8.stream.groupby;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jim
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class People {
    private String name;

    private String character;

    private String sex;

    private int age;

    public static People buildDefault() {
        return People.builder().name("LuoTianyan").character("optimistic").sex("female").age(24).build();
    }

    public static List<People> buildPeopleList() {
        People p1 = People.builder().name("LuoTianyan").character("optimistic").sex("female").age(24).build();
        People p2 = People.builder().name("Zhang").character("optimistic").sex("female").age(23).build();
        People p3 = People.builder().name("Hu").character("shy").sex("female").age(25).build();
        People p4 = People.builder().name("Liu").character("Righteous").sex("male").age(24).build();
        return new ArrayList<>(Arrays.asList(p1, p2, p3, p4));
    }
}
