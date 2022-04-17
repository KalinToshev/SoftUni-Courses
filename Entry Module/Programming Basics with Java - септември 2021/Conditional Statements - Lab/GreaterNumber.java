import java.util.Scanner;

public class GreaterNumber {
    public static void main(String[] args) {
        //Импортираме Scanner
        Scanner scanner = new Scanner(System.in);
        //Създаваме две променливи, които ще чакат вход от конзолата (цели числа)
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        //Създаваме if функция, с която проверявам кое от двете числа е по-голямо. По голямото число го принтирам
        if (a > b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }
}
