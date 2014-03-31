package com.oracle.workshop.model.showbiz;

import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA for the Oracle Coding Workshops.
 * User: crbirlad
 */
public abstract class EntertainmentItem implements Item {
    public EntertainmentItem()  {
    }

    public EntertainmentItem(String title, Date releaseDate, String director, Genre genre) {
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

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public abstract String getPrefix();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getPrefix());
        sb.append(":");
        sb.append(title);
        sb.append("|");
        sb.append(getYear());
        sb.append("-");
        sb.append(director);

        return sb.toString();
    }

    public enum Genre {
        ACTION, DRAMA, ANIMATION, SCI_FI
    }

    private String title;
    private Date releaseDate;
    private String director;
    private Genre genre;
    private long duration;
}
