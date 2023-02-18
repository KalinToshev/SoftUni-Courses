package com.softuni.spotify_playlist_application.controller.song;

import com.softuni.spotify_playlist_application.model.dtos.AddSongDTO;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/songs")
public interface SongController {
    @GetMapping("/add-song")
    String returnAddSongPage();

    @PostMapping("/add-song")
    String addSong(@Valid AddSongDTO addSongDTO, BindingResult result, RedirectAttributes redirectAttributes);
}
