package JavaAdvancedRetakeExam16December2020.Bakery03;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.employees.size() < capacity) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        Employee employeeToRemove = this.employees.stream().filter(employee -> employee.getName().equals(name)).findFirst().orElse(null);
        if (employeeToRemove != null) {
            employees.remove(employeeToRemove);
            return true;
        }
        return false;
    }

    public Employee getOldestEmployee() {
        Employee oldestEmployee = null;
        int oldest = Integer.MIN_VALUE;
        for (Employee employee : this.employees) {
            if (employee.getAge() > oldest) {
                oldest = employee.getAge();
            }
        }
        int finalOldest = oldest;
        oldestEmployee = this.employees.stream().filter(car -> car.getAge() == finalOldest).findFirst().orElse(null);
        return oldestEmployee;
    }

    public Employee getEmployee(String name) {
        return this.employees.stream().filter(car -> car.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Bakery ").append(getName()).append(":").append(System.lineSeparator());
        for (Employee employee : this.employees) {
            sb.append(employee).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
