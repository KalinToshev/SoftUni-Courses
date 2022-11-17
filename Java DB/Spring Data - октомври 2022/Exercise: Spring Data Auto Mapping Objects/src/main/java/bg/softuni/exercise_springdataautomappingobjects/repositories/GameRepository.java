package bg.softuni.exercise_springdataautomappingobjects.repositories;

import bg.softuni.exercise_springdataautomappingobjects.domain.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    Game findFirstByTitle(String title);

}
