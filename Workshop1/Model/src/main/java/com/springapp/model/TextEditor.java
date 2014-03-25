package com.springapp.model;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: crbirlad
 */
public class TextEditor {
    @Autowired
    private SpellChecker spellChecker;

//    public TextEditor(SpellChecker spellChecker) {
//        this.spellChecker = spellChecker;
//        System.out.println("Inside TextEditor constructor.");
//    }

    public String spellCheck() {
        return spellChecker.checkSpelling();
    }

    public void setSpellChecker(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }
}
