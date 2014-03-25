package com.springapp.impl;

import com.springapp.model.SpellChecker;

/**
 * Created with IntelliJ IDEA.
 * User: crbirlad
 */
public class ActualSpellChecker implements SpellChecker {
    public ActualSpellChecker() {
        System.out.println("Inside the brand new SpellChecker constructor.");
    }

    public String checkSpelling() {
        return "Inside the brand new checkSpelling.";
    }
}
