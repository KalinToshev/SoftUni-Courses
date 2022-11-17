package bg.softuni.exercise_springdataautomappingobjects.services.user;

import bg.softuni.exercise_springdataautomappingobjects.domain.entities.User;

public interface UserService {

    String registerUser(String[] args);

    String loginUser(String[] args);

    String logoutUser();

    User getLoggedInUser();

}