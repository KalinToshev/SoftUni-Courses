import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String book = scanner.nextLine();
        String anotherBook = "";
        int counter = 0;
        while (!anotherBook.equals(book)) {
            anotherBook = scanner.nextLine();
            if (anotherBook.equals(book)) {
                System.out.printf("You checked %d books and found it.", counter);
                break;
            }
            if (anotherBook.equals("No More Books")) {
                System.out.println("The book you search is not here!");
                System.out.printf("You checked %d books.", counter);
                break;
            }
                counter++;
        }
    }
}
