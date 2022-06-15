package GenericBoxOfInteger;

import java.util.ArrayList;
import java.util.List;

public class Box <T> {
    private final List<T> values = new ArrayList<>();

    public Box () {
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
