package abc.basic.knowledge.io.character;

import org.junit.Test;

import java.util.Scanner;

/**
 * public static boolean isUpperCase(char ch):  判断给定的字符是否是大写字符
 * public static boolean isLowerCase(char ch):  判断给定的字符是否是小写字符
 * public static boolean isDigit(char ch):      判断给定的字符是否是数字字符
 * public static char toUpperCase(char ch):     把给定的字符转换为大写字符
 * public static char toLowerCase(char ch):     把给定的字符转换为小写字符
 */
public class CharacterTest {

    @Test
    public void test1() {
        // 定义三个统计变量
        int bigCount = 0;
        int smallCount = 0;
        int numberCount = 0;

        // 键盘录入字符串
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        char[] array = s.toCharArray();

        for (int i = 0; i < array.length; i++) {
            char ch = array[i];

            if (Character.isUpperCase(ch)) {
                bigCount++;
            } else if (Character.isLowerCase(ch)) {
                smallCount++;
            } else if (Character.isDigit(ch)) {
                numberCount++;
            }
        }

        System.out.println("大写字母：" + bigCount + "个");
        System.out.println("小写字母：" + smallCount + "个");
        System.out.println("数字字符：" + numberCount + "个");
    }
}
