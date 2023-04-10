package com.likebookapp.service.user;

import com.likebookapp.model.dto.RegisterDTO;
import com.likebookapp.model.entity.UserEntity;

public interface UserService {
    boolean checkCredentials(String username, String password);

    void login(String username);

    void logout();

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);

    void register(RegisterDTO registerDTO);
}
