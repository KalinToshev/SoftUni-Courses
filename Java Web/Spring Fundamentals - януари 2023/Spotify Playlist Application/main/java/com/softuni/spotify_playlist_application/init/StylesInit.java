package com.softuni.spotify_playlist_application.init;

import com.softuni.spotify_playlist_application.service.style.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StylesInit implements CommandLineRunner {
    private final StyleService styleService;

    @Autowired
    public StylesInit(StyleService styleService) {
        this.styleService = styleService;
    }


    @Override
    public void run(String... args) throws Exception {
        this.styleService.initStyles();
    }
}
