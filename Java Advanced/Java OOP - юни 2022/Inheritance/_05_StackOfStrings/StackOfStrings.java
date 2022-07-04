package InheritanceLab.StackOfStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {this.data.add(item);}

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    public String peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("There is no items in StackOfStrings.");
        } else {
            return this.data.get(this.data.size() - 1);
        }
    }

    public String pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("There is no items in StackOfStrings.");
        } else {
            return this.data.remove(this.data.size() - 1);
        }
    }
}
