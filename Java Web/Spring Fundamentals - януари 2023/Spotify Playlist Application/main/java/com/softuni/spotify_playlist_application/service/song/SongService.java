package com.softuni.spotify_playlist_application.service.song;

import com.softuni.spotify_playlist_application.model.dtos.AddSongDTO;
import com.softuni.spotify_playlist_application.model.dtos.SongDTO;
import com.softuni.spotify_playlist_application.model.entity.Song;
import com.softuni.spotify_playlist_application.model.entity.Style;

import java.util.Set;

public interface SongService {
    SongDTO findSongByPerformer(String performer);

    void addSong(AddSongDTO addSongDTO);

    Song findSongById(Long id);

    Set<SongDTO> findSongsByStyle(Style style);

    Set<SongDTO> getPlaylist(Long id);
}
