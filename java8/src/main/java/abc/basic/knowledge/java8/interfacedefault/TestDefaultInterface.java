package abc.basic.knowledge.java8.interfacedefault;

/**
 * @author Jim
 *
 * <pre>
 *
 *     类优先
 *
 * </pre>
 */
public class TestDefaultInterface {

    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        System.out.println(subClass.getName());

        MyInterface.show();
    }
}
