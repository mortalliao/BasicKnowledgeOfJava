package abc.basic.knowledge.io.list;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Jim
 */
public class ArrayListTest {

    @Test
    public void test1(){
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("Hello World");
        arrayList.add("Test1");
        arrayList.add("Test2");
        arrayList.add("Test3");

        for(String s: arrayList){
            System.out.println(s);
        }
    }
}
