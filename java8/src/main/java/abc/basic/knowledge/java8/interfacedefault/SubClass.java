package abc.basic.knowledge.java8.interfacedefault;

/**
 * @author Jim
 */
public class SubClass /*extends MyClass*/ implements MyFun, MyInterface {

    @Override
    public String getName() {
        return MyFun.super.getName();
    }
}
