package com.softuni.battleships.service.user;

import com.softuni.battleships.model.dto.RegisterDTO;
import com.softuni.battleships.model.entity.UserEntity;

public interface UserService {
    UserEntity findByUsername(String username);

    UserEntity findByEmail(String email);

    void logout();

    void register(RegisterDTO registerUserDTO);

    boolean checkCredentials(String username, String password);

    void login(String username);
}
