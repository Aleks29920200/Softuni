package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.SongByJenre;
import com.example.spotifyplaylistapp.model.entity.SongDto;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.service.SongServiceImpl;
import com.example.spotifyplaylistapp.service.UserServiceImpl;
import com.example.spotifyplaylistapp.util.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class Home {
    private LoggedUser loggedUser;
    private SongServiceImpl songService;
    private ModelMapper mapper=new ModelMapper();
    private UserServiceImpl userService;


    public Home(LoggedUser loggedUser , SongServiceImpl songService, UserServiceImpl userService) {
        this.loggedUser = loggedUser;
        this.songService = songService;
        this.userService = userService;
    }
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @PostMapping("/")
    public String postIndex() {
        return "redirect:/index";
    }
    @GetMapping("/home")
    public String home(Model model){
        List<Song> songs = this.songService.allSongs();
        model.addAttribute("songs",songs);
        List<SongByJenre> playlist = this.userService.findUserByUsername(loggedUser.getUsername()).get().getPlaylist().stream().map(e -> mapper.map(e, SongByJenre.class)).toList();
        model.addAttribute("playlist",playlist);
        return "home";
    }

}
