package com.oracle.workshop.model;

import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA for the Oracle Coding Workshops.
 * User: crbirlad
 */
public class Movie {

    public Movie() {

    }

    public Movie(String title, Date releaseDate, String director, Genre genre) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.director = director;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public int getYear() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(releaseDate);
        return cal.get(Calendar.YEAR);
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: ");
        sb.append(title);
        sb.append("| Year: ");
        sb.append(getYear());
        sb.append("| Director: ");
        sb.append(director);

        return sb.toString();
    }

    public enum Genre {
        ACTION, DRAMA, ANIMATION
    }

    private String title;
    private Date releaseDate;
    private String director;
    private Genre genre;


}
