package com.example.demoprojectwithjpabuddyplugin.services.user;

import com.example.demoprojectwithjpabuddyplugin.model.entities.User;
import com.example.demoprojectwithjpabuddyplugin.model.enums.RoleType;
import com.example.demoprojectwithjpabuddyplugin.repositories.RoleRepository;
import com.example.demoprojectwithjpabuddyplugin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void initUsers() {
        if (userRepository.count() == 0) {
            User user1 = new User();
            user1
                    .setFirstName("Kalin")
                    .setLastName("Toshev")
                    .setUsername("Medunq6996")
                    .setPassword("22122004Kalin")
                    .setEmail("kalin.toshev84@gmail.com")
                    .setRoles(Set.of(roleRepository.findByRoleType(RoleType.USER).get(),
                            roleRepository.findByRoleType(RoleType.MODERATOR).get(),
                            roleRepository.findByRoleType(RoleType.ADMIN).get()));

            User user2 = new User();
            user2
                    .setFirstName("Mariela")
                    .setLastName("Nachkova")
                    .setUsername("MNachkova123")
                    .setPassword("MNachkova123")
                    .setEmail("mariela.nachkova@gmail.com")
                    .setRoles(Set.of(roleRepository.findByRoleType(RoleType.USER).get(),
                            roleRepository.findByRoleType(RoleType.MODERATOR).get()));

            User user3 = new User();
            user3
                    .setFirstName("Miroslav")
                    .setLastName("Toshev")
                    .setUsername("MToshev321")
                    .setPassword("MToshev321")
                    .setEmail("miroslav.toshev@gmail.com")
                    .setRoles(Set.of(roleRepository.findByRoleType(RoleType.USER).get()));

            this.userRepository.saveAndFlush(user1);
            this.userRepository.saveAndFlush(user2);
            this.userRepository.saveAndFlush(user3);
        }
    }
}
