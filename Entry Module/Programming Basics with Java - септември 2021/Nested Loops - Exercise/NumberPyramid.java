import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int counter = 1;
        boolean isValid = false;

        for (int rows = 1; rows <= n; rows++) {
            for (int cols = 1; cols <= rows; cols++) {
                if (counter > n) {
                    isValid = true;
                    break;
                }
                System.out.print(counter + " ");
                counter++;
            }
            if (isValid) {
                break;
            }
            System.out.println();
        }
    }
}
