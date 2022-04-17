import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int nights = days - 1;
        double totalNightsCost = 0.0;
        String room = scanner.nextLine();
        String opinion = scanner.nextLine();
        switch (room){
            case "room for one person":
                totalNightsCost = nights *  18;
                if (opinion.equals("positive")) {
                    totalNightsCost = totalNightsCost + (totalNightsCost * 0.25);
                } else if (opinion.equals("negative")) {
                    totalNightsCost = totalNightsCost - (totalNightsCost * 0.1);
                }
                break;
            case "apartment":
                totalNightsCost = nights * 25;
                if (nights < 10) {
                    totalNightsCost = totalNightsCost - (totalNightsCost * 0.3);
                } else if (nights >= 10 && nights <= 15) {
                    totalNightsCost = totalNightsCost - (totalNightsCost * 0.35);
                } else if (nights > 15) {
                    totalNightsCost = totalNightsCost - (totalNightsCost * 0.5);
                }
                if (opinion.equals("positive")) {
                    totalNightsCost = totalNightsCost + (totalNightsCost * 0.25);
                } else if (opinion.equals("negative")) {
                    totalNightsCost = totalNightsCost - (totalNightsCost * 0.1);
                }
                break;
            case "president apartment":
                totalNightsCost = nights * 35;
                if (nights < 10) {
                    totalNightsCost = totalNightsCost - (totalNightsCost * 0.1);
                } else if (nights >= 10 && nights <= 15) {
                    totalNightsCost = totalNightsCost - (totalNightsCost * 0.15);
                } else if (nights > 15) {
                    totalNightsCost = totalNightsCost - (totalNightsCost * 0.2);
                }
                if (opinion.equals("positive")) {
                    totalNightsCost = totalNightsCost + (totalNightsCost * 0.25);
                } else if (opinion.equals("negative")) {
                    totalNightsCost = totalNightsCost - (totalNightsCost * 0.1);
                }
                break;
        }
        System.out.printf("%.2f", totalNightsCost);
    }
}
