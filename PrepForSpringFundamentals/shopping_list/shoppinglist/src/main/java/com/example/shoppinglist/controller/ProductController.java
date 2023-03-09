package com.example.shoppinglist.controller;

import com.example.shoppinglist.domain.dto.ProductDto;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface ProductController {
    @GetMapping("/addProduct")
    String addSong();

    @PostMapping("/addProduct")
    String addSongPost(@Valid ProductDto productDto, BindingResult result, RedirectAttributes attr);
}
