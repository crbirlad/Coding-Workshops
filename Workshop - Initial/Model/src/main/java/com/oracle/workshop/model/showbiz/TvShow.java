package com.oracle.workshop.model.showbiz;

import com.oracle.workshop.model.visitor.ItemVisitor;

import java.util.Date;

/**
 * Created with IntelliJ IDEA for the Oracle Coding Workshops.
 * User: crbirlad
 */
public class TvShow extends EntertainmentItem {
    public TvShow(String title, Date releaseDate, String director, Genre genre, int seasons) {
        super(title, releaseDate, director, genre);
        this.seasons = seasons;
    }

    private int seasons;

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    @Override
    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getPrefix() {
        return "TV Show";
    }
}
