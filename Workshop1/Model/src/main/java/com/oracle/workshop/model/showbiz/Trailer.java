package com.oracle.workshop.model.showbiz;

import com.oracle.workshop.model.visitor.ItemVisitor;

import java.util.Date;

/**
 * Created with IntelliJ IDEA for the Oracle Coding Workshops.
 * User: crbirlad
 */
public class Trailer extends EntertainmentItem {
    public Trailer(String title, Date releaseDate, String director, Genre genre, boolean isTeaser) {
        super(title, releaseDate, director, genre);
        this.isTeaser = isTeaser;
    }

    private boolean isTeaser;

    public boolean isTeaser() {
        return isTeaser;
    }

    public void setTeaser(boolean teaser) {
        isTeaser = teaser;
    }

    @Override
    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getPrefix() {
        return "Trailer";
    }
}
