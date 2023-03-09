package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.entity.StyleName;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface StyleService {
    void seedAll();
    Optional<Style> findStyleByStyleName(StyleName name);

}
