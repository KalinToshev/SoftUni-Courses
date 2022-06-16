package Threeuple;

public class Threeuple<F, S, T> {
    F item1;
    S item2;
    T item3;

    public Threeuple(F item1, S item2, T item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    public F getItem1() {
        return item1;
    }

    public void setItem1(F item1) {
        this.item1 = item1;
    }

    public S getItem2() {
        return item2;
    }

    public void setItem2(S item2) {
        this.item2 = item2;
    }

    public T getItem3() {
        return item3;
    }

    public void setItem3(T item3) {
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", item1, item2, item3);
    }
}
