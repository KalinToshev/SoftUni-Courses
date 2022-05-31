import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> userDuration = new TreeMap<>();
        Map<String, Set<String>> userIPs = new HashMap<>();


        int logLines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < logLines; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String IP = data[0];
            String user = data[1];
            int duration = Integer.parseInt(data[2]);

            userDuration.putIfAbsent(user, 0);
            userDuration.put(user, userDuration.get(user) + duration);
            userIPs.putIfAbsent(user, new TreeSet<>());
            userIPs.get(user).add(IP);
        }

        for (var user : userDuration.entrySet()) {
            System.out.printf("%s: %d %s%n", user.getKey(), user.getValue(), userIPs.get(user.getKey()));
        }
    }
}
