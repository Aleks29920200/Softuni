package com.example.springfundamentalsexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public interface HomeController {

    @GetMapping()
    String index();

    @PostMapping()
    String postIndex();

    @GetMapping("/home")
    String home(Model model);
    @GetMapping("remove/{id}")
    String remove(@PathVariable Long id);
    @GetMapping("buy/{id}")
    String buy(@PathVariable Long id);



}
