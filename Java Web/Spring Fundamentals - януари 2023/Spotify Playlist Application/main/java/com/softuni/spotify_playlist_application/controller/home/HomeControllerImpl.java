package com.softuni.spotify_playlist_application.controller.home;

import com.softuni.spotify_playlist_application.model.dtos.SongsByGenreDTO;
import com.softuni.spotify_playlist_application.service.home.HomeService;
import com.softuni.spotify_playlist_application.service.song.SongService;
import com.softuni.spotify_playlist_application.util.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeControllerImpl implements HomeController {
    private final LoggedUser loggedUser;

    private final HomeService homeService;

    private final SongService songService;

    @Autowired
    public HomeControllerImpl(LoggedUser loggedUser, HomeService homeService, SongService songService) {
        this.loggedUser = loggedUser;
        this.homeService = homeService;
        this.songService = songService;
    }

    @Override
    public String returnIndexPage() {
        if (loggedUser.isLogged()) {
            return "redirect:/home";
        }

        return "index";
    }

    @Override
    public String returnHomePage(Model model) {
        if (!loggedUser.isLogged()) {
            return "redirect:/";
        }

        model.addAttribute("songs", this.homeService.getSongs());
        model.addAttribute("playlist", this.songService.getPlaylist(loggedUser.getId()));

        return "home";
    }

    @Override
    public String addSongToPlaylist(Long id) {
        if (!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }

        this.homeService.addSong(id, this.loggedUser.getId());
        return "redirect:/home";
    }

    @Override
    public String removeSongFromPlaylist(Long id) {
        if (!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }

        this.homeService.removeSong(id, this.loggedUser.getId());
        return "redirect:/home";
    }

    @Override
    public String deleteAllFromPlaylist() {
        if (!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }

        this.homeService.deleteAll(this.loggedUser.getId());
        return "redirect:/home";
    }

    @ModelAttribute
    public SongsByGenreDTO songs() {
        return new SongsByGenreDTO();
    }
}
