import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int theNumberOfPieces = length * width;
        int collection = 0;
        while (theNumberOfPieces >= 0) {
            String calculatin = scanner.nextLine();
            if (calculatin.equals("STOP")) {
                break;
            }
            collection = Integer.parseInt(calculatin);
            theNumberOfPieces -= collection;
        }
        if (theNumberOfPieces < 0) {
            System.out.println("No more cake left! You need " + Math.abs(theNumberOfPieces) + " pieces more.");
        } else {
            System.out.println(theNumberOfPieces + " pieces are left.");
        }
    }
}
