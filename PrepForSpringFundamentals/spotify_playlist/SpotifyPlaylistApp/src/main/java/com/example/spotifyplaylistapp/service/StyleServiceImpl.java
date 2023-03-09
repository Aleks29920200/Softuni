package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.entity.StyleName;
import com.example.spotifyplaylistapp.repository.StyleRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StyleServiceImpl implements StyleService {
    private StyleRepo styleRepo;

    public StyleServiceImpl(StyleRepo styleRepo) {
        this.styleRepo = styleRepo;
    }
    @Override
    public void seedAll() {
        if(this.styleRepo.count()==0) {
            Style pop = new Style();
            pop.setStyleName(StyleName.valueOf("POP"));
            this.styleRepo.save(pop);
            Style rock = new Style();
            rock.setStyleName(StyleName.valueOf("ROCK"));
            this.styleRepo.save(rock);
            Style jazz = new Style();
            jazz.setStyleName(StyleName.valueOf("JAZZ"));
            this.styleRepo.save(jazz);
        }
    }

    @Override
    public Optional<Style> findStyleByStyleName(StyleName name) {
        return Optional.ofNullable(this.styleRepo.findByStyleName(name).orElse(null));
    }
}
