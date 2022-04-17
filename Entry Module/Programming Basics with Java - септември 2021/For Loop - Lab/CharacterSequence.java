import java.util.Scanner;

public class CharacterSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Програмата чете текст от конзолата, въведен от потребителя.
        String text = scanner.nextLine();
        //Програмата печата всеки символ от въведения текст на конзолата, поотделно.
        //Начална стойност: 0
        //Крайна стойност: общия брой символи - 1
        for (int i = 0; i <= (text.length() - 1); i++) {
            System.out.println(text.charAt(i));
        }
    }
}
