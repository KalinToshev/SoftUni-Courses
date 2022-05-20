import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> oldCommands = new ArrayDeque<>();
        ArrayDeque<String> removedElements = new ArrayDeque<>();

        int numberOfOperations = Integer.parseInt(scanner.nextLine());

        StringBuilder text = new StringBuilder();

        for (int i = 0; i < numberOfOperations; i++) {
            String rawCommand = scanner.nextLine();
            String[] commandArguments = rawCommand.split("\\s+");
            String commandType = commandArguments[0];
            switch (commandType) {
                case "1":
                    oldCommands.push(rawCommand);
                    executeAdd(commandArguments[1], text);
                    break;
                case "2":
                    oldCommands.push(rawCommand);
                    int countToDelete = Integer.parseInt(commandArguments[1]);
                    //
                    StringBuilder elementsToBeDeleted = new StringBuilder();
                    for (int j = text.length() - countToDelete; j < text.length(); j++) {
                        elementsToBeDeleted.append(text.charAt(j));
                    }
                    removedElements.push(elementsToBeDeleted.toString());
                    //
                    executeDelete(countToDelete, text);
                    break;
                case "3":
                    int index = Integer.parseInt(commandArguments[1]);
                    System.out.printf("%s%n", text.charAt(index - 1));
                    break;
                case "4":
                    String lastCommand = oldCommands.pop();
                    String[] lastCommandArguments = lastCommand.split("\\s+");
                    String lastCommandType = lastCommandArguments[0];
                    switch (lastCommandType) {
                        case "1":
                            int elementsToDelete = lastCommandArguments[1].length();
                            executeDelete(elementsToDelete, text);
                            break;
                        case "2":
                            String elementsToAddBack = removedElements.pop();
                            executeAdd(elementsToAddBack, text);
                            break;
                    }
                    break;
            }
        }
    }

    private static void executeDelete(int countToDelete, StringBuilder text) {
        for (int i = 1; i <= countToDelete; i++) {
            text.deleteCharAt(text.length() - 1);
        }
    }

    private static void executeAdd(String argument, StringBuilder text) {
        text.append(argument);
    }
}
