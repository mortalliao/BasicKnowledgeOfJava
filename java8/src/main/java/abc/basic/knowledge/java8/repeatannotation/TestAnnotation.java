package abc.basic.knowledge.java8.repeatannotation;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author Jim
 *
 * <pre>
 *
 *     重复注解与类型注解
 *
 * </pre>
 */
public class TestAnnotation {

    // checker framework
    private /*@NonNull*/ Object obj = null;

    @Test
    public void test1() throws NoSuchMethodException {
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method method = clazz.getMethod("show", String.class);

        MyAnnotation[] annotations = method.getAnnotationsByType(MyAnnotation.class);

        for (MyAnnotation myAnnotation : annotations) {
            System.out.println(myAnnotation.value());
        }

    }

    @MyAnnotation("Hello")
    @MyAnnotation("World")
    public void show(@MyAnnotation("abc") String str) {

    }
}
