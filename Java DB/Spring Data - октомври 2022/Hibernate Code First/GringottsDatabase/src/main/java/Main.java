import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        WizardDeposits wizardDeposits = new WizardDeposits(
                "TestFirstName",
                "TestLastName",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                23,
                "TestMagicWandCreator",
                (short) 10,
                "TestDepositGroup",
                LocalDateTime.now(),
                2.5,
                2.5,
                2.5,
                LocalDateTime.now(),
                true
                );

        entityManager.persist(wizardDeposits);

        entityManager.getTransaction().commit();

        entityManager.close();

    }
}
