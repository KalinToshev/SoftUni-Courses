package com.example.demoprojectwithjpabuddyplugin.init;

import com.example.demoprojectwithjpabuddyplugin.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class First3UsersInit implements CommandLineRunner {
    private final UserService userService;

    @Autowired
    public First3UsersInit(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        userService.initUsers();
    }
}
