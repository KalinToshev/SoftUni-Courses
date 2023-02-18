package com.softuni.spotify_playlist_application.service.home;

import com.softuni.spotify_playlist_application.model.dtos.SongDTO;
import com.softuni.spotify_playlist_application.model.dtos.SongsByGenreDTO;
import com.softuni.spotify_playlist_application.model.entity.Song;
import com.softuni.spotify_playlist_application.model.entity.Style;
import com.softuni.spotify_playlist_application.model.enums.Styles;
import com.softuni.spotify_playlist_application.service.song.SongService;
import com.softuni.spotify_playlist_application.service.style.StyleService;
import com.softuni.spotify_playlist_application.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class HomeServiceImpl implements HomeService {
    private final UserService userService;

    private final SongService songService;

    private final StyleService styleService;

    @Autowired
    public HomeServiceImpl(UserService userService, SongService songService, StyleService styleService) {
        this.userService = userService;
        this.songService = songService;
        this.styleService = styleService;
    }

    @Override
    public void deleteAll(Long userId) {
        this.userService.deleteAllSongs(userId);
    }

    @Override
    public void removeSong(Long songId, Long userId) {
        this.userService.removeSongFromUser(userId, songId);
    }

    @Override
    public void addSong(Long songId, Long userId) {
        Song song = this.songService.findSongById(songId);

        this.userService.addSongToUser(userId, song);
    }

    @Override
    public Set<SongDTO> getSongsByGenre(Style style) {
        return this.songService.findSongsByStyle(style);
    }

    @Override
    public SongsByGenreDTO getSongs() {
        SongsByGenreDTO songs = new SongsByGenreDTO();

        songs.setPopSongs(this.getSongsByGenre(this.styleService.findStyle(Styles.POP)));
        songs.setJazzSongs(this.getSongsByGenre(this.styleService.findStyle(Styles.JAZZ)));
        songs.setRockSongs(this.getSongsByGenre(this.styleService.findStyle(Styles.ROCK)));

        return songs;
    }


}
