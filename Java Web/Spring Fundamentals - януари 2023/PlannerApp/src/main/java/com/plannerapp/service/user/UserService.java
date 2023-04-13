package com.plannerapp.service.user;

import com.plannerapp.model.dto.RegisterDTO;
import com.plannerapp.model.entity.TaskEntity;
import com.plannerapp.model.entity.UserEntity;

import java.util.Set;

public interface UserService {
    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);

    void register(RegisterDTO registerDTO);

    void login(String username);

    boolean checkCredentials(String username, String password);

    void logout();
}
