package com.softuni.spotify_playlist_application.model.entity;

import com.softuni.spotify_playlist_application.model.enums.Styles;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "styles")
public class Style extends BaseEntity {
    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private Styles styleName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "style", fetch = FetchType.LAZY)
    private Set<Song> songs;

    public Style() {
    }

    public Styles getStyleName() {
        return styleName;
    }

    public void setStyleName(Styles styleName) {
        this.styleName = styleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }
}
