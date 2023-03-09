package com.example.spotifyplaylistapp.init;

import com.example.spotifyplaylistapp.service.StyleServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private StyleServiceImpl styleService;

    public ConsoleRunner(StyleServiceImpl styleService) {
        this.styleService = styleService;
    }
    @Override
    public void run(String... args) throws Exception {
        this.styleService.seedAll();
    }
}
