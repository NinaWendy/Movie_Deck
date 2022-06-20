package com.moringaschool.movie_deck.models;

public class Favourite {
    private String  originalTitle;

    public Favourite() {
    }

    public Favourite(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }
}
