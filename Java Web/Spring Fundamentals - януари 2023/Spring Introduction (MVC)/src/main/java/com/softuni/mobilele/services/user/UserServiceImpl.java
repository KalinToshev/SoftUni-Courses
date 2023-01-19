package com.softuni.mobilele.services.user;

import com.softuni.mobilele.domain.entities.User;
import com.softuni.mobilele.domain.entities.UserRole;
import com.softuni.mobilele.domain.enums.Role;
import com.softuni.mobilele.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
