package bg.softuni.exercise_springdataautomappingobjects.services.game;

public interface GameService {

    String addGame(String[] args);

    String editGame(String[] args);

    String deleteGame(Long id);

}
