package com.softuni.spotify_playlist_application.service.style;

import com.softuni.spotify_playlist_application.model.entity.Style;
import com.softuni.spotify_playlist_application.model.enums.Styles;
import com.softuni.spotify_playlist_application.repository.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class StyleServiceImpl implements StyleService {
    private final StyleRepository styleRepository;

    @Autowired
    public StyleServiceImpl(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public void initStyles() {
        if (this.styleRepository.count() != 0) return;

        Arrays.stream(Styles.values())
                .forEach(_style -> {
                    Style style = new Style();
                    style.setStyleName(_style);
                    style.setDescription("Lorem Ipsum...");

                    this.styleRepository.save(style);
                });
    }

    @Override
    public Style findStyle(Styles style) {
        return this.styleRepository.findStyleByStyleName(style).orElseThrow();
    }
}
