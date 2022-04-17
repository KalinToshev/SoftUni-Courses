import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //========================
        //ВХОД
        //========================
        //1.	Дължина в см – цяло число в интервала [10 … 500]
        //2.	Широчина в см – цяло число в интервала [10 … 300]
        //3.	Височина в см – цяло число в интервала [10… 200]
        //4.	Процент  – реално число в интервала [0.000 … 100.000]
        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percenteges = Double.parseDouble(scanner.nextLine());
        //========================
        //ИЗЧИСЛЕНИЯ
        //========================
        double volumeOfTheAquarium = length * width * height;
        double volumeInLiters = volumeOfTheAquarium * 0.001;
        double neededLiters = volumeInLiters * (1 - (percenteges / 100));
        System.out.println(neededLiters);
    }
}
