package InheritanceLab.StackOfStrings;

public class Main {
    public static void main(String[] args) {
        StackOfStrings sos = new StackOfStrings();

        sos.push("one");
        System.out.println(sos.pop());
        System.out.println(sos.isEmpty());
        System.out.println(sos.peek());
    }
}
