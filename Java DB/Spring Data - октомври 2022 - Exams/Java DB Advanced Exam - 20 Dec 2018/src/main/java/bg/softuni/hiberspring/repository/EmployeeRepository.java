package bg.softuni.hiberspring.repository;

import bg.softuni.hiberspring.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("select e from Employee e where e.card.number = ?1")
    Optional<Employee> findEmployeeByCard(String cardNumber);

    @Query(value = "SELECT" +
            " CONCAT(e.first_name, ' ' ,e.last_name) AS `full_name`," +
            " e.position," +
            " ec.number" +
            " FROM employees AS e" +
            "    JOIN employees_cards ec on ec.id = e.card_id" +
            "    JOIN branches b on b.id = e.branch_id" +
            "    JOIN products p on b.id = p.branch_id" +
            " ORDER BY `full_name`," +
            "         LENGTH(e.position) DESC", nativeQuery = true)
    List<Employee> employees();
}
