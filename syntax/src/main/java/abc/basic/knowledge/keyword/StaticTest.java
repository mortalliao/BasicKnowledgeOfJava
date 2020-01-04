package abc.basic.knowledge.keyword;

/**
 * @author Jim
 */
public class StaticTest extends Son {

    static {
        System.out.println("Father static ");
    }

    public StaticTest() {
        System.out.println("Father constructor");
    }

    public static void main(String[] args) {
        new Son();
    }
}

class Son {

    static {
        System.out.println("Son static");
    }

    public Son() {
        System.out.println("Son constructor");
    }
}


