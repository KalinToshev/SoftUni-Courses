package com.softuni.shoppinglist.service.user;

import com.softuni.shoppinglist.model.dto.RegisterUserDTO;
import com.softuni.shoppinglist.model.entity.UserEntity;
import com.softuni.shoppinglist.repository.UserRepository;
import com.softuni.shoppinglist.util.LoggedUser;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper;

    private final LoggedUser loggedUser;

    private final HttpSession httpSession;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper, LoggedUser loggedUser, HttpSession httpSession) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.httpSession = httpSession;
    }

    @Override
    public void register(RegisterUserDTO registerUserDTO) {
        UserEntity user = new UserEntity();

        this.modelMapper.map(registerUserDTO, user);

        user.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));

        this.userRepository.save(user);

        login(registerUserDTO.getUsername());
    }

    @Override
    public void login(String username) {
        UserEntity user = this.userRepository.findByUsername(username);

        this.loggedUser.setId(user.getId());

        this.loggedUser.setUsername(user.getUsername());
    }

    @Override
    public void logout() {
        this.httpSession.invalidate();

        this.loggedUser.setId(null);

        this.loggedUser.setUsername(null);
    }

    @Override
    public boolean checkCredentials(String username, String password) {
        UserEntity user = this.userRepository.findByUsername(username);

        if (user == null) {
            return false;
        }

        return this.passwordEncoder.matches(password, user.getPassword());
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }
}
