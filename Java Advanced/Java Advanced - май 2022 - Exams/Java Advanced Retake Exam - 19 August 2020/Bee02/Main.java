package JavaAdvancedRetakeExam19August2020.Bee02;

import java.util.Scanner;

public class Main {
    //Bee -> B
    //flowers -> f
    //bonus -> O
    //empty positions -> .
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startRow = -1;
        int startCol = -1;

        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];

        for (int i = 0; i < size; i++) {
            String[] line = scanner.nextLine().split("");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = line[j];
                if (line[j].equals("B")) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        boolean gotLost = false;
        boolean gameOver = false;
        int pollinatedFlowers = 0;
        while (true) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    int nextRow = startRow - 1;
                    int nextCol = startCol;
                    if (nextRow < 0) {
                        gotLost = true;
                        matrix[startRow][startCol] = ".";
                        break;
                    }
                    if (matrix[nextRow][nextCol].equals("f")) {
                        matrix[startRow][startCol] = ".";
                        matrix[nextRow][nextCol] = "B";
                        startRow = nextRow;
                        pollinatedFlowers++;
                    } else if (matrix[nextRow][nextCol].equals("O")) {
                        matrix[nextRow][nextCol] = ".";
                        matrix[startRow][startCol] = ".";
                        nextRow = startRow - 2;
                        if (matrix[nextRow][nextCol].equals("f")) {
                            pollinatedFlowers++;
                            matrix[nextRow][nextCol] = "B";
                        } else if (matrix[nextRow][nextCol].equals(".")) {
                            matrix[nextRow][nextCol] = "B";
                        }
                        startRow = nextRow;
                    } else if (matrix[nextRow][nextCol].equals(".")) {
                        matrix[nextRow][nextCol] = "B";
                        matrix[startRow][startCol] = ".";
                        startRow = nextRow;
                    }
                    break;
                case "down":
                    nextRow = startRow + 1;
                    nextCol = startCol;
                    if (nextRow >= matrix.length) {
                        gotLost = true;
                        matrix[startRow][startCol] = ".";
                        break;
                    }
                    if (matrix[nextRow][nextCol].equals("f")) {
                        matrix[startRow][startCol] = ".";
                        matrix[nextRow][nextCol] = "B";
                        startRow = nextRow;
                        pollinatedFlowers++;
                    } else if (matrix[nextRow][nextCol].equals("O")) {
                        matrix[nextRow][nextCol] = ".";
                        matrix[startRow][startCol] = ".";
                        nextRow = startRow + 2;
                        if (matrix[nextRow][nextCol].equals("f")) {
                            pollinatedFlowers++;
                            matrix[nextRow][nextCol] = "B";
                        } else if (matrix[nextRow][nextCol].equals(".")) {
                            matrix[nextRow][nextCol] = "B";
                        }
                        startRow = nextRow;
                    } else if (matrix[nextRow][nextCol].equals(".")) {
                        matrix[nextRow][nextCol] = "B";
                        matrix[startRow][startCol] = ".";
                        startRow = nextRow;
                    }
                    break;
                case "left":
                    nextRow = startRow;
                    nextCol = startCol - 1;
                    if (nextCol < 0) {
                        gotLost = true;
                        matrix[startRow][startCol] = ".";
                        break;
                    }
                    if (matrix[nextRow][nextCol].equals("f")) {
                        matrix[startRow][startCol] = ".";
                        matrix[nextRow][nextCol] = "B";
                        startCol = nextCol;
                        pollinatedFlowers++;
                    } else if (matrix[nextRow][nextCol].equals("O")) {
                        matrix[nextRow][nextCol] = ".";
                        matrix[startRow][startCol] = ".";
                        nextCol = startCol - 2;
                        if (matrix[nextRow][nextCol].equals("f")) {
                            pollinatedFlowers++;
                            matrix[nextRow][nextCol] = "B";
                        } else if (matrix[nextRow][nextCol].equals(".")) {
                            matrix[nextRow][nextCol] = "B";
                        }
                        startCol = nextCol;
                    } else if (matrix[nextRow][nextCol].equals(".")) {
                        matrix[nextRow][nextCol] = "B";
                        matrix[startRow][startCol] = ".";
                        startCol = nextCol;
                    }
                    break;
                    case "right":
                        nextRow = startRow;
                        nextCol = startCol + 1;
                        if (nextCol >= matrix.length) {
                            gotLost = true;
                            matrix[startRow][startCol] = ".";
                            break;
                        }
                        if (matrix[nextRow][nextCol].equals("f")) {
                            matrix[startRow][startCol] = ".";
                            matrix[nextRow][nextCol] = "B";
                            startCol = nextCol;
                            pollinatedFlowers++;
                        } else if (matrix[nextRow][nextCol].equals("O")) {
                            matrix[nextRow][nextCol] = ".";
                            matrix[startRow][startCol] = ".";
                            nextCol = startCol + 2;
                            if (matrix[nextRow][nextCol].equals("f")) {
                                pollinatedFlowers++;
                                matrix[nextRow][nextCol] = "B";
                            } else if (matrix[nextRow][nextCol].equals(".")) {
                                matrix[nextRow][nextCol] = "B";
                            }
                            startCol = nextCol;
                        } else if (matrix[nextRow][nextCol].equals(".")) {
                            matrix[nextRow][nextCol] = "B";
                            matrix[startRow][startCol] = ".";
                            startCol = nextCol;
                        }
                        break;
                case "End":
                    gameOver = true;
                    break;
            }
            if (gameOver) {
                break;
            }
            if (gotLost) {
                System.out.println("The bee got lost!");
                break;
            }
        }

        if (pollinatedFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        }
         if (pollinatedFlowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
