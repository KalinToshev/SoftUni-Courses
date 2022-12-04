package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Mechanic;

import java.util.Optional;

@Repository
public interface MechanicRepository extends JpaRepository<Mechanic, Integer> {
    Optional<Mechanic> findByFirstName(String name);

    Optional<Mechanic> findByEmail(String email);

    Optional<Mechanic> findByPhone(String number);
}
