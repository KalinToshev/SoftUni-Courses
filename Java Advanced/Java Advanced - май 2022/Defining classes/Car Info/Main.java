import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String input = scanner.nextLine();

            Car car = new Car();

            car.setBrand(input.split("\\s+")[0]);
            car.setModel(input.split("\\s+")[1]);
            car.setHorsePower(Integer.parseInt(input.split("\\s+")[2]));

            System.out.println(car.carInfo());
        }

    }
}
