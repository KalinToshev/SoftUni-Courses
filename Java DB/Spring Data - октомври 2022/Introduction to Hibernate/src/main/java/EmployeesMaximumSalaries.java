import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeesMaximumSalaries {

    private static final String DATABASE_NAME = "soft_uni";

    private static final String GET_SALARIES_FOR_EACH_DEPARTMENT_WITH_MAX_SALARY = "SELECT d.name, MAX(e.salary) FROM Department d JOIN Employee e ON e.department.id = d.id GROUP BY d.id HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000";

    public static void main(String[] args) {

        final EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory(DATABASE_NAME);

        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.createQuery(GET_SALARIES_FOR_EACH_DEPARTMENT_WITH_MAX_SALARY, Object[].class)
                .getResultList()
                .forEach(o -> System.out.println(o[0] + " " + o[1]));

        entityManager.close();

    }

}
