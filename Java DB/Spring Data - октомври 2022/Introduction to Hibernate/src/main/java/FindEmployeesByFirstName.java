import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class FindEmployeesByFirstName {

    private static final String DATABASE_NAME = "soft_uni";

    private static final String GET_EMPLOYEES_WITH_STARTING_PATTERN = "SELECT e FROM Employee e WHERE e.firstName LIKE :pattern";

    public static void main(String[] args) {

        final EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory(DATABASE_NAME);

        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        System.out.print("Enter pattern: ");

        String inputPattern = new Scanner(System.in).nextLine();

        entityManager.createQuery(GET_EMPLOYEES_WITH_STARTING_PATTERN, Employee.class)
                .setParameter("pattern", inputPattern + "%")
                .getResultList()
                .forEach(employee -> System.out.printf("%s %s - %s - ($%.2f)%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle(), employee.getSalary()));

        entityManager.close();

    }

}
