import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author 734070824@qq.com
 * @date 2024/4/2 14:56
 */

public class Bag<Item> implements Iterable<Item> {

    Bag() {


    }

    void add(Item item) {

    }

    boolean isEmpty() {
        return false;
    }

    int size() {
        return 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Item> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Item> spliterator() {
        return Iterable.super.spliterator();
    }
}
