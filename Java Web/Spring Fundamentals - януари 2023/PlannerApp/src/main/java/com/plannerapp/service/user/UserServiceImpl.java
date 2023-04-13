package com.plannerapp.service.user;

import com.plannerapp.model.dto.RegisterDTO;
import com.plannerapp.model.entity.UserEntity;
import com.plannerapp.repo.UserRepository;
import com.plannerapp.util.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private final LoggedUser loggedUser;

    private final PasswordEncoder passwordEncoder;

    private final HttpSession httpSession;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, LoggedUser loggedUser, PasswordEncoder passwordEncoder, HttpSession httpSession) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.passwordEncoder = passwordEncoder;
        this.httpSession = httpSession;
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void register(RegisterDTO registerDTO) {
        UserEntity user = new UserEntity();

        this.modelMapper.map(registerDTO, user);

        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        this.userRepository.save(user);

        login(registerDTO.getUsername());
    }

    @Override
    public void login(String username) {
        UserEntity user = this.userRepository.findByUsername(username);

        this.loggedUser.setId(user.getId());

        this.loggedUser.setUsername(user.getUsername());
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
    public void logout() {
        this.httpSession.invalidate();

        this.loggedUser.setId(null);

        this.loggedUser.setUsername(null);
    }
}
