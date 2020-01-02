package abc.basic.knowledge.io;

import java.io.*;
import java.math.BigDecimal;
import java.util.Random;

/**
 * @author Jim
 */
public class Trap1 {

    public static void main(String[] args) {
        // 找奇数
        for (int i = -10; i <= 10; i++) {
            System.out.println(isOdd(i));
        }

        // 浮点数相减
        System.out.println(2.0 - 1.1);// 0.8999999999999999
        System.out.println(new BigDecimal("2.0")
                .subtract(new BigDecimal("1.1")));
        System.out.printf("%.1f", 2.0 - 1.1);
        System.out.println();

        // 长整除
        longDivision();// 5 应该为1000

        // 互换内容
        swap(); // x= 0; y= 1984

        // 字符和字符串
        charAndString();

        // 字符数组
        charArray();

        // 转义字符
        unicode();

        // 打印输出类名
        className();

        // 随机数的问题
        random();

        // 无情的增量操作
        forTest();

        // 整数边界的问题
        // whileTest();

        // 计数器的问题
        clock();

        // 优柔寡断的返回值
        System.out.println(decision());

        // 你好,再见
        goodBye();
    }

    /**
     * 找奇数
     *
     * @param i
     * @return
     */
    public static boolean isOdd(int i) {
        return i % 2 == 1;
    }

    /**
     * 长整除
     */
    public static void longDivision() {
        // final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;//微秒
        // final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
        // System.out.println(MICROS_PER_DAY/MILLIS_PER_DAY);

        final long MICROS_PER_DAY = 24L * 60 * 60 * 1000 * 1000; // 微秒
        final long MILLIS_PER_DAY = 24L * 60 * 60 * 1000; // 毫秒
        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);
    }

    /**
     * 互换内容
     */
    public static void swap() {
        // 利用位运算的方式进行数据的交换，
        // 利用的思想原理是：一个数异或同一个数两次，结果还是那个数，而且不会超出int范围
        int x = 1984;
        int y = 2001;
        // x^=y^=x^=y; //wrong

        // x = x ^ y;
        // y = x ^ y;
        // x = x ^ y;
        x = (y ^= (x ^= y)) ^ x;
        // y = (x ^= (y ^= x)) ^ y;
        System.out.println("x= " + x + "; y= " + y);
    }

    /**
     * 字符和字符串
     */
    public static void charAndString() {
        System.out.println("H" + "a");// Ha
        System.out.println('H' + 'a');// 169
    }

    /**
     * 字符数组
     */
    public static void charArray() {
        String letters = "ABC";
        char[] numbers = {'A', 'B', 'C'};
        System.out.println(letters.equals(numbers));

        System.out.println(letters + " easy as " + numbers);// wrong

        System.out.print(letters + " easy as ");
        System.out.println(numbers);
    }

    /**
     * 转义字符
     */
    public static void unicode() {
        // \u0022 是双引号的Unicode转义字符
        System.out.println("a\u0022.length() + \u0022b".length());

        System.out.println("a".length() + "b".length());
    }

    /**
     * 打印输出类名className
     */
    public static void className() {
        System.out.println(Trap1.class.getName().replace(".", "/") + ".class");
        System.out
                .println(Trap1.class.getName().replace("\\.", "/") + ".class");
    }

    /**
     * 随机数的问题
     */
    public static void random() {
        Random random = new Random();

        StringBuffer word = null;
        // switch(random.nextInt(2)) {//wrong
        switch (random.nextInt(3)) {
            case 1:
                word = new StringBuffer("P");
                break;
            case 2:
                word = new StringBuffer("G");
                break;
            default:
                word = new StringBuffer("M");
        }
        word.append('a');
        word.append('i');
        word.append('n');
        System.out.println(word);
    }

    /**
     * 无情的增量操作
     */
    public static void forTest() {
        int j = 0;
        for (int i = 0; i < 100; i++) {
            j = j++;
        }
        System.out.println(j);
    }

    /**
     * 整数边界的问题
     */
    public static void whileTest() {
        final int END = Integer.MAX_VALUE;
        final int START = END - 100;
        int count = 0;
        for (int i = START; i <= END; i++)
            count++;
        System.out.println(count);
    }

    /**
     * 计算器的问题
     */
    public static void clock() {
        int minutes = 0;
        for (int ms = 0; ms < 60 * 60 * 1000; ms++) {
            if (ms % 60 * 1000 == 0) {
                minutes++;
            }
        }
        System.out.println(minutes);
    }

    /**
     * 优柔寡断的返回值
     */
    public static boolean decision() {
        try {
            return true;
        } finally {
            return false;
        }
    }

    /**
     * 你好,再见
     */
    public static void goodBye() {
        try {
            System.out.println("Hello world");
            System.exit(0);
        } finally {
            System.out.println("Goodbye world");
        }
    }

    /**
     * 到底关闭了吗
     *
     * @throws Exception
     */
    public static void IOTest() throws Exception {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(new File("src"));
            out = new FileOutputStream(new File("dest"));
            byte[] buf = new byte[1024];
            int n;
            while ((n = in.read(buf)) > 0) {
                out.write(buf, 0, n);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

}

