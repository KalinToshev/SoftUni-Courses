package bg.softuni.ListsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Read first List
        List<Integer> arrOne = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        //Read second List
        List<Integer> arrTwo = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        //Create List to hold the result
        List<Integer> result = new ArrayList<>();
        //Check if arrTwo equals arrOne
        if (arrOne.equals(arrTwo)) {
            //Loop through the arrTwo elements
            for (int i = 0; i < arrTwo.size(); i++) {
                //Add the numbers to the result List in format given in the word document
                result.add(arrOne.get(i));
                result.add(arrTwo.get(i));
            }
        } else {
            //Loop through the arrTwo elements
            if (arrOne.size() > arrTwo.size()) {
                for (int i = 0; i < arrTwo.size(); i++) {
                    //Add the numbers to the result List in format given in the word document
                    result.add(arrOne.get(i));
                    result.add(arrTwo.get(i));
                }

                for (int i = arrTwo.size(); i < arrOne.size(); i++) {
                    result.add(arrOne.get(i));
                }
            } else {
                for (int i = 0; i < arrOne.size(); i++) {
                    //Add the numbers to the result List in format given in the word document
                    result.add(arrOne.get(i));
                    result.add(arrTwo.get(i));
                }

                for (int i = arrOne.size(); i < arrTwo.size(); i++) {
                    result.add(arrTwo.get(i));
                }
            }
        }
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }
}
