package JavaAdvancedExam26June2021.Python02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	* – that is a regular asterisk; it does nothing
        //•	e – represents an enemy.
        //•	f – this is the food
        //•	s – the place where the game starts
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];

        String[] commands = scanner.nextLine().split(", ");

        int startRow = -1;
        int startCol = -1;
        int startLength = 1;
        int foodToBeEat = 0;

        for (int i = 0; i < size; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int j = 0; j < size; j++) {
                if (line[j].equals("s")) {
                    startRow = i;
                    startCol = j;
                }
                if (line[j].equals("f")) {
                    foodToBeEat++;
                }
                matrix[i][j] = line[j];
            }
        }

        boolean isDead = false;
        boolean isWin = false;
        int food = 0;
        for (int i = 0; i < commands.length; i++) {
            String currentCommand = commands[i];
            switch (currentCommand) {
                case "up":
                    int nextRow = startRow - 1;
                    int nextCol = startCol;
                    if (nextRow < 0) {
                        nextRow = matrix.length - 1;
                    }
                    if (matrix[nextRow][nextCol].equals("*")) {
                        matrix[nextRow][nextCol] = "s";
                        matrix[startRow][startCol] = "*";
                        startRow = nextRow;
                    } else if (matrix[nextRow][nextCol].equals("e")) {
                        isDead = true;
                    } else if (matrix[nextRow][nextCol].equals("f")) {
                        matrix[nextRow][nextCol] = "s";
                        matrix[startRow][startCol] = "*";
                        food++;
                        startLength++;
                        startRow = nextRow;
                    }
                    break;
                case "down":
                    nextRow = startRow + 1;
                    nextCol = startCol;
                    if (nextRow >= matrix.length) {
                        nextRow = 0;
                    }
                    if (matrix[nextRow][nextCol].equals("*")) {
                        matrix[nextRow][nextCol] = "s";
                        matrix[startRow][startCol] = "*";
                        startRow = nextRow;
                    } else if (matrix[nextRow][nextCol].equals("e")) {
                        isDead = true;
                    } else if (matrix[nextRow][nextCol].equals("f")) {
                        matrix[nextRow][nextCol] = "s";
                        matrix[startRow][startCol] = "*";
                        food++;
                        startLength++;
                        startRow = nextRow;
                    }
                    break;
                case "left":
                    nextRow = startRow;
                    nextCol = startCol - 1;
                    if (nextCol < 0) {
                        nextCol = matrix.length - 1;
                    }
                    if (matrix[nextRow][nextCol].equals("*")) {
                        matrix[nextRow][nextCol] = "s";
                        matrix[startRow][startCol] = "*";
                        startCol = nextCol;
                    } else if (matrix[nextRow][nextCol].equals("e")) {
                        isDead = true;
                    } else if (matrix[nextRow][nextCol].equals("f")) {
                        matrix[nextRow][nextCol] = "s";
                        matrix[startRow][startCol] = "*";
                        food++;
                        startLength++;
                        startCol = nextCol;
                    }
                    break;
                case "right":
                    nextRow = startRow;
                    nextCol = startCol + 1;
                    if (nextCol >= matrix.length) {
                        nextCol = 0;
                    }
                    if (matrix[nextRow][nextCol].equals("*")) {
                        matrix[nextRow][nextCol] = "s";
                        matrix[startRow][startCol] = "*";
                        startCol = nextCol;
                    } else if (matrix[nextRow][nextCol].equals("e")) {
                        isDead = true;
                    } else if (matrix[nextRow][nextCol].equals("f")) {
                        matrix[nextRow][nextCol] = "s";
                        matrix[startRow][startCol] = "*";
                        food++;
                        startLength++;
                        startCol = nextCol;
                    }
                    break;
            }
            if (food == foodToBeEat) {
                isWin = true;
                break;
            }
        }

        if (isDead) {
            System.out.println("You lose! Killed by an enemy!");
        } else if (isWin) {
            System.out.println("You win! Final python length is " + startLength);
        } else  {
            System.out.printf("You lose! There is still %d food to be eaten.%n", foodToBeEat - food);
        }
    }
}
