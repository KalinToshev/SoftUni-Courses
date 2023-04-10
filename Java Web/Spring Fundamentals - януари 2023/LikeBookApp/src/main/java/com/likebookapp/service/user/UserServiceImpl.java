package com.likebookapp.service.user;

import com.likebookapp.model.dto.RegisterDTO;
import com.likebookapp.model.entity.PostEntity;
import com.likebookapp.model.entity.UserEntity;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.service.post.PostService;
import com.likebookapp.util.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

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

    @Override
    public void logout() {
        this.httpSession.invalidate();

        this.loggedUser.setId(null);

        this.loggedUser.setUsername(null);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void register(RegisterDTO registerDTO) {
        UserEntity user = new UserEntity();

        this.modelMapper.map(registerDTO, user);

        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        this.userRepository.save(user);

        login(registerDTO.getUsername());
    }
}
