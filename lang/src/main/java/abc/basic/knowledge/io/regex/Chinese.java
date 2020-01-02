package abc.basic.knowledge.io.regex;

/**
 * @author Jim
 */
public class Chinese {

    public static void main(String[] args) {
        String test = "vava";
        String regex = "[\u4e00-\u9fa5]{2,20}";
        System.out.println(test.matches(regex));
    }
}
