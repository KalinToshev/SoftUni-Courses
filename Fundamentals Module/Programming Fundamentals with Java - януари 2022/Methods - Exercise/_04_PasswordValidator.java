package bg.softuni.MethodsExercise;

import java.util.Scanner;

public class _04_PasswordValidator {
    public static void main(String[] args) {
        //Write a program that checks if a given password is valid
        Scanner scanner = new Scanner(System.in);
        //Password rules:
        //6 – 10 characters (inclusive);
        //Consists only of letters and digits;
        //Have at least 2 digits

        //Read input
        String password = scanner.nextLine();
        //Insert methods
        isValidLength(password);
        isValidCharacters(password);
        isValidDigitsAndOutputValidIfTrue(password);
    }
    //Check if the password have valid length
    static void isValidLength(String password) {
        if (password.length() < 6 || password.length() > 10) {
            System.out.println("Password must be between 6 and 10 characters");
        }
    }
    //Check if the password have valid characters
    static void isValidCharacters(String password) {
        int characterCounts = 0;
        int len = password.length();
        for (int i = 0; i < len; i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                characterCounts++;
            }
        }
        if (characterCounts > 0) {
            System.out.println("Password must consist only of letters and digits");
        }
    }
    //Check if the password have least 2 digits
    static void isValidDigitsAndOutputValidIfTrue(String password) {
        //Count digits
        int counter = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == '0'
                    || password.charAt(i) == '9'
                    || password.charAt(i) == '8'
                    || password.charAt(i) == '7'
                    || password.charAt(i) == '6'
                    || password.charAt(i) == '5'
                    || password.charAt(i) == '4'
                    || password.charAt(i) == '3'
                    || password.charAt(i) == '2'
                    || password.charAt(i) == '1') {
                counter++;
            }
        }
        //Output
        if (counter < 2) {
            System.out.println("Password must have at least 2 digits");
        } else {
            returnOutput();
        }
    }
    //Create method if everything is valid to output the valid message
    static void returnOutput() {
        System.out.println("Password is valid");
    }
}
