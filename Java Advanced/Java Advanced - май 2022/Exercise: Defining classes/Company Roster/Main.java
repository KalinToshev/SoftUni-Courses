import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Employee>> departments = new HashMap<>();

        int inputLines = Integer.parseInt(scanner.nextLine());
        while (inputLines-- > 0) {
            String[] employeeInformation = scanner.nextLine().split("\\s+");
            String name = employeeInformation[0];
            double salary = Double.parseDouble(employeeInformation[1]);
            String position = employeeInformation[2];
            String department = employeeInformation[3];

            Employee employee = null;

            if (employeeInformation.length == 6) {
                String email = employeeInformation[4];
                int age = Integer.parseInt(employeeInformation[5]);

                employee = new Employee(name, salary, position, department, email, age);
            } else if (employeeInformation.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (employeeInformation.length == 5) {
                String email;
                int age;
                String forthParameter = employeeInformation[4];
                if (forthParameter.contains("@")) {
                    email  = forthParameter;
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    age = Integer.parseInt(forthParameter);
                    employee = new Employee(name, salary, position, department, age);
                }
            }

            if (!departments.containsKey(department)) {
                departments.put(department, new ArrayList<>());
                departments.get(department).add(employee);
            } else {
                departments.get(department).add(employee);
            }
        }
        String maxAverageSalaryDepartment = departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(value -> getAverageSalary(value.getValue())))
                .get()
                .getKey();

        System.out.printf("Highest Average Salary: %s%n", maxAverageSalaryDepartment);

        List<Employee> employeeList = departments.get(maxAverageSalaryDepartment);

        employeeList.sort(Comparator.comparingDouble(value -> value.getSalary()));
        Collections.reverse(employeeList);

        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }
    public static double getAverageSalary(List<Employee> employees) {
        double sum = 0.0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum / employees.size();
    }
}
