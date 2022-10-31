import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class ContainsEmployee {

    private static final String DATABASE_NAME = "soft_uni";

    private static final String GET_EMPLOYEE_WITH_GIVEN_NAME = "SELECT COUNT(e) FROM Employee e WHERE e.firstName = :fn AND e.lastName = :ln";

    public static void main(String[] args) {

        final EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory(DATABASE_NAME);

        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        System.out.print("Enter name: ");

        final String[] fullName = new Scanner(System.in).nextLine().split(" ");

        final String firstName = fullName[0];

        final String lastName = fullName[1];

        final Long countOfMatches = entityManager.createQuery(
                        GET_EMPLOYEE_WITH_GIVEN_NAME, Long.class)
                .setParameter("fn", firstName)
                .setParameter("ln", lastName)
                .getSingleResult();

        if (countOfMatches == 0) System.out.println("No");
        else System.out.println("Yes");

    }

}
