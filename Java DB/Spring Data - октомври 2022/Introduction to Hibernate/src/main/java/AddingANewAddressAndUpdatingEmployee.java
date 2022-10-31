import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class AddingANewAddressAndUpdatingEmployee {

    private static final String DATABASE_NAME = "soft_uni";

    private static final String ADDRESS_TEXT = "Vitoshka 15";

    private static final String ENTER_NAME_OUTPUT = "Enter last name: ";

    private static final String UPDATE_EMPLOYEE_ADDRESS = "UPDATE Employee e SET e.address = :address WHERE e.lastName = :last_name";

    public static void main(String[] args) {

        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(DATABASE_NAME);

        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        System.out.print(ENTER_NAME_OUTPUT);

        final String lastNameInput = new Scanner(System.in).nextLine();

        entityManager.getTransaction().begin();

        final Address address = new Address();

        address.setText(ADDRESS_TEXT);

        entityManager.persist(address);

        entityManager.createQuery(UPDATE_EMPLOYEE_ADDRESS).
                setParameter("address", address).
                setParameter("last_name", lastNameInput).
                executeUpdate();

        entityManager.getTransaction().commit();

        entityManager.close();

    }

}
