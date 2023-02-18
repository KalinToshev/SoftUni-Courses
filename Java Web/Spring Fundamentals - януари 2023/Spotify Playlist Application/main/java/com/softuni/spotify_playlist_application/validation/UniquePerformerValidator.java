package com.softuni.spotify_playlist_application.validation;

import com.softuni.spotify_playlist_application.service.song.SongService;
import com.softuni.spotify_playlist_application.validation.annotation.UniquePerformer;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniquePerformerValidator implements ConstraintValidator<UniquePerformer, String> {
    private final SongService songService;

    @Autowired
    public UniquePerformerValidator(SongService songService) {
        this.songService = songService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.songService.findSongByPerformer(value) == null;
    }
}
