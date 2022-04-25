package bg.softuni.MethodsExercise;

import java.util.Scanner;

public class _06_MiddleCharacters {
    public static void main(String[] args) {
        //Create scanner
        Scanner scanner = new Scanner(System.in);
        //Read the string from the console
        String line = scanner.nextLine();
        //Print the result
        returnResult(line);
    }
    //Create two methods which will check if a given string is have even or odd count of digits
    //and get their middle characters
    static String returnEvenResult(String line) {
        //Create a local variable to hold the character
        char middleCharacterOne = 0;
        char middleCharacterTwo = 0;
        //Create a local variable to concatenate the characters
        String concatenateChars;
        //Check if a given string is have a even count of digits
        if (line.length() % 2 == 0) {
            middleCharacterOne = line.charAt((line.length() / 2) - 1);
            middleCharacterTwo = line.charAt(line.length() / 2);
        }
        //Using a StringBuilder to append the two characters
        StringBuilder sb = new StringBuilder();
        sb.append(middleCharacterOne);
        sb.append(middleCharacterTwo);
        //Save a StringBuilder result to the concatenateChars variables
        concatenateChars = sb.toString();
        //Return the result
        return concatenateChars;
    }
    static char returnOddResult(String line) {
        //Create local variable to hold the character
        char middleCharacter = 0;
        //Check if a given string is have a odd count of digits
        if (line.length() % 2 == 1) {
            middleCharacter = line.charAt((int) Math.floor(line.length() / 2));
        }
        //Return the result
        return middleCharacter;
    }
    //Create a method to print the result
    static void returnResult(String line) {
        if (line.length() % 2 == 0) {
            System.out.println(returnEvenResult(line));
        } else {
            System.out.println(returnOddResult(line));
        }
    }
}
