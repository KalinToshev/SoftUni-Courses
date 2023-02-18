package com.softuni.spotify_playlist_application.service.home;

import com.softuni.spotify_playlist_application.model.dtos.SongDTO;
import com.softuni.spotify_playlist_application.model.dtos.SongsByGenreDTO;
import com.softuni.spotify_playlist_application.model.entity.Style;

import java.util.Set;

public interface HomeService {
    void deleteAll(Long userId);

    void removeSong(Long songId, Long userId);

    void addSong(Long songId, Long userId);

    Set<SongDTO> getSongsByGenre(Style style);

    SongsByGenreDTO getSongs();
}
