package GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Comparable<T>>{
    private final List<T> values = new ArrayList<>();

    public Box () {
    }

    public int countGreaterItems(T element) {
        return (int) values.stream().filter(itemFromOurBox -> itemFromOurBox.compareTo(element) > 0).count();
    }

    public void swap(int indexOne, int indexTwo) {
        T one = values.get(indexOne);
        T two = values.get(indexTwo);
        values.set(indexOne, two);
        values.set(indexTwo, one);
    }

    public void add(T element) {
        values.add(element);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (T value : values) {
            stringBuilder.append(String.format("%s: %s%n", value.getClass().getName(), value));
        }
        return stringBuilder.toString();
    }
}
