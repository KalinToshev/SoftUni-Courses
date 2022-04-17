import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startNumber = Integer.parseInt(scanner.nextLine());//начало на интервал
        int endNumber = Integer.parseInt(scanner.nextLine()); //край на интервал
        int magicNumber = Integer.parseInt(scanner.nextLine()); //магическото число

        boolean isFound = false; //намерена ли е валидна комбинация?
        //false -> не е намерена; true -> намерена комбинация
        int countCombinations = 0; //броя на комбинациите
        //за всяка една стойност на първото число: всяка една стойност на второто число
        for (int firstNumber = startNumber; firstNumber <= endNumber; firstNumber++) {
            for (int secondNumber = startNumber; secondNumber <= endNumber; secondNumber++) {
                //комбинацията от двете числа: firstNumber и secondNumber
                countCombinations++;
                int sum = firstNumber + secondNumber;
                if (sum == magicNumber) {
                    isFound = true;
                    System.out.printf("Combination N:%d (%d + %d = %d)", countCombinations, firstNumber, secondNumber, magicNumber);
                    break;
                }
            }
            //ако втория цикъл се е прекратил от break -> isFound = true
            if (isFound) {
                break;
            }

        }
        //минали сме през всички комбонации
        if (!isFound) { //isFound == false
            System.out.printf("%d combinations - neither equals %d", countCombinations, magicNumber);
        }
    }
}
