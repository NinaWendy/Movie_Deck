package com.moringaschool.movie_deck.ui.fragments;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoginFragmentTest {
    @Test
    public void validateUserInput_returnTrue() {
        String  user ="Wendy";
        assertTrue(validateUser(user));
    }
    //helper
    public Boolean validateUser(String user) {
        if (user.isEmpty() || user.length() < 2) {
            return Boolean.FALSE;
        } else
            return Boolean.TRUE;
    }

}