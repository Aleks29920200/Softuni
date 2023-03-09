package com.example.spotifyplaylistapp.service;


import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.SongDto;
import com.example.spotifyplaylistapp.model.entity.StyleName;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.repository.SongRepo;
import com.example.spotifyplaylistapp.util.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    private StyleServiceImpl styleService;
    private SongRepo songRepo;
    private UserServiceImpl userService;

    public SongServiceImpl(StyleServiceImpl styleService, SongRepo songRepo, UserServiceImpl userService) {
        this.styleService = styleService;
        this.songRepo = songRepo;
        this.userService = userService;
    }
    public void addSong(SongDto songDto) {
        Song song=new Song();
        song.setPerformer(songDto.getPerformer());
        song.setDuration(songDto.getDuration());
        song.setTitle(songDto.getTitle());
        song.setReleaseDate(songDto.getReleaseDate());
        song.setStyle(this.styleService.findStyleByStyleName(StyleName.valueOf(songDto.getStyle())).get());
        this.songRepo.save(song);
    }
    public void addToPlaylist(LoggedUser loggedUser){
        User user = this.userService.findUserByUsername(loggedUser.getUsername()).get();
        List<Song>playlist=new ArrayList<>();
        user.setPlaylist(playlist);
    }
    @Override
    public Song findSongByPerformer(String performer) {
        return this.songRepo.findSongByPerformer(performer);
    }

    @Override
    public List<Song> allSongs() {
        return this.songRepo.findAll();
    }
}
