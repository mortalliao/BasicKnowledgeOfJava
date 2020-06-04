package abc.basic.knowledge.thread;

/**
 * test static
 * myclass static
 * person static
 * person Test
 * test constructor
 * person MyClass
 * myclass constructor
 */
public class StaticTest1 {
    Person person = new Person("Test");

    static {
        System.out.println("test static");
    }

    public StaticTest1() {
        System.out.println("test constructor");
    }

    public static void main(String[] args) {
        new MyClass();
    }
}

class MyClass extends StaticTest1 {
    Person person = new Person("MyClass");

    static {
        System.out.println("myclass static");
    }

    public MyClass() {
        System.out.println("myclass constructor");
    }
}

class Person {
    static {
        System.out.println("person static");
    }

    public Person(String str) {
        System.out.println("person " + str);
    }
}
