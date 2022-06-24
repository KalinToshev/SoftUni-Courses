package JavaAdvancedExam28June2020.Snake02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startRow = -1;
        int startCol = -1;
        int foodQuantity = 0;

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        for (int i = 0; i < size; i++) {
            String[] line = scanner.nextLine().split("");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = line[j];
                if (line[j].equals("S")) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        boolean outOfTerritory = false;
        boolean eatenEnoughFood = false;
        while (!(outOfTerritory || eatenEnoughFood)) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    int nextRow = startRow - 1;
                    int nextCol = startCol;
                    if (nextRow < 0) {
                        outOfTerritory = true;
                        matrix[startRow][startCol] = ".";
                        break;
                    }
                    switch (matrix[nextRow][nextCol]) {
                        case "*":
                            foodQuantity++;
                            matrix[startRow][startCol] = ".";
                            matrix[nextRow][nextCol] = "S";
                            startRow = nextRow;
                        break;
                        case "B":
                            int lairFound = 0;
                            int teleportRow = -1;
                            int teleportCol = -1;
                            boolean burrowsFound = false;
                            for (int i = 0; i < size; i++) {
                                if (burrowsFound) {
                                    break;
                                }
                                for (int j = 0; j < size; j++) {
                                    if (matrix[i][j].equals("B")) {
                                        if (lairFound == 0) {
                                            lairFound++;
                                        } else if (lairFound == 1) {
                                            teleportRow = i;
                                            teleportCol = j;
                                            burrowsFound = true;
                                        }
                                    }
                                }
                            }
                            matrix[nextRow][nextCol] = ".";
                            matrix[startRow][startCol] = ".";
                            matrix[teleportRow][teleportCol] = "S";
                            startRow = teleportRow;
                            startCol = teleportCol;
                        break;
                        case "-":
                            matrix[startRow][startCol] = ".";
                            matrix[nextRow][nextCol] = "S";
                            startRow = nextRow;
                        break;
                    }
                    break;
                case "down":
                    nextRow = startRow + 1;
                    nextCol = startCol;
                    if (nextRow >= matrix.length) {
                        outOfTerritory = true;
                        matrix[startRow][startCol] = ".";
                        break;
                    }
                    switch (matrix[nextRow][nextCol]) {
                        case "*":
                            foodQuantity++;
                            matrix[startRow][startCol] = ".";
                            matrix[nextRow][nextCol] = "S";
                            startRow = nextRow;
                            break;
                        case "B":
                            int lairFound = 0;
                            int teleportRow = -1;
                            int teleportCol = -1;
                            boolean burrowsFound = false;
                            for (int i = 0; i < size; i++) {
                                if (burrowsFound) {
                                    break;
                                }
                                for (int j = 0; j < size; j++) {
                                    if (matrix[i][j].equals("B")) {
                                        if (lairFound == 0) {
                                            lairFound++;
                                        } else if (lairFound == 1) {
                                            teleportRow = i;
                                            teleportCol = j;
                                            burrowsFound = true;
                                        }
                                    }
                                }
                            }
                            matrix[nextRow][nextCol] = ".";
                            matrix[startRow][startCol] = ".";
                            matrix[teleportRow][teleportCol] = "S";
                            startRow = teleportRow;
                            startCol = teleportCol;
                            break;
                        case "-":
                            matrix[startRow][startCol] = ".";
                            matrix[nextRow][nextCol] = "S";
                            startRow = nextRow;
                            break;
                    }
                    break;
                case "left":
                    nextRow = startRow;
                    nextCol = startCol - 1;
                    if (nextCol < 0) {
                        outOfTerritory = true;
                        matrix[startRow][startCol] = ".";
                        break;
                    }
                    switch (matrix[nextRow][nextCol]) {
                        case "*":
                            foodQuantity++;
                            matrix[startRow][startCol] = ".";
                            matrix[nextRow][nextCol] = "S";
                            startCol = nextCol;
                            break;
                        case "B":
                            int lairFound = 0;
                            int teleportRow = -1;
                            int teleportCol = -1;
                            boolean burrowsFound = false;
                            for (int i = 0; i < size; i++) {
                                if (burrowsFound) {
                                    break;
                                }
                                for (int j = 0; j < size; j++) {
                                    if (matrix[i][j].equals("B")) {
                                        if (lairFound == 0) {
                                            lairFound++;
                                        } else if (lairFound == 1) {
                                            teleportRow = i;
                                            teleportCol = j;
                                            burrowsFound = true;
                                        }
                                    }
                                }
                            }
                            matrix[nextRow][nextCol] = ".";
                            matrix[startRow][startCol] = ".";
                            matrix[teleportRow][teleportCol] = "S";
                            startRow = teleportRow;
                            startCol = teleportCol;
                            break;
                        case "-":
                            matrix[startRow][startCol] = ".";
                            matrix[nextRow][nextCol] = "S";
                            startCol = nextCol;
                            break;
                    }
                    break;
                case "right":
                    nextRow = startRow;
                    nextCol = startCol + 1;
                    if (nextCol >= matrix.length) {
                        outOfTerritory = true;
                        matrix[startRow][startCol] = ".";
                        break;
                    }
                    switch (matrix[nextRow][nextCol]) {
                        case "*":
                            foodQuantity++;
                            matrix[startRow][startCol] = ".";
                            matrix[nextRow][nextCol] = "S";
                            startCol = nextCol;
                            break;
                        case "B":
                            int lairFound = 0;
                            int teleportRow = -1;
                            int teleportCol = -1;
                            boolean burrowsFound = false;
                            for (int i = 0; i < size; i++) {
                                if (burrowsFound) {
                                    break;
                                }
                                for (int j = 0; j < size; j++) {
                                    if (matrix[i][j].equals("B")) {
                                        if (lairFound == 0) {
                                            lairFound++;
                                        } else if (lairFound == 1) {
                                            teleportRow = i;
                                            teleportCol = j;
                                            burrowsFound = true;
                                        }
                                    }
                                }
                            }
                            matrix[nextRow][nextCol] = ".";
                            matrix[startRow][startCol] = ".";
                            matrix[teleportRow][teleportCol] = "S";
                            startRow = teleportRow;
                            startCol = teleportCol;
                            break;
                        case "-":
                            matrix[startRow][startCol] = ".";
                            matrix[nextRow][nextCol] = "S";
                            startCol = nextCol;
                            break;
                    }
                    break;
            }
            if (foodQuantity >= 10) {
                eatenEnoughFood = true;
            }
        }
        if (outOfTerritory) {
            System.out.println("Game over!");
        }
        if (eatenEnoughFood) {
            System.out.println("You won! You fed the snake.");
        }
        System.out.printf("Food eaten: %d%n", foodQuantity);
        printMatrix(size, matrix);
    }
    private static void printMatrix(int size, String[][] matrix) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
