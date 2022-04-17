import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double worldRecord = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double distanceIn1Meter = Double.parseDouble(scanner.nextLine());
        double zabavqne = Math.floor(distance / 15) * 12.5;
        double totalTimeIvan = distance * distanceIn1Meter + zabavqne;
        double nedostigashtiSekundi = totalTimeIvan - worldRecord;
        if (totalTimeIvan < worldRecord) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", totalTimeIvan);
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", nedostigashtiSekundi);
        }
    }
}
