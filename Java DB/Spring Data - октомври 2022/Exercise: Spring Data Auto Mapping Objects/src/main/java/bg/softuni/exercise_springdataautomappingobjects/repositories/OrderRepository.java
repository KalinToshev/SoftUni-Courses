package bg.softuni.exercise_springdataautomappingobjects.repositories;

import bg.softuni.exercise_springdataautomappingobjects.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
