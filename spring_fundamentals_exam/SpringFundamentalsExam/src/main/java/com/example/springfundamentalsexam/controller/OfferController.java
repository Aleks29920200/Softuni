package com.example.springfundamentalsexam.controller;


import com.example.springfundamentalsexam.domain.dto.OfferDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public interface OfferController {
    @GetMapping("/addOffer")
    String addSong();

    @PostMapping("/addOffer")
    String addSongPost(@Valid OfferDto productDto, BindingResult result, RedirectAttributes attr);
}
