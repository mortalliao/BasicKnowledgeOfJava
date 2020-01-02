package abc.basic.knowledge.io.regex;

/**
 * @author Jim
 */
public class Number {

    public static void main(String[] args) {
        String s = "123.253";
        System.out.println(StringUtils.isInteger(s));

        // 判断是否为整数
        String regex = "^[-\\+]?[\\d]+$";
        System.out.println(s.matches(regex));

        // 判断是否为浮点数，包括double和float
        regex = "^[-\\+]?\\d+\\.\\d+$";
        System.out.println(s.matches(regex));
    }
}
