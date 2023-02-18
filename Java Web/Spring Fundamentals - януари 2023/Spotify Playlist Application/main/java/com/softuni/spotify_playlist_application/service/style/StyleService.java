package com.softuni.spotify_playlist_application.service.style;

import com.softuni.spotify_playlist_application.model.entity.Style;
import com.softuni.spotify_playlist_application.model.enums.Styles;

public interface StyleService {
    void initStyles();

    Style findStyle(Styles style);
}
