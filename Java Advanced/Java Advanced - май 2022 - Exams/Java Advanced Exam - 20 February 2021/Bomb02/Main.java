package JavaAdvancedExam20February2021.Bomb02;

import java.util.Scanner;

public class Main {
    //+ – regular position on the field.
    //e – end of the route.
    //B – bomb
    //s – the place where the sapper starts
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startRow = -1;
        int startCol = -1;
        int bombsCount = 0;


        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        String[][] matrix = new String[size][size];

        for (int i = 0; i < size; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = line[j];
                if (line[j].equals("s")) {
                    startRow = i;
                    startCol = j;
                } else if (line[j].equals("B")) {
                    bombsCount++;
                }
            }
        }

        boolean isEndOfRoute = false;
        boolean allBombsFound = false;
        boolean endOfCommands = true;
        int foundBombs = 0;
        for (int i = 0; i < commands.length; i++) {
            String currentCommand = commands[i];
            switch (currentCommand) {
                case "left":
                    int nextRow = startRow;
                    int nextCol = startCol - 1;
                    if (nextCol < 0) {
                        nextCol = 0;
                    }
                    if (matrix[nextRow][nextCol].equals("+")) {
                        matrix[startRow][startCol] = "+";
                        matrix[nextRow][nextCol] = "s";
                        startCol = nextCol;
                    } else if (matrix[nextRow][nextCol].equals("e")) {
                        isEndOfRoute = true;
                    } else if (matrix[nextRow][nextCol].equals("B")) {
                        matrix[nextRow][nextCol] = "s";
                        matrix[startRow][startCol] = "+";
                        startCol = nextCol;
                        System.out.println("You found a bomb!");
                        foundBombs++;
                    }
                    break;
                case "right":
                    nextRow = startRow;
                    nextCol = startCol + 1;
                    if (nextCol >= matrix.length) {
                        nextCol = matrix.length - 1;
                    }
                    if (matrix[nextRow][nextCol].equals("+")) {
                        matrix[startRow][startCol] = "+";
                        matrix[nextRow][nextCol] = "s";
                        startCol = nextCol;
                    } else if (matrix[nextRow][nextCol].equals("e")) {
                        isEndOfRoute = true;
                    } else if (matrix[nextRow][nextCol].equals("B")) {
                        matrix[nextRow][nextCol] = "s";
                        matrix[startRow][startCol] = "+";
                        startCol = nextCol;
                        System.out.println("You found a bomb!");
                        foundBombs++;
                    }
                    break;
                case "up":
                    nextRow = startRow - 1;
                    nextCol = startCol;
                    if (nextRow < 0) {
                        nextRow = 0;
                    }
                    if (matrix[nextRow][nextCol].equals("+")) {
                        matrix[startRow][startCol] = "+";
                        matrix[nextRow][nextCol] = "s";
                        startRow = nextRow;
                    } else if (matrix[nextRow][nextCol].equals("e")) {
                        isEndOfRoute = true;
                    } else if (matrix[nextRow][nextCol].equals("B")) {
                        matrix[nextRow][nextCol] = "s";
                        matrix[startRow][startCol] = "+";
                        startRow = nextRow;
                        System.out.println("You found a bomb!");
                        foundBombs++;
                    }
                    break;
                case "down":
                    nextRow = startRow + 1;
                    nextCol = startCol;
                    if (nextRow >= matrix.length) {
                        nextRow = matrix.length - 1;
                    }
                    if (matrix[nextRow][nextCol].equals("+")) {
                        matrix[startRow][startCol] = "+";
                        matrix[nextRow][nextCol] = "s";
                        startRow = nextRow;
                    } else if (matrix[nextRow][nextCol].equals("e")) {
                        isEndOfRoute = true;
                    } else if (matrix[nextRow][nextCol].equals("B")) {
                        matrix[nextRow][nextCol] = "s";
                        matrix[startRow][startCol] = "+";
                        startRow = nextRow;
                        System.out.println("You found a bomb!");
                        foundBombs++;
                    }
                    break;
            }
            if (foundBombs == bombsCount) {
                allBombsFound = true;
            }
            if (allBombsFound) {
                System.out.println("Congratulations! You found all bombs!");
                endOfCommands = false;
                break;
            }
            if (isEndOfRoute) {
                System.out.printf("END! %d bombs left on the field%n", bombsCount - foundBombs);
                endOfCommands = false;
                break;
            }
        }
        if (endOfCommands) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", bombsCount - foundBombs, startRow, startCol);
        }
    }
}
