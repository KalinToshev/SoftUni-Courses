package bg.softuni.ListsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Create List to hold the input form the console
        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        //Create a List to hold the processed numbers List for even
        List<Integer> evenNumbers = new ArrayList<>();
        //Create a list to hold the processed numbers List for odd
        List<Integer> oddNumbers = new ArrayList<>();
        //Create a variable to hold the length of the number List
        int sizeOfNumbersList = numbers.size() - 1;
        //Check if the size of numbers List is odd or even
        if (numbers.size() % 2 == 0) {
            //Even
            workWithEvenNumbersList(numbers, evenNumbers, sizeOfNumbersList);
        } else {
            //Odd
            workWithOddNumbersList(numbers, oddNumbers, sizeOfNumbersList);
        }
    }

    private static void workWithEvenNumbersList(List<Integer> numbers, List<Integer> evenNumbers, int sizeOfNumbersList) {
        //Loop through all elements in numbers List
        for (int i = 0; i < numbers.size(); i++) {
            if (i + 1 == sizeOfNumbersList) {
                int localSum = 0;
                localSum = numbers.get(i) + numbers.get(sizeOfNumbersList);
                evenNumbers.add(localSum);
                break;
            }
            //Create a local variable to sum the numbers in given order
            int sum = 0;
            //Sum the elements
            sum = numbers.get(i) + numbers.get(sizeOfNumbersList);
            //Add the sum to the new List
            evenNumbers.add(sum);

            sizeOfNumbersList--;
            sum = 0;
        }
        //Print the result
        for (Integer evenNumber : evenNumbers) {
            System.out.print(evenNumber + " ");
        }
    }

    private static void workWithOddNumbersList(List<Integer> numbers, List<Integer> oddNumbers, int sizeOfNumbersList) {
        //Loop through all elements in numbers List
        for (int i = 0; i < numbers.size(); i++) {
            if (i == sizeOfNumbersList) {
                oddNumbers.add(numbers.get(i));
                break;
            }
            //Create a local variable to sum the numbers in given order
            int sum = 0;
            //Sum the elements
            sum = numbers.get(i) + numbers.get(sizeOfNumbersList);
            //Add the sum to the new List
            oddNumbers.add(sum);

            sizeOfNumbersList--;
            sum = 0;
        }
        //Print the result
        for (Integer oddNumber : oddNumbers) {
            System.out.print(oddNumber + " ");
        }
    }
}
