package com.softuni.spotify_playlist_application.service.song;

import com.softuni.spotify_playlist_application.model.dtos.AddSongDTO;
import com.softuni.spotify_playlist_application.model.dtos.SongDTO;
import com.softuni.spotify_playlist_application.model.entity.Song;
import com.softuni.spotify_playlist_application.model.entity.Style;
import com.softuni.spotify_playlist_application.repository.SongRepository;
import com.softuni.spotify_playlist_application.service.style.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;

    private final StyleService styleService;

    @Autowired
    public SongServiceImpl(SongRepository songRepository, StyleService styleService) {
        this.songRepository = songRepository;
        this.styleService = styleService;
    }


    @Override
    public SongDTO findSongByPerformer(String performer) {
        Song song = this.songRepository.findSongByPerformer(performer).orElse(null);

        if (song == null) return null;

        SongDTO songDTO = new SongDTO();
        songDTO.setPerformer(song.getPerformer());
        songDTO.setDuration(song.getDuration());
        songDTO.setTitle(song.getTitle());

        return songDTO;
    }

    @Override
    public void addSong(AddSongDTO addSongDTO) {
        Song song = new Song();

        Style style = styleService.findStyle(addSongDTO.getStyle());

        song.setDuration(addSongDTO.getDuration());
        song.setPerformer(addSongDTO.getPerformer());
        song.setStyle(style);
        song.setTitle(addSongDTO.getTitle());
        song.setReleaseDate(addSongDTO.getReleaseDate());

        this.songRepository.save(song);
    }

    @Override
    public Song findSongById(Long id) {
        return this.songRepository.findById(id).orElseThrow();
    }

    @Override
    public Set<SongDTO> findSongsByStyle(Style style) {
        return this.songRepository.findByStyle(style)
                .stream()
                .map(this::mapSongDTO)
                .collect(Collectors.toSet());
    }

    private SongDTO mapSongDTO(Song song) {
        SongDTO songDTO = new SongDTO();

        songDTO.setId(song.getId());
        songDTO.setDuration(song.getDuration());
        songDTO.setPerformer(song.getPerformer());
        songDTO.setTitle(song.getTitle());

        return songDTO;
    }

    @Override
    public Set<SongDTO> getPlaylist(Long id) {
        return this.songRepository.findAllByUserId(id)
                .stream()
                .map(this::mapSongDTO)
                .collect(Collectors.toSet());
    }
}
