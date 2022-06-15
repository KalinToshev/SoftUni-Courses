package GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box {
    private final List<String> values = new ArrayList<>();

    public Box () {
    }

    public void add(String element) {
        values.add(element);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String value : values) {
            stringBuilder.append(String.format("%s: %s%n", value.getClass().getName(), value));
        }
        return stringBuilder.toString();
    }
}
