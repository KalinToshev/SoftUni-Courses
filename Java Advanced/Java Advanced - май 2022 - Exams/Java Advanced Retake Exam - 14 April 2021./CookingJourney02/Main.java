package JavaAdvancedRetakeExam14April2021.CookingJourney02;

import java.util.Scanner;

public class Main {
    //You will be placed in a random position, marked with the letter 'S'
    //On random positions, there will be clients, marked with a single digit.
    //There may also be pillars. Their count will be either 0 or 2
    //and they are marked with the letter - 'P'
    //All of the empty positions will be marked with '-'.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startRow = -1;
        int startCol = -1;

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.split("");
            if (line.contains("S")) {
                startRow = i;
                startCol = line.indexOf("S");
            }
        }

        int collectedMoney = 0;
        boolean isOut = false;
        boolean enoughMoney = false;

        while (true) {
            if (isOut) {
                System.out.println("Bad news! You are out of the pastry shop.");
                break;
            } else if (enoughMoney) {
                System.out.println("Good news! You succeeded in collecting enough money!");
                break;
            }
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    int nextRow = startRow -1;
                    int nextCol = startCol;
                    if (nextRow < 0) {
                        isOut = true;
                        matrix[startRow][startCol] = "-";
                        break;
                    }
                    if (matrix[nextRow][nextCol].equals("-")) {
                        matrix[nextRow][nextCol] = "S";
                        matrix[startRow][startCol] = "-";
                        startRow = nextRow;
                    } else if (matrix[nextRow][nextCol].equals("P")) {
                        int pillarsFound = 0;
                        int teleportRow = -1;
                        int teleportCol = -1;
                        boolean pilarFound = false;
                        for (int i = 0; i < size; i++) {
                            if (pilarFound) {
                                break;
                            }
                            for (int j = 0; j < size; j++) {
                                if (matrix[i][j].equals("P")) {
                                    if (pillarsFound == 0) {
                                        pillarsFound++;
                                    } else if (pillarsFound == 1) {
                                        teleportRow = i;
                                        teleportCol = j;
                                        pilarFound = true;
                                    }
                                }
                            }
                        }
                        matrix[nextRow][nextCol] = "-";
                        matrix[startRow][startCol] = "-";
                        matrix[teleportRow][teleportCol] = "S";
                        startRow = teleportRow;
                        startCol = teleportCol;
                    } else {
                        int coin = Integer.parseInt(matrix[nextRow][nextCol]);
                        collectedMoney += coin;
                        matrix[nextRow][nextCol] = "S";
                        matrix[startRow][startCol] = "-";
                        startRow = nextRow;
                    }
                    break;
                case "down":
                    nextRow = startRow + 1;
                    nextCol = startCol;
                    if (nextRow >= matrix.length) {
                        isOut = true;
                        matrix[startRow][startCol] = "-";
                        break;
                    }
                    if (matrix[nextRow][nextCol].equals("-")) {
                        matrix[nextRow][nextCol] = "S";
                        matrix[startRow][startCol] = "-";
                        startRow = nextRow;
                    } else if (matrix[nextRow][nextCol].equals("P")) {
                        int pillarsFound = 0;
                        int teleportRow = -1;
                        int teleportCol = -1;
                        boolean pilarFound = false;
                        for (int i = 0; i < size; i++) {
                            if (pilarFound) {
                                break;
                            }
                            for (int j = 0; j < size; j++) {
                                if (matrix[i][j].equals("P")) {
                                    if (pillarsFound == 0) {
                                        pillarsFound++;
                                    } else if (pillarsFound == 1) {
                                        teleportRow = i;
                                        teleportCol = j;
                                        pilarFound = true;
                                    }
                                }
                            }
                        }
                        matrix[nextRow][nextCol] = "-";
                        matrix[startRow][startCol] = "-";
                        matrix[teleportRow][teleportCol] = "S";
                        startRow = teleportRow;
                        startCol = teleportCol;
                    } else {
                        int coin = Integer.parseInt(matrix[nextRow][nextCol]);
                        collectedMoney += coin;
                        matrix[nextRow][nextCol] = "S";
                        matrix[startRow][startCol] = "-";
                        startRow = nextRow;
                    }
                    break;
                case "left":
                    nextRow = startRow;
                    nextCol = startCol - 1;
                    if (nextCol < 0) {
                        isOut = true;
                        matrix[startRow][startCol] = "-";
                        break;
                    }
                    if (matrix[nextRow][nextCol].equals("-")) {
                        matrix[nextRow][nextCol] = "S";
                        matrix[startRow][startCol] = "-";
                        startCol = nextCol;
                    } else if (matrix[nextRow][nextCol].equals("P")) {
                        int pillarsFound = 0;
                        int teleportRow = -1;
                        int teleportCol = -1;
                        boolean pilarFound = false;
                        for (int i = 0; i < size; i++) {
                            if (pilarFound) {
                                break;
                            }
                            for (int j = 0; j < size; j++) {
                                if (matrix[i][j].equals("P")) {
                                    if (pillarsFound == 0) {
                                        pillarsFound++;
                                    } else if (pillarsFound == 1) {
                                        teleportRow = i;
                                        teleportCol = j;
                                        pilarFound = true;
                                    }
                                }
                            }
                        }
                        matrix[nextRow][nextCol] = "-";
                        matrix[startRow][startCol] = "-";
                        matrix[teleportRow][teleportCol] = "S";
                        startRow = teleportRow;
                        startCol = teleportCol;
                    } else {
                        int coin = Integer.parseInt(matrix[nextRow][nextCol]);
                        collectedMoney += coin;
                        matrix[nextRow][nextCol] = "S";
                        matrix[startRow][startCol] = "-";
                        startCol = nextCol;
                    }
                    break;
                case "right":
                    nextRow = startRow;
                    nextCol = startCol + 1;
                    if (nextCol >= matrix.length) {
                        isOut = true;
                        matrix[startRow][startCol] = "-";
                        break;
                    }
                    if (matrix[nextRow][nextCol].equals("-")) {
                        matrix[nextRow][nextCol] = "S";
                        matrix[startRow][startCol] = "-";
                        startCol = nextCol;
                    } else if (matrix[nextRow][nextCol].equals("P")) {
                        int pillarsFound = 0;
                        int teleportRow = -1;
                        int teleportCol = -1;
                        boolean pilarFound = false;
                        for (int i = 0; i < size; i++) {
                            if (pilarFound) {
                                break;
                            }
                            for (int j = 0; j < size; j++) {
                                if (matrix[i][j].equals("P")) {
                                    if (pillarsFound == 0) {
                                        pillarsFound++;
                                    } else if (pillarsFound == 1) {
                                        teleportRow = i;
                                        teleportCol = j;
                                        pilarFound = true;
                                    }
                                }
                            }
                        }
                        matrix[nextRow][nextCol] = "-";
                        matrix[startRow][startCol] = "-";
                        matrix[teleportRow][teleportCol] = "S";
                        startRow = teleportRow;
                        startCol = teleportCol;
                    } else {
                        int coin = Integer.parseInt(matrix[nextRow][nextCol]);
                        collectedMoney += coin;
                        matrix[nextRow][nextCol] = "S";
                        matrix[startRow][startCol] = "-";
                        startCol = nextCol;
                    }
                    break;
            }
            if (collectedMoney >= 50) {
                enoughMoney = true;
            }
        }
        System.out.println("Money: " + collectedMoney);
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
