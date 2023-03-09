package com.example.spotifyplaylistapp.model.entity;


import com.example.spotifyplaylistapp.validations.annotation.UniquePerformer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class SongDto {
    @Size(min=3,max=20,message = "Length must be between 3 and 20 characters")
    @NotBlank(message = "Performer cannot be empty")
    @UniquePerformer
    private String performer;
    @Size(min=2,max=20,message = "Length must be between 2 and 20 characters")
    @NotBlank(message = "Title cannot be empty")
    private String title;
    @Positive(message = "Duration must be positive.")
    private Integer duration;
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    @NotBlank(message = "You must select a style")
    private String style;

    public SongDto() {

    }
    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }




    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
