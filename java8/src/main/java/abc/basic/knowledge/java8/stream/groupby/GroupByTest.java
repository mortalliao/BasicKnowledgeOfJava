package abc.basic.knowledge.java8.stream.groupby;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Jim
 */
public class GroupByTest {
    private List<People> people;
    private BiConsumer soutKV;
    private Map result;

    @Before
    public void init() {
        people = People.buildPeopleList();
        soutKV = (k, v) -> System.out.println(k + ":" + v);
    }

    @After
    public void soutResult() {
        if (!CollectionUtils.isEmpty(result)) {
            result.forEach(soutKV);
        }
    }

    /**
     * 根据性别分组
     */
    @Test
    public void groupBySex() {
        result = people.stream().collect(
                Collectors.groupingBy(People::getSex)
        );
    }

    /**
     * 分别统计不同性别各自的人数
     */
    @Test
    public void groupBySexCount() {
        result = people.stream().collect(
                Collectors.groupingBy(People::getSex, Collectors.counting()
                ));
    }

    /**
     * 分别统计不同性别各自的name列表
     */
    @Test
    public void groupBySexName() {
        result = people.stream().collect(
                Collectors.groupingBy(
                        People::getSex,
                        Collectors.mapping(People::getName, Collectors.toSet())
                ));
    }

    @Test
    public void groupByCombine() {
        result = people.stream().collect(
                Collectors.groupingBy(p -> p.getSex() + p.getAge(),
                        Collectors.mapping(People::getName, Collectors.toSet())
                ));
    }

    @Test
    public void collectors() {
        System.out.println(Stream.of("a", "b", "c").collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.joining(","))));

        Map<Boolean, List<Integer>> collect5 = Stream.of(1, 3, 4).collect(Collectors.partitioningBy(x -> x > 2));
        Map<Boolean, Long> collect4 = Stream.of(1, 3, 4).collect(Collectors.partitioningBy(x -> x > 2, Collectors.counting()));
        System.out.println(collect5);
        System.out.println(collect4);
    }

    @Test
    public void testaa(){
        List<String> list = new LinkedList<>();
        list.add("Hello");
        System.out.println(list.get(0));
    }

}
