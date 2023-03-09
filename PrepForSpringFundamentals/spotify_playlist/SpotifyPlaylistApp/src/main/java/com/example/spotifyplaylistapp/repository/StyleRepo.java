package com.example.spotifyplaylistapp.repository;

import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.entity.StyleName;
import com.example.spotifyplaylistapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StyleRepo extends JpaRepository<Style, Long> {
    Optional<Style> findByStyleName(StyleName name);
}
