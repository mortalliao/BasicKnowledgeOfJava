package abc.basic.knowledge.io.regex;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author Jim
 */
public class IPSort {

    public static void main(String[] args) {
        String ip = "192.68.1.254 102.49.23.013 10.10.10.10 2.2.2.2 8.109.90.30";

        ip = ip.replaceAll("(\\d+)", "00$1");
        System.out.println(ip);

        ip = ip.replaceAll("0*(\\d{3})", "$1");
        System.out.println(ip);

        String[] arr = ip.split(" ");

        TreeSet<String> ts = new TreeSet<String>();

        ts.addAll(Arrays.asList(arr));

        for (String s : ts) {
            System.out.println(s.replaceAll("0*(\\d+)", "$1"));
        }
    }
}
