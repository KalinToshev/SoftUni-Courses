import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Product product = new Product("TestProduct", 2.26, BigDecimal.valueOf(150));

        Customer customer = new Customer("TestCustomerName", "testCustomerEmail", "TestCustomerCreditCardNumber");

        StoreLocation storeLocation = new StoreLocation("TestStoreLocationName");

        Sale sale = new Sale(product, customer, storeLocation);

        entityManager.persist(product);

        entityManager.persist(customer);

        entityManager.persist(storeLocation);

        entityManager.persist(sale);

        entityManager.getTransaction().commit();

        entityManager.close();

    }
}
