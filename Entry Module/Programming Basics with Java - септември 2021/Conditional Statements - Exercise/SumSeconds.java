import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Прочитаме входните данни на тримата състезатели в секудни
        int timeFirst = Integer.parseInt(scanner.nextLine());
        int timeSecond = Integer.parseInt(scanner.nextLine());
        int timeThird = Integer.parseInt(scanner.nextLine());
        //Създаваме нова променлива, в която да се съхранява сбора от секундите на тримата състезатели
        int totalSeconds = timeFirst + timeSecond + timeThird;
        //Създаваме две нови променливи, с които ще изчислим минутите и секудните
        int minutes = totalSeconds / 60;
        int secondsLeft = totalSeconds % 60;
        //Принираме резултата
        if (secondsLeft < 10) {
            System.out.printf("%d:0%d", minutes, secondsLeft);
        } else {
            System.out.printf("%d:%d", minutes, secondsLeft);
        }
    }
}
