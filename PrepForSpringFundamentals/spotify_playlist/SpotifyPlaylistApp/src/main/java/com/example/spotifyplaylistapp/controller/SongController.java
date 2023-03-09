package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.entity.SongDto;
import com.example.spotifyplaylistapp.service.SongServiceImpl;
import com.example.spotifyplaylistapp.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SongController {
    private SongServiceImpl songService;
    private LoggedUser loggedUser;

    public SongController(SongServiceImpl songService, LoggedUser loggedUser) {
        this.songService = songService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/addSong")
    public String addSong(){
        return "song-add";
    }
    @PostMapping("/addSong")
    public String addSongPost(@Valid SongDto songDto, BindingResult result, RedirectAttributes attr){
        if(result.hasErrors()){
            attr
                    .addFlashAttribute("songDto", songDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.songDto", result);

            return "redirect:/addSong";
        }
        this.songService.addSong(songDto);
        return "redirect:/home";
    }
    @ModelAttribute
    public SongDto songDto() {
        return new SongDto();
    }

}
