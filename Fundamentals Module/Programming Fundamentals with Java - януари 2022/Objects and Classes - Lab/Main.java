package bg.softuni.ObjectsАndClassesLab;

public class Main {
    static class Pencil {
        double length;
        String mark;
        void setParameters(double length, String mark) {
            this.length = length;
            this.mark = mark;
        }
        void outputData() {
            System.out.printf("The length of the pencil is: %.2f and the mark of the pencil is: %s.%n", this.length, this.mark);
        }
    }
    public static void main(String[] args) {
        Pencil p1 = new Pencil();
        Pencil p2 = new Pencil();
        p1.setParameters(17.8585858, "Polo");
        p2.setParameters(21.1234523, "Astra");
        p1.outputData();
        p2.outputData();
    }
}
