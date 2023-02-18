package com.softuni.spotify_playlist_application.repository;

import com.softuni.spotify_playlist_application.model.entity.Style;
import com.softuni.spotify_playlist_application.model.enums.Styles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StyleRepository extends JpaRepository<Style, Long> {
    Optional<Style> findStyleByStyleName(Styles style);
}
