import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GetEmployeeWithProject {

    private static final String DATABASE_NAME = "soft_uni";

    private static final String GET_EMPLOYEE_BY_ID = "SELECT e FROM Employee e WHERE e.id = :empIdInput";

    public static void main(String[] args) {

        final EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory(DATABASE_NAME);

        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        final int employeeId = new Scanner(System.in).nextInt();

        entityManager.createQuery(GET_EMPLOYEE_BY_ID, Employee.class)
                .setParameter("empIdInput", employeeId)
                .getResultList()
                .forEach(employee ->
                        System.out.printf(
                                employee.getFirstName() + " " + employee.getLastName() + " - " + employee.getJobTitle()
                                        + "%n   " +
                                employee.getProjects().stream().map(Project::getName).sorted().collect(Collectors.joining("%n   "))));

        entityManager.close();

    }

}
