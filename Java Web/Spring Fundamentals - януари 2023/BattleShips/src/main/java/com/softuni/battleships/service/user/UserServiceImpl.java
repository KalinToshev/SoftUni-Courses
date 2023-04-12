package com.softuni.battleships.service.user;

import com.softuni.battleships.model.dto.RegisterDTO;
import com.softuni.battleships.model.entity.UserEntity;
import com.softuni.battleships.repository.UserRepository;
import com.softuni.battleships.util.LoggedUser;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    private final LoggedUser loggedUser;

    private final HttpSession httpSession;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, LoggedUser loggedUser, HttpSession httpSession) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
        this.httpSession = httpSession;
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void logout() {
        this.httpSession.invalidate();
        this.loggedUser.setId(null);
        this.loggedUser.setUsername(null);
    }

    @Override
    public void register(RegisterDTO registerUserDTO) {
        UserEntity user = new UserEntity();

        this.modelMapper.map(registerUserDTO, user);

        user.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));

        this.userRepository.save(user);

        login(registerUserDTO.getUsername());
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
    public void login(String username) {
        UserEntity user = this.userRepository.findByUsername(username);

        this.loggedUser.setId(user.getId());

        this.loggedUser.setUsername(user.getUsername());
    }
}
