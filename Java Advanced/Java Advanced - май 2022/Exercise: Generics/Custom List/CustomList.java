package CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private final List<T> values;

    public CustomList() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    public T remove(int index) {
        return values.remove(index);
    }

    public boolean contains(T element) {
        return values.contains(element);
    }

    public void swap(int indexOne, int indexTwo) {
        //save elements
        T elementOne = values.get(indexOne);
        T elementTwo = values.get(indexTwo);
        //swap elements
        values.set(indexOne, elementTwo);
        values.set(indexTwo, elementOne);
    }

    public int countGreaterThan(T element) {
        return (int) values.stream().filter(itemFromOurBox -> itemFromOurBox.compareTo(element) > 0).count();
    }

    public T getMax() {
        return Collections.max(values);
    }

    public T getMin() {
        return Collections.min(values);
    }

    public void print() {
        for (T value : values) {
            System.out.println(value.toString());
        }
    }
}
