package com.softuni.shoppinglist.service.user;

import com.softuni.shoppinglist.model.dto.RegisterUserDTO;
import com.softuni.shoppinglist.model.entity.UserEntity;

public interface UserService {
    void register(RegisterUserDTO registerUserDTO);

    void login(String username);

    void logout();

    boolean checkCredentials(String username, String password);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
