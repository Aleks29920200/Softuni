package com.example.spotifyplaylistapp.repository;

import com.example.spotifyplaylistapp.model.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepo extends JpaRepository<Song, Long> {
    Song findSongByPerformer(String performer);
}
