package com.oracle.workshop.model.impl;

import com.oracle.workshop.common.util.ShowBizUtil;
import com.oracle.workshop.model.IMovieFinder;
import com.oracle.workshop.model.showbiz.Movie;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA for the Oracle Coding Workshops.
 * User: crbirlad
 */
public class SimpleMovieFinder implements IMovieFinder {
    //TODO: leave this in initial project only
    //get log4j handler
    private static final Logger logger = Logger.getLogger(SimpleMovieFinder.class);

    public List<Movie> findAll() {
        //TODO: read from DB
        List<Movie> movies = new ArrayList<>();

        Movie movie;

        movie = new Movie("The Shawshank Redemption", ShowBizUtil.getDateFullFormat("October 14, 1994"), "Darabont", Movie.Genre.DRAMA, Movie.MpaaRating.PG_13);
        movies.add(movie);

        movie = new Movie("Schindler's List", ShowBizUtil.getDateFullFormat("December 15, 1993"), "Spielberg", Movie.Genre.DRAMA, Movie.MpaaRating.G);
        movies.add(movie);

        return movies;
    }


}
