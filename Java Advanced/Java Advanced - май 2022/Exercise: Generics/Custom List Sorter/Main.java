package CustomListSorter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> list = new CustomList<String>();

        String line;
        while (!"END".equals(line = scanner.nextLine())) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Add":
                    //Adds the given element to the end of the list.
                    list.add(tokens[1]);
                    break;
                case "Remove":
                    //Removes the element at the given index.
                    list.remove(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":
                    //Prints if the list contains the given element (true or false).
                    System.out.println(list.contains(tokens[1]));
                    break;
                case "Swap":
                    //Swaps the elements at the given indexes.
                    list.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "Greater":
                    //Counts the elements that are greater than the given element
                    //and prints their count
                    System.out.println(list.countGreaterThan(tokens[1]));
                    break;
                case "Max":
                    //Prints the maximum element in the list.
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    //Prints the minimum element in the list.
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    //Prints all elements in the list, each on a separate line.
                    list.print();
                    break;
                case "Sort":
                    //Sort the elements in the list in ascending order.
                    list.sort();
                    break;
            }
        }
    }
}
