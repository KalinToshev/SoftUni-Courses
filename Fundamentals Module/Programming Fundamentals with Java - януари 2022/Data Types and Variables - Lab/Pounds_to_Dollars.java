package bg.softuni.Data_Types_and_Variables_Lab;

import java.math.BigDecimal;
import java.util.Scanner;

public class Pounds_to_Dollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        BigDecimal pounds = new BigDecimal(scanner.nextLine());
        BigDecimal usd = pounds.multiply(BigDecimal.valueOf(1.36));
        //Output
        System.out.printf("%.3f", usd);
    }
}
