package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.SongDto;
import com.example.spotifyplaylistapp.util.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SongService {
void addSong(SongDto songDto);
    Song findSongByPerformer(String performer);
    List<Song>allSongs();
}
