package com.example.spotifyplaylistapp.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Table(name="songs")
public class Song extends BaseEntity{
    @Column(nullable = false)
    private String performer;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Integer duration;
    @Column(nullable = false)
    private LocalDate releaseDate ;
    @ManyToOne
    private Style style;

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

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }
}
