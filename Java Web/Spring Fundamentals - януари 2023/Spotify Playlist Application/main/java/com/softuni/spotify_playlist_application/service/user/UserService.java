package com.softuni.spotify_playlist_application.service.user;

import com.softuni.spotify_playlist_application.model.dtos.RegisterDTO;
import com.softuni.spotify_playlist_application.model.dtos.UserDTO;
import com.softuni.spotify_playlist_application.model.entity.Song;

public interface UserService {
    void logout();

    UserDTO findUserByUsername(String username);

    UserDTO findUserByEmail(String email);

    void register(RegisterDTO registerDTO);

    void login(String username);

    boolean checkCredentials(String username, String password);

    void deleteAllSongs(Long userId);

    void removeSongFromUser(Long userId, Long songId);

    void addSongToUser(Long userId, Song song);
}
