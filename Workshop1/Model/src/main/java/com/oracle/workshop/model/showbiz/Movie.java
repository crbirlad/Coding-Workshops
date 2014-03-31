package com.oracle.workshop.model.showbiz;

import com.oracle.workshop.model.visitor.ItemVisitor;

import java.util.Date;

/**
 * Created with IntelliJ IDEA for the Oracle Coding Workshops.
 * User: crbirlad
 */
public class Movie extends EntertainmentItem {
    public Movie(String title, Date releaseDate, String director, Genre genre, MpaaRating mpaaRating) {
        super(title, releaseDate, director, genre);
        this.mpaaRating = mpaaRating;
    }

    public MpaaRating getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(MpaaRating mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public enum MpaaRating {
        G, PG, PG_13, R, NC_17
    }

    private MpaaRating mpaaRating;


    @Override
    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getPrefix() {
        return "Movie";
    }
}
