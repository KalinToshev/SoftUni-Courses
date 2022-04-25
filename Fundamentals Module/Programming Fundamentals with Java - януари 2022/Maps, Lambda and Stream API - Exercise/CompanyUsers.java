package bg.softuni.MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companyAndEmployees = new LinkedHashMap<>();


        while (true) {
            String[] companyAndEmployee = scanner.nextLine().split(" -> ");
            String companyName = companyAndEmployee[0];
            if (companyName.equals("End")) {
                break;
            }
            String employeeId = companyAndEmployee[1];
            if (employeeId.equals("End")) {
                break;
            }

            if (!companyAndEmployees.containsKey(companyName)) {
                companyAndEmployees.put(companyName, new ArrayList<>());
                companyAndEmployees.get(companyName).add(employeeId);
            } else {
                if (companyAndEmployees.get(companyName).contains(employeeId)) {
                    continue;
                } else {
                    companyAndEmployees.get(companyName).add(employeeId);
                }
            }

            companyName = "";
            employeeId = "";
        }

        for (Map.Entry<String, List<String>> entry : companyAndEmployees.entrySet()) {
            System.out.printf("%s%n", entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("-- %s%n", entry.getValue().get(i));
            }
        }

    }
}
