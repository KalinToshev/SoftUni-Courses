package com.softuni.spotify_playlist_application.service.user;

import com.softuni.spotify_playlist_application.model.dtos.RegisterDTO;
import com.softuni.spotify_playlist_application.model.dtos.UserDTO;
import com.softuni.spotify_playlist_application.model.entity.Song;
import com.softuni.spotify_playlist_application.model.entity.User;
import com.softuni.spotify_playlist_application.repository.UserRepository;
import com.softuni.spotify_playlist_application.util.LoggedUser;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final LoggedUser loggedUser;

    private final HttpSession httpSession;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, LoggedUser loggedUser, HttpSession httpSession) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
        this.httpSession = httpSession;
    }

    @Override
    public void logout() {
        this.httpSession.invalidate();
        this.loggedUser.setId(null);
        this.loggedUser.setUsername(null);
    }

    public UserDTO findUserByUsername(String username) {
        User user = this.userRepository.findUserByUsername(username).orElse(null);
        if (user == null) {
            return null;
        }

        return new UserDTO().setId(user.getId())
                .setUsername(user.getUsername())
                .setEmail(user.getEmail());
    }

    public UserDTO findUserByEmail(String email) {
        User user = this.userRepository.findUserByEmail(email).orElse(null);
        if (user == null) {
            return null;
        }

        return new UserDTO().setId(user.getId())
                .setUsername(user.getUsername())
                .setEmail(user.getEmail());
    }

    @Override
    public void register(RegisterDTO registerDTO) {
        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        this.userRepository.save(user);

        login(registerDTO.getUsername());
    }

    public void login(String username) {
        User user = this.userRepository.findUserByUsername(username).orElse(null);
        this.loggedUser.setId(user.getId());
        this.loggedUser.setUsername(user.getUsername());
    }

    @Override
    public boolean checkCredentials(String username, String password) {
        User user = this.userRepository.findUserByUsername(username).orElse(null);

        if (user == null) {
            return false;
        }

        return passwordEncoder.matches(password, user.getPassword());
    }

    @Override
    public void deleteAllSongs(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow();

        user.deleteAllSongFromPlaylist();

        this.userRepository.save(user);
    }

    @Override
    public void removeSongFromUser(Long userId, Long songId) {
        User user = this.userRepository.findById(userId).orElseThrow();

        user.removeSongFromPlaylist(songId);

        this.userRepository.save(user);
    }

    @Override
    public void addSongToUser(Long userId, Song song) {
        User user = this.userRepository.findById(userId).orElseThrow();

        if (user.getPlaylist().stream().noneMatch(s -> s.getId().equals(song.getId()))) {
            user.addSongToPlaylist(song);

            this.userRepository.save(user);
        }
    }
}
