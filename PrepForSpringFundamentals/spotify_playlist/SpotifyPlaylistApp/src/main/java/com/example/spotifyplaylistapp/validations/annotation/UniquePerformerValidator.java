package com.example.spotifyplaylistapp.validations.annotation;

import com.example.spotifyplaylistapp.service.SongServiceImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniquePerformerValidator implements ConstraintValidator<UniquePerformer, String> {

    private final SongServiceImpl songService;

    public UniquePerformerValidator(SongServiceImpl songService) {
        this.songService = songService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.songService.findSongByPerformer(value) == null;
    }
}
