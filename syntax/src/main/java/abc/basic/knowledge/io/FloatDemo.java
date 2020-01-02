package abc.basic.knowledge.io;

/**
 * @author Jim
 */
public class FloatDemo {
    public static void main(String[] args) {
        float f = (float) 1.0;
        float f1 = 2.0f;
        double f2 = 3.0;

        System.out.println(f / 0); // Infinity (infinity:无穷,无限大)
        System.out.println(f1 / 0); // Infinity
        System.out.println(f2 / 0); // Infinity
    }

}
