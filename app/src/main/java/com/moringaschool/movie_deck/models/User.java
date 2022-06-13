package com.moringaschool.movie_deck.models;

public class User {
    public String userFullName, emailAddress, contact;

    public User() {
    }

    public User(String userFullName, String emailAddress, String contact) {
        this.userFullName = userFullName;
        this.emailAddress = emailAddress;
        this.contact = contact;
    }
}
