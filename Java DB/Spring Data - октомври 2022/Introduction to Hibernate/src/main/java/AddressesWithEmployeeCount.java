import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddressesWithEmployeeCount {

    private static final String DATABASE_NAME = "soft_uni";

    private static final String GET_ADDRESSES_WITH_EMPLOYEE_COUNT = "SELECT a FROM Address a ORDER BY a.employees.size DESC";

    public static void main(String[] args) {

        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(DATABASE_NAME);

        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.createQuery(GET_ADDRESSES_WITH_EMPLOYEE_COUNT, Address.class)
                .setMaxResults(10)
                .getResultList()
                .forEach(System.out::println);

        entityManager.close();

    }

}
