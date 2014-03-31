package com.oracle.workshop.da;

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
public class HappyMovieFinder implements IMovieFinder {
    //get log4j handler
    private static final Logger logger = Logger.getLogger(HappyMovieFinder.class);

    public List<Movie> findAll() {
        //TODO: read from DB
        List<Movie> movies = new ArrayList<>();

        Movie movie;

        movie = new Movie("The Matrix", ShowBizUtil.getDateFullFormat("March 31, 1999"), "The Wachowski Brothers", Movie.Genre.ACTION, Movie.MpaaRating.PG_13);
        movies.add(movie);

        movie = new Movie("Indiana Jones: Raiders of the Lost Ark", ShowBizUtil.getDateFullFormat("June 12, 1981"), "Spielberg", Movie.Genre.ACTION, Movie.MpaaRating.G);
        movies.add(movie);

        return movies;
    }
}
