package abc.basic.knowledge.io.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <pre>
 * 正则表达式:符合一定规则的表达式
 * 	作用：用于专门操作字符串
 * 	特点：用于一些特点的符号来表示一些代码操作，这样就简化书写
 * 	所以学习正则表达式，就是在学习一些特殊符号的使用
 *
 * 	好处:可以简化对字符串的复杂操作
 * 	弊端:符号定义的越多，正则越长，阅读性越差
 *
 * 具体操作功能：
 * 	1：匹配：public boolean matches(String regex)
 * 			用规则匹配整个字符串，只要有一处不符合规则，就匹配结束，返回false
 * 	2：切割：public String[] split(String regex)
 *
 * 	3：替换：public String replaceAll(String regex, String replacement)
 *
 * 	4：获取：将字符串中符合规则的子串取出
 * 			操作步骤：
 * 				1：将正则表达式封装成对象
 * 				2：让正则对象和要操作的字符串相关联
 * 				3：关联后，获取正则匹配引擎
 * 				4：通过引擎对符合规则的子串进行操作，比如：取出
 * </pre>
 */
public class RegexDemo {
    public static void main(String[] args) {
        System.out.println("ƥ��");
        String qq = "414111";
        // String regex = "[1-9]\\d{4,14}";
        String regex = "[^0]\\d{4,14}";

        matchesDemo(qq, regex);

        System.out.println("-------------------------------");

        System.out.println("�и�");
        // String str = "zhangsan     lisi    wangwu";
        // String reg = " +";// ���ն���ո��������и�
        // // // String reg = "[ ]+";

        // String str = "zhangsan.lisi.wangwu";
        // String reg = "\\."; // .��������ʽ�����ʾ�κ��ַ������н���������ƥ��Ҳ���ܲ�ƥ�䣩
        // // String reg = "[.]";
        // // String reg = "\\Q.\\E";

        // String str = "c:\\abc\\a.txt";
        // // String reg = "\\\\";
        // String reg = "[\\\\]";
        // System.out.println(str);// c:\abc\a.txt

        // String str = "c:\abc\a.txt";// �ַ���������
        // // String reg = "\\";
        // String reg = "[\\]";

        /*
         * Ϊ���ù���Ľ�������ã�
         * ���Խ������װ��һ���飬��()��ɣ���ĳ��ֶ��б�ţ���1��ʼ��
         * ��Ҫʹ�����е������ͨ \n(n������ı��)����ʽ����ȡ
         */
        String str = "akbbadad666optwdd����55bdfff123aadfew";// ���յ�������и�
        // String reg = "(.)\\1";
        // String reg = "(.)\\1+";
        // String reg = "(.)\\1{1,}";
        String reg = "(\\d)\\1";

        splitDemo(str, reg);

        System.out.println("--------------------------------");

        System.out.println("�滻");
        String word = "wodehaoma15723651475mima5896321556";

        // replaceAllDemo(word, "(\\d{5,})", "*");
        if (word.matches(".*\\d{5,}.*")) {
            replaceAllDemo(word, "\\d", "*");
        }

        String str1 = "akbbadad666optwdd����55bdfff123aadfew";
        replaceAllDemo(str1, "(.)\\1+", "$1");// ���ص��ַ��滻�ɵ�����ĸ zzzzzz -> z

        System.out.println("--------------------------------");

        System.out.println("��ȡ");

        // String s = "ming tian jiu yao fang jia la,da jia";
        // String reg1 = "\\b[a-z]{4}\\b";// \b��ʾ���ʱ߽�

        String s = "987wodehaoma1 5723 6 5 1 4 7  5�м�����1 2 3 456789mima5896321556";
        String reg1 = "[\\d *]{5,}";
        // �������װ�ɶ���
        Pattern p = Pattern.compile(reg1);

        // ����������Ҫ���õ��ַ������������ȡƥ�����
        Matcher m = p.matcher(s);

        // ��ʵString���е�matches�������õľ���Pattern��Matcher��������ɵ�
        // ֻ������String�ķ�����װ����������Ϊ�򵥣����ǹ���ȴ��һ
        // System.out.println(m.matches());

        // boolean b=m.find();// ���������õ��ַ����ϣ������з��Ϲ�����Ӵ�����
        // System.out.println(b);
        // System.out.println(m.group());// ���ڻ�ȡƥ���Ľ��

        // while(m.find()){
        // System.out.println(m.group());
        // System.out.println(m.start() + "........." + m.end());
        // }

        int i = 0;
        String news = "";
        while (m.find()) {
            System.out.println(m.group());
            System.out.println(m.start() + "........." + m.end());// ���󲻰���
            int start = m.start();
            int end = m.end();
            news += s.substring(i, start);
            news += m.group().replaceAll("\\d", "*").replaceAll(" ", "*");
            i = end;
        }
        System.out.println(news);

    }

    // public boolean matches(String regex)
    public static void matchesDemo(String qq, String regex) {
        boolean flag = qq.matches(regex);
        if (flag) {
            System.out.println(qq + " is OK");
        } else {
            System.out.println(qq + "�ǷǷ��ַ�");
        }
    }

    // public String[] split(String regex)
    public static void splitDemo(String str, String reg) {
        String[] array = str.split(reg);
        System.out.println(array.length);
        for (String s : array) {
            System.out.println(s);
        }
    }

    // public String replaceAll(String regex,String replacement)
    public static void replaceAllDemo(String str, String regex,
                                      String replacement) {
        str = str.replaceAll(regex, replacement);
        System.out.println(str);
    }

}
