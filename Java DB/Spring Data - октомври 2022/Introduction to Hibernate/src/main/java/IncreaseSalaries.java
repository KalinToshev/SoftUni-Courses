import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class IncreaseSalaries {

    private static final String DATABASE_NAME = "soft_uni";

    private static final String UPDATE_EMPLOYEES_SALARIES_BY_DEPARTMENTS = "UPDATE Employee SET salary = salary * 1.12 WHERE department.id IN (1, 2, 4, 11)";

    private static final String GET_EMPLOYEES_BY_DEPARTMENT = "SELECT e FROM Employee e WHERE e.department.id IN (1, 2, 4, 11)";

    public static void main(String[] args) {

        final EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory(DATABASE_NAME);

        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.createQuery(UPDATE_EMPLOYEES_SALARIES_BY_DEPARTMENTS)
                .executeUpdate();

        entityManager.getTransaction().commit();

        entityManager.createQuery(GET_EMPLOYEES_BY_DEPARTMENT, Employee.class)
                .getResultList()
                        .forEach(employee -> System.out.printf("%s %s (%.2f)%n", employee.getFirstName(), employee.getLastName(), employee.getSalary()));

        entityManager.close();

    }

}
