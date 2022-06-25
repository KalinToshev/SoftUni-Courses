package JavaAdvancedExam25June2022.StickyFingers02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startRow = -1;
        int startCol = -1;

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        String[] commandsInput = scanner.nextLine().split(",");

        for (int i = 0; i < size; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = line[j];
                if (line[j].equals("D")) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        boolean isCought = false;
        int totalStolenMoney = 0;

        for (int i = 0; i < commandsInput.length; i++) {
            if (isCought) {
                break;
            }
            String command = commandsInput[i];
            switch (command) {
                case "up":
                    int nextRow = startRow - 1;
                    int nextCol = startCol;
                    if (nextRow < 0) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        break;
                    }
                    if (matrix[nextRow][nextCol].equals("P")) {
                        isCought = true;
                        System.out.printf("You got caught with %d$, and you are going to jail.%n", totalStolenMoney);
                        matrix[startRow][startCol] = "+";
                        matrix[nextRow][nextCol] = "#";
                        break;
                    } else if (matrix[nextRow][nextCol].equals("+")) {
                        matrix[nextRow][nextCol] = "D";
                        matrix[startRow][startCol] = "+";
                    } else if (matrix[nextRow][nextCol].equals("$")) {
                        matrix[nextRow][nextCol] = "D";
                        matrix[startRow][startCol] = "+";
                        int calculateMoney = nextRow * nextCol;
                        totalStolenMoney += calculateMoney;
                        System.out.printf("You successfully stole %d$.%n", calculateMoney);
                    }
                    startRow = nextRow;
                    break;
                case "down":
                    nextRow = startRow + 1;
                    nextCol = startCol;
                    if (nextRow >= matrix.length) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        break;
                    }
                    if (matrix[nextRow][nextCol].equals("P")) {
                        isCought = true;
                        System.out.printf("You got caught with %d$, and you are going to jail.%n", totalStolenMoney);
                        matrix[startRow][startCol] = "+";
                        matrix[nextRow][nextCol] = "#";
                        break;
                    } else if (matrix[nextRow][nextCol].equals("+")) {
                        matrix[nextRow][nextCol] = "D";
                        matrix[startRow][startCol] = "+";
                    } else if (matrix[nextRow][nextCol].equals("$")) {
                        matrix[nextRow][nextCol] = "D";
                        matrix[startRow][startCol] = "+";
                        int calculateMoney = nextRow * nextCol;
                        totalStolenMoney += calculateMoney;
                        System.out.printf("You successfully stole %d$.%n", calculateMoney);
                    }
                    startRow = nextRow;
                    break;
                case "left":
                    nextRow = startRow;
                    nextCol = startCol - 1;
                    if (nextCol < 0) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        break;
                    }
                    if (matrix[nextRow][nextCol].equals("P")) {
                        isCought = true;
                        System.out.printf("You got caught with %d$, and you are going to jail.%n", totalStolenMoney);
                        matrix[startRow][startCol] = "+";
                        matrix[nextRow][nextCol] = "#";
                        break;
                    } else if (matrix[nextRow][nextCol].equals("+")) {
                        matrix[nextRow][nextCol] = "D";
                        matrix[startRow][startCol] = "+";
                    } else if (matrix[nextRow][nextCol].equals("$")) {
                        matrix[nextRow][nextCol] = "D";
                        matrix[startRow][startCol] = "+";
                        int calculateMoney = nextRow * nextCol;
                        totalStolenMoney += calculateMoney;
                        System.out.printf("You successfully stole %d$.%n", calculateMoney);
                    }
                    startCol = nextCol;
                    break;
                case "right":
                    nextRow = startRow;
                    nextCol = startCol + 1;
                    if (nextCol >= matrix.length) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        break;
                    }
                    if (matrix[nextRow][nextCol].equals("P")) {
                        isCought = true;
                        System.out.printf("You got caught with %d$, and you are going to jail.%n", totalStolenMoney);
                        matrix[startRow][startCol] = "+";
                        matrix[nextRow][nextCol] = "#";
                        break;
                    } else if (matrix[nextRow][nextCol].equals("+")) {
                        matrix[nextRow][nextCol] = "D";
                        matrix[startRow][startCol] = "+";
                    } else if (matrix[nextRow][nextCol].equals("$")) {
                        matrix[nextRow][nextCol] = "D";
                        matrix[startRow][startCol] = "+";
                        int calculateMoney = nextRow * nextCol;
                        totalStolenMoney += calculateMoney;
                        System.out.printf("You successfully stole %d$.%n", calculateMoney);
                    }
                    startCol = nextCol;
                    break;
            }
        }

        if (!isCought) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalStolenMoney);
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
