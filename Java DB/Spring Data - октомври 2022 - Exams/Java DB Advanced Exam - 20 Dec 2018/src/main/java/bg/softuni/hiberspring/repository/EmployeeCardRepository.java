package bg.softuni.hiberspring.repository;

import bg.softuni.hiberspring.domain.entities.EmployeeCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface EmployeeCardRepository extends JpaRepository<EmployeeCard, Integer> {
    Optional<EmployeeCard> findByNumber(String number);
}
