package abc.basic.knowledge.io.regex;

/**
 * @author Jim
 */
public class CheckMail {

    public static void main(String[] args) {
        String mail = "abc123@sina.com.cn.cn.cn";

        // 较为精确的匹配
        String regex = "[a-zA-Z0-9_]{6,15}@[a-zA-Z0-9]+(\\.[a-zA-Z]+){1,3}";
        // String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+"

        // 相对不太精确的匹配
        regex = "\\w+@\\w+(\\.\\w+)+";

        mail = "1@1.1";

        // 更吊的
        mail = "@";

        if (mail.indexOf("@") != -1) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        // System.out.println(mail.matches(regex));

    }
}
