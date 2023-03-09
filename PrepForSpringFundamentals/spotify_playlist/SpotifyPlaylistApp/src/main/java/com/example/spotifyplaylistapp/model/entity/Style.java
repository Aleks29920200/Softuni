package com.example.spotifyplaylistapp.model.entity;

import javax.persistence.*;

@Entity
@Table(name="styles")
public class Style extends BaseEntity{
    @Enumerated(EnumType.STRING)
    @Column(nullable = false,unique = true)
    private StyleName styleName;
    @Column(columnDefinition = "TEXT")
    private String description;

    public Style() {
    }

    public StyleName getStyleName() {
        return styleName;
    }

    public void setStyleName(StyleName styleName) {
        this.styleName = styleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
