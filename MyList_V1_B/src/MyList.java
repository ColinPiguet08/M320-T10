import java.util.AbstractList;
import java.util.ArrayList;

public class MyList<T> extends AbstractList<T> {

    private ArrayList<T> list = new ArrayList<>();

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public boolean add(T element) {
        return list.add(element);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    @Override
    public T remove(int index) {
        return list.remove(index);
    }

    @Override
    public int size() {
        return list.size();
    }
}