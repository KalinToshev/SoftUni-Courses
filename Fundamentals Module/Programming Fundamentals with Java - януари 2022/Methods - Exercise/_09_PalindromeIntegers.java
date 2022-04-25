package bg.softuni.MethodsExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _09_PalindromeIntegers {
    public static void main(String[] args) {
        //Create scanner
        Scanner scanner = new Scanner(System.in);
        //Create two ArrayLists to hold the reverse numbers
        List<Integer> items = new ArrayList<>();

        //Create while loop to get input from the console until receive "END"
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            //Parse the input to the array
            items = Arrays.stream(input.split("")).map(Integer::parseInt).collect(Collectors.toList());
            //Output the value (true or false)
            System.out.println(reverseArray(items));
            //Read next input
            input = scanner.nextLine();
        }
    }
    //Create a method to reverse an array
    static boolean reverseArray(List<Integer> items) {
      //Create a local List to use it fo reversing the original list
        List<Integer> reversedItems = new ArrayList<>();
        //Add items to the List in reversed order
        for (int i = items.size(); i > 0; i--) {
            reversedItems.add(items.get(i -1));
        }
        //Make a verification and return value
        return items.equals(reversedItems);
    }
}
