import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int widthOfFreeSpace = Integer.parseInt(scanner.nextLine());
        int lengthOfFreeSpace = Integer.parseInt(scanner.nextLine());
        int heightOfFreeSpace = Integer.parseInt(scanner.nextLine());
        int cubicMetersAvailable = widthOfFreeSpace * lengthOfFreeSpace * heightOfFreeSpace;
        int cubicMetersByCartoon = 0;
        while (cubicMetersAvailable >= cubicMetersByCartoon) {
            String input = scanner.nextLine();
            if (input.equals("Done")) {
                break;
            }
            cubicMetersByCartoon += Integer.parseInt(input);
        }
        if (cubicMetersAvailable < cubicMetersByCartoon) {
            System.out.println("No more free space! You need " + Math.abs(cubicMetersByCartoon - cubicMetersAvailable) + " Cubic meters more.");
        } else {
            System.out.println((cubicMetersAvailable - cubicMetersByCartoon) + " Cubic meters left.");
        }
    }
}
