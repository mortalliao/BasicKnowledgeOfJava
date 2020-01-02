package abc.basic.knowledge.spi;

/**
 * @author Jim
 */
public class Cat implements IShout {
    @Override
    public void shout() {
        System.out.println("Cat shout: miao miao");
    }
}
