package bg.softuni.ArraysExercise;

import java.util.Scanner;

public class _04_ArrayRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] array = sc.nextLine().split(" ");
        int numberOfRotations = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfRotations; i++) {
            String firstElement = array[0];
            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = firstElement;
        }
        System.out.println(String.join(" ", array));
    }
}

