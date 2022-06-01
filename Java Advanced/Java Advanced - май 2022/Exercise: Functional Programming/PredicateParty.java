import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> listOfPeople = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        List <String> temp = new ArrayList<>();

        String command;
        while (!"Party!".equals(command = scanner.nextLine())) {
            String[] token = command.split("\\s+");

            Predicate<String> filterCriteria = criteria(token);
            if("Remove".equals(token[0])) listOfPeople.removeIf(filterCriteria);
            else {
                listOfPeople.stream().filter(filterCriteria).forEach(temp::add);
                listOfPeople.addAll(temp);
                temp.clear();
            }
        }
        Collections.sort(listOfPeople);

        Consumer<List<String>> printer = list -> {
            if(list.isEmpty()) {
                System.out.println("Nobody is going to the party!");
            } else {
                System.out.println(String.join(", ", list) + " are going to the party!");
            }
        };
        printer.accept(listOfPeople);
    }

    private static Predicate<String> criteria(String[] token) {
        switch (token[1]) {
            case "StartsWith":
                String startLetters = token[2];
                return s -> s.startsWith(startLetters);
            case "EndsWith":
                String endLetters = token[2];
                return s -> s.endsWith(endLetters);
            case "Length":
                int length = Integer.parseInt(token[2]);
                return s -> s.length()==length;
            default:
                throw new IllegalStateException("Unexpected value: " + token[1]);
        }
    }
}
