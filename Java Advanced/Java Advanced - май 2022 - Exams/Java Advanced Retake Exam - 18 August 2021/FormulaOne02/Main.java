package JavaAdvancedRetakeExam18August2021.FormulaOne02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];

        int countOfCommands = Integer.parseInt(scanner.nextLine());

        int playerRow = -1;
        int playerCol = -1;


        //player -> P
        //empty slots -> .
        //finish mark -> F
        //bonuses -> B
        //traps -> T
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();
            if (line.contains("P")) {
                playerRow = i;
                playerCol = line.indexOf("P");
            }
        }

        boolean finalIsReached = false;
        int nextRow = -1;
        int nextCol = -1;
        for (int i = 0; i < countOfCommands; i++) {
            if (finalIsReached) {
                break;
            }
            //Commands will be in the format of up, down, left or right.
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    nextRow = playerRow - 1;
                    nextCol = playerCol;
                    if (nextRow < 0) {
                        nextRow = matrix.length - 1;
                    }

                    if (matrix[nextRow][nextCol] == '.') {
                        matrix[playerRow][playerCol] = '.';
                        matrix[nextRow][nextCol] = 'P';
                        playerRow = nextRow;
                    } else if (matrix[nextRow][nextCol] == 'F') {
                        finalIsReached = true;
                        matrix[playerRow][playerCol] = '.';
                        matrix[nextRow][nextCol] = 'P';
                        playerRow = nextRow;
                    } else if (matrix[nextRow][nextCol] == 'T') {
                        nextRow = playerRow;
                        matrix[playerRow][playerCol] = '.';
                        matrix[nextRow][nextCol] = 'P';
                    } else if (matrix[nextRow][nextCol] == 'B') {
                        nextRow = playerRow - 2;
                        if (nextRow < 0) {
                            nextRow = matrix.length - 1;
                        }
                        matrix[playerRow][playerCol] = '.';
                        matrix[nextRow][nextCol] = 'P';
                        playerRow = nextRow;
                    }
                    break;
                case "down":
                    nextRow = playerRow + 1;
                    nextCol = playerCol;
                    if (nextRow >= matrix.length) {
                        nextRow = 0;
                    }

                    if (matrix[nextRow][nextCol] == '.') {
                        matrix[playerRow][playerCol] = '.';
                        matrix[nextRow][nextCol] = 'P';
                        playerRow = nextRow;
                    } else if (matrix[nextRow][nextCol] == 'F') {
                        finalIsReached = true;
                        matrix[playerRow][playerCol] = '.';
                        matrix[nextRow][nextCol] = 'P';
                        playerRow = nextRow;
                    } else if (matrix[nextRow][nextCol] == 'T') {
                        nextRow = playerRow;
                        matrix[playerRow][playerCol] = '.';
                        matrix[nextRow][nextCol] = 'P';
                    } else if (matrix[nextRow][nextCol] == 'B') {
                        nextRow = playerRow + 2;
                        if (nextRow >= matrix.length) {
                            nextRow = 0;
                        }
                        matrix[playerRow][playerCol] = '.';
                        matrix[nextRow][nextCol] = 'P';
                        playerRow = nextRow;
                    }
                    break;
                case "left":
                    nextRow = playerRow;
                    nextCol = playerCol - 1;
                    if (nextCol < 0) {
                        nextCol = matrix.length - 1;
                    }

                    if (matrix[nextRow][nextCol] == '.') {
                        matrix[playerRow][playerCol] = '.';
                        matrix[nextRow][nextCol] = 'P';
                        playerCol = nextCol;
                    } else if (matrix[nextRow][nextCol] == 'F') {
                        finalIsReached = true;
                        matrix[playerRow][playerCol] = '.';
                        matrix[nextRow][nextCol] = 'P';
                        playerCol = nextCol;
                    } else if (matrix[nextRow][nextCol] == 'T') {
                        nextCol = playerCol;
                        matrix[playerRow][playerCol] = '.';
                        matrix[nextRow][nextCol] = 'P';
                    } else if (matrix[nextRow][nextCol] == 'B') {
                        nextCol = playerRow - 2;
                        if (nextCol < 0) {
                            nextCol = matrix.length - 1;
                        }
                        matrix[playerRow][playerCol] = '.';
                        matrix[nextRow][nextCol] = 'P';
                        playerCol = nextCol;
                    }
                    break;
                case "right":
                    nextRow = playerRow;
                    nextCol = playerCol + 1;
                    if (nextCol >= matrix.length) {
                        nextCol = 0;
                    }

                    if (matrix[nextRow][nextCol] == '.') {
                        matrix[playerRow][playerCol] = '.';
                        matrix[nextRow][nextCol] = 'P';
                        playerCol = nextCol;
                    } else if (matrix[nextRow][nextCol] == 'F') {
                        finalIsReached = true;
                        matrix[playerRow][playerCol] = '.';
                        matrix[nextRow][nextCol] = 'P';
                        playerCol = nextCol;
                    } else if (matrix[nextRow][nextCol] == 'T') {
                        nextCol = playerCol;
                        matrix[playerRow][playerCol] = '.';
                        matrix[nextRow][nextCol] = 'P';
                    } else if (matrix[nextRow][nextCol] == 'B') {
                        nextCol = playerRow + 2;
                        if (nextCol >= matrix.length) {
                            nextCol = 0;
                        }
                        matrix[playerRow][playerCol] = '.';
                        matrix[nextRow][nextCol] = 'P';
                        playerCol = nextCol;
                    }
                    break;
            }
        }

        if (finalIsReached) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        print2dArr(matrix);
    }

    private static void print2dArr(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}
