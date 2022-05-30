import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> logInfo = new TreeMap<>();

        String line;
        fillTheMap(scanner, logInfo);

        output(logInfo);
    }

    private static void fillTheMap(Scanner scanner, Map<String, Map<String, Integer>> logInfo) {
        String line;
        while (!"end".equals(line = scanner.nextLine())) {
            String[] tokens = line.split(" ");
            String IP = tokens[0].split("=")[1];
            String user = tokens[2].split("=")[1];

            logInfo.putIfAbsent(user, new LinkedHashMap<>());
            logInfo.get(user).putIfAbsent(IP, 0);
            logInfo.get(user).put(IP, logInfo.get(user).get(IP) + 1);
        }
    }

    private static void output(Map<String, Map<String, Integer>> logInfo) {
        for (var log : logInfo.entrySet()) {
            System.out.println(log.getKey() + ":");
            int counter = 0;
            for (var iternalLog : log.getValue().entrySet()) {
                counter++;
                System.out.printf("%s => %d", iternalLog.getKey(), iternalLog.getValue());
                if (counter == log.getValue().size()) {
                    System.out.println(".");
                } else {
                    System.out.print(", ");
                }
            }
        }
    }
}
