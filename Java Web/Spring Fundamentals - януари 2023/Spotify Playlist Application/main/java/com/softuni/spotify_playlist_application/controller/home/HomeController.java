package com.softuni.spotify_playlist_application.controller.home;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public interface HomeController {
    @GetMapping
    String returnIndexPage();

    @GetMapping("/home")
    String returnHomePage(Model model);

    @GetMapping("/home/add-song-to-playlist/{id}")
    String addSongToPlaylist(@PathVariable("id") Long id);

    @GetMapping("/home/remove-song-from-playlist/{id}")
    String removeSongFromPlaylist(@PathVariable("id") Long id);

    @GetMapping("/home/remove-all-song-from-playlist")
    String deleteAllFromPlaylist();
}
