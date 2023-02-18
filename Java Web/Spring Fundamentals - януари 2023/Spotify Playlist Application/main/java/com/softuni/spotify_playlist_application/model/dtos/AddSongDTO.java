package com.softuni.spotify_playlist_application.model.dtos;

import com.softuni.spotify_playlist_application.model.enums.Styles;
import com.softuni.spotify_playlist_application.validation.annotation.UniquePerformer;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class AddSongDTO {
    private Long id;

    @Size(min = 3, max = 20, message = "Performer name length must be between 3 and 20 characters (inclusive 3 and 20).")
    @NotNull(message = "You must enter a performer!")
    @UniquePerformer
    private String performer;

    @Size(min = 2, max = 20, message = "Title length must be between 2 and 20 characters (inclusive 2 and 20).")
    @NotNull(message = "You must enter a title!")
    private String title;

    @PastOrPresent(message = "The date cannot be in the future!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @Positive(message = "Duration must be positive!")
    @NotNull(message = "You must enter a duration!")
    private Long duration;

    @NotNull(message = "You must select a style!")
    private Styles style;

    public AddSongDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Styles getStyle() {
        return style;
    }

    public void setStyle(Styles style) {
        this.style = style;
    }
}
