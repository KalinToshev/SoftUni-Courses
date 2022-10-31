import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeesFromDepartment {

    private static final String DATABASE_NAME = "soft_uni";

    private static final String DEPARTMENT_NAME = "Research and Development";

    private static final String PRINT_EMPLOYEE_FORMAT = "%s %s from %s - $%.2f%n";

    private static final String GET_ALL_EMPLOYEES_FROM_GIVEN_DEPARTMENT = "SELECT e FROM Employee e WHERE e.department.name = :dn ORDER BY e.salary ASC, e.id ASC";

    public static void main(String[] args) {

        final EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory(DATABASE_NAME);

        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.createQuery(GET_ALL_EMPLOYEES_FROM_GIVEN_DEPARTMENT, Employee.class)
                .setParameter("dn", DEPARTMENT_NAME)
                .getResultList()
                .forEach(employee -> System.out.printf(PRINT_EMPLOYEE_FORMAT,
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getDepartment().getName(),
                        employee.getSalary()));

        entityManager.close();

    }

}
