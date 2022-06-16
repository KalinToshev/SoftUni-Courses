package JavaAdvancedRetakeExam13April2022.Armory02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //create matrix
        int rowsAndCols = Integer.parseInt(scanner.nextLine());
        String[][] armory = new String[rowsAndCols][rowsAndCols];

        //fill matrix
        for (int i = 0; i < rowsAndCols; i++) {
            //Army officer -> A
            //swords -> single digit
            //mirrors -> M [minCount: 0;maxCount: 2]
            //empty positions -> -
            String[] tokens = scanner.nextLine().split("");
            for (int j = 0; j < rowsAndCols; j++) {
                armory[i][j] = tokens[j];
            }
        }

        //The program ends when the army officer buys blades for at least 65 gold coins,
        //or you guide him out of the armory.
        //move commands: up, down, left, right
        int goldCoins = 0;
        boolean isLeft = false;
        boolean enoughMoney = false;
        while(goldCoins < 65) {
            if (isLeft) {
                break;
            }
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    //find officer and save him position
                    int currentRowPosition = 0;
                    int currentColumnPosition = 0;
                    boolean isFound = false;
                    for (int i = 0; i < rowsAndCols; i++) {
                        if (isFound) {
                            break;
                        }
                        for (int j = 0; j < rowsAndCols; j++) {
                            if (armory[i][j].equals("A")) {
                                currentRowPosition = i;
                                currentColumnPosition = j;
                                isFound = true;
                                break;
                            }
                        }
                    }
                    //move officer
                    //when the command is up we only reduce the row number
                    int nextRowPosition = currentRowPosition - 1;
                    int nextColumnPosition = currentColumnPosition;
                    if (nextRowPosition < 0) {
                        armory[currentRowPosition][currentColumnPosition] = "-";
                        System.out.println("I do not need more swords!");
                        isLeft = true;
                    } else {
                        if (armory[nextRowPosition][nextColumnPosition].equals("-")) {
                            armory[currentRowPosition][currentColumnPosition] = "-";
                            armory[nextRowPosition][nextColumnPosition] = "A";
                        } else if (!armory[nextRowPosition][nextColumnPosition].equals("M") && !armory[nextRowPosition][nextColumnPosition].equals("-")) {
                            //we have digit
                            int coins = Integer.parseInt(armory[nextRowPosition][nextColumnPosition]);
                            goldCoins += coins;
                            armory[currentRowPosition][currentColumnPosition] = "-";
                            armory[nextRowPosition][nextColumnPosition] = "A";
                        } else if (armory[nextRowPosition][nextColumnPosition].equals("M")) {
                            //there the officer is step on mirror and have to be
                            //teleported to the next found mirror
                            int nextMPositionRow = 0;
                            int nextMPositionColumn = 0;
                            boolean mFound = false;
                            for (int i = 0; i < rowsAndCols; i++) {
                                if (mFound) {
                                    break;
                                }
                                for (int j = 0; j < rowsAndCols; j++) {
                                    if (armory[i][j].equals("M") && i != nextRowPosition && j != nextColumnPosition) {
                                        nextMPositionRow = i;
                                        nextMPositionColumn = j;
                                        mFound = true;
                                        break;
                                    }
                                }
                            }
                            armory[nextRowPosition][nextColumnPosition] = "-";
                            armory[currentRowPosition][currentColumnPosition] = "-";
                            armory[nextMPositionRow][nextMPositionColumn] = "A";
                        }
                    }
                    break;
                case "down":
                    //find officer and save him position
                    currentRowPosition = 0;
                    currentColumnPosition = 0;
                    isFound = false;
                    for (int i = 0; i < rowsAndCols; i++) {
                        if (isFound) {
                            break;
                        }
                        for (int j = 0; j < rowsAndCols; j++) {
                            if (armory[i][j].equals("A")) {
                                currentRowPosition = i;
                                currentColumnPosition = j;
                                isFound = true;
                                break;
                            }
                        }
                    }
                    //move officer
                    //when the command is down we only increment the row number
                    nextRowPosition = currentRowPosition + 1;
                    nextColumnPosition = currentColumnPosition;
                    if (nextRowPosition >= armory.length) {
                        armory[currentRowPosition][currentColumnPosition] = "-";
                        System.out.println("I do not need more swords!");
                        isLeft = true;
                    } else {
                        if (armory[nextRowPosition][nextColumnPosition].equals("-")) {
                            armory[currentRowPosition][currentColumnPosition] = "-";
                            armory[nextRowPosition][nextColumnPosition] = "A";
                        } else if (!armory[nextRowPosition][nextColumnPosition].equals("M") && !armory[nextRowPosition][nextColumnPosition].equals("-")) {
                            //we have digit
                            int coins = Integer.parseInt(armory[nextRowPosition][nextColumnPosition]);
                            goldCoins += coins;
                            armory[currentRowPosition][currentColumnPosition] = "-";
                            armory[nextRowPosition][nextColumnPosition] = "A";
                        } else if (armory[nextRowPosition][nextColumnPosition].equals("M")) {
                            //there the officer is step on mirror and have to be
                            //teleported to the next found mirror
                            int nextMPositionRow = 0;
                            int nextMPositionColumn = 0;
                            boolean mFound = false;
                            for (int i = 0; i < rowsAndCols; i++) {
                                if (mFound) {
                                    break;
                                }
                                for (int j = 0; j < rowsAndCols; j++) {
                                    if (armory[i][j].equals("M") && i != nextRowPosition && j != nextColumnPosition) {
                                        nextMPositionRow = i;
                                        nextMPositionColumn = j;
                                        mFound = true;
                                        break;
                                    }
                                }
                            }
                            armory[nextRowPosition][nextColumnPosition] = "-";
                            armory[currentRowPosition][currentColumnPosition] = "-";
                            armory[nextMPositionRow][nextMPositionColumn] = "A";
                        }
                    }
                    break;
                case "left":
                    //find officer and save him position
                    currentRowPosition = 0;
                    currentColumnPosition = 0;
                    isFound = false;
                    for (int i = 0; i < rowsAndCols; i++) {
                        if (isFound) {
                            break;
                        }
                        for (int j = 0; j < rowsAndCols; j++) {
                            if (armory[i][j].equals("A")) {
                                currentRowPosition = i;
                                currentColumnPosition = j;
                                isFound = true;
                                break;
                            }
                        }
                    }
                    //move officer
                    //when the command is left we only reduce the column number
                    nextRowPosition = currentRowPosition;
                    nextColumnPosition = currentColumnPosition - 1;
                    if (nextColumnPosition < 0) {
                        armory[currentRowPosition][currentColumnPosition] = "-";
                        System.out.println("I do not need more swords!");
                        isLeft = true;
                    } else {
                        if (armory[nextRowPosition][nextColumnPosition].equals("-")) {
                            armory[currentRowPosition][currentColumnPosition] = "-";
                            armory[nextRowPosition][nextColumnPosition] = "A";
                        } else if (!armory[nextRowPosition][nextColumnPosition].equals("M") && !armory[nextRowPosition][nextColumnPosition].equals("-")) {
                            //we have digit
                            int coins = Integer.parseInt(armory[nextRowPosition][nextColumnPosition]);
                            goldCoins += coins;
                            armory[currentRowPosition][currentColumnPosition] = "-";
                            armory[nextRowPosition][nextColumnPosition] = "A";
                        } else if (armory[nextRowPosition][nextColumnPosition].equals("M")) {
                            //there the officer is step on mirror and have to be
                            //teleported to the next found mirror
                            int nextMPositionRow = 0;
                            int nextMPositionColumn = 0;
                            boolean mFound = false;
                            for (int i = 0; i < rowsAndCols; i++) {
                                if (mFound) {
                                    break;
                                }
                                for (int j = 0; j < rowsAndCols; j++) {
                                    if (armory[i][j].equals("M") && i != nextRowPosition && j != nextColumnPosition) {
                                        nextMPositionRow = i;
                                        nextMPositionColumn = j;
                                        mFound = true;
                                        break;
                                    }
                                }
                            }
                            armory[nextRowPosition][nextColumnPosition] = "-";
                            armory[currentRowPosition][currentColumnPosition] = "-";
                            armory[nextMPositionRow][nextMPositionColumn] = "A";
                        }
                    }
                    break;
                case "right":
                    //find officer and save him position
                    currentRowPosition = 0;
                    currentColumnPosition = 0;
                    isFound = false;
                    for (int i = 0; i < rowsAndCols; i++) {
                        if (isFound) {
                            break;
                        }
                        for (int j = 0; j < rowsAndCols; j++) {
                            if (armory[i][j].equals("A")) {
                                currentRowPosition = i;
                                currentColumnPosition = j;
                                isFound = true;
                                break;
                            }
                        }
                    }
                    //move officer
                    //when the command is right we only increment the column number
                    nextRowPosition = currentRowPosition;
                    nextColumnPosition = currentColumnPosition + 1;
                    if (nextColumnPosition >= armory.length) {
                        armory[currentRowPosition][currentColumnPosition] = "-";
                        System.out.println("I do not need more swords!");
                        isLeft = true;
                    } else {
                        if (armory[nextRowPosition][nextColumnPosition].equals("-")) {
                            armory[currentRowPosition][currentColumnPosition] = "-";
                            armory[nextRowPosition][nextColumnPosition] = "A";
                        } else if (!armory[nextRowPosition][nextColumnPosition].equals("M") && !armory[nextRowPosition][nextColumnPosition].equals("-")) {
                            //we have digit
                            int coins = Integer.parseInt(armory[nextRowPosition][nextColumnPosition]);
                            goldCoins += coins;
                            armory[currentRowPosition][currentColumnPosition] = "-";
                            armory[nextRowPosition][nextColumnPosition] = "A";
                        } else if (armory[nextRowPosition][nextColumnPosition].equals("M")) {
                            //there the officer is step on mirror and have to be
                            //teleported to the next found mirror
                            int nextMPositionRow = 0;
                            int nextMPositionColumn = 0;
                            boolean mFound = false;
                            for (int i = 0; i < rowsAndCols; i++) {
                                if (mFound) {
                                    break;
                                }
                                for (int j = 0; j < rowsAndCols; j++) {
                                    if (armory[i][j].equals("M") && i != nextRowPosition && j != nextColumnPosition) {
                                        nextMPositionRow = i;
                                        nextMPositionColumn = j;
                                        mFound = true;
                                        break;
                                    }
                                }
                            }
                            armory[nextRowPosition][nextColumnPosition] = "-";
                            armory[currentRowPosition][currentColumnPosition] = "-";
                            armory[nextMPositionRow][nextMPositionColumn] = "A";
                        }
                    }
                    break;
            }
            if (goldCoins >= 65) {
                enoughMoney = true;
            }
        }
        if (enoughMoney) {
            System.out.printf("Very nice swords, I will come back for more!%n");
        }
        System.out.printf("The king paid %d gold coins.%n", goldCoins);
        for (int i = 0; i < rowsAndCols; i++) {
            for (int j = 0; j < rowsAndCols; j++) {
                System.out.print(armory[i][j]);
            }
            System.out.println();
        }
    }
}
