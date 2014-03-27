package com.oracle.workshop.da;

import com.oracle.workshop.model.IMovieFinder;
import com.oracle.workshop.model.Movie;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA for the Oracle Coding Workshops.
 * User: crbirlad
 */
public class HappyMovieFinder implements IMovieFinder {
    //get log4j handler
    private static final Logger logger = Logger.getLogger(HappyMovieFinder.class);

    public List<Movie> findAll() {
        //TODO: read from properties file
        List<Movie> movies = new ArrayList<>();

        Movie movie;
        Date releaseDate;
        String dateString;

        dateString = "October 14, 1994";
        try {
            releaseDate = new SimpleDateFormat("MMMM d, yyyy", Locale.US).parse(dateString);
        } catch (ParseException e) {
            releaseDate = handleParseException();
        }

        movie = new Movie("The Shawshank Redemption", releaseDate, "Darabont", Movie.Genre.DRAMA);
        movies.add(movie);

        dateString = "December 15, 1993";
        try {
            releaseDate = new SimpleDateFormat("MMMM d, yyyy", Locale.US).parse(dateString);
        } catch (ParseException e) {
            releaseDate = handleParseException();
        }

        movie = new Movie("Schindler's List", releaseDate, "Spielberg", Movie.Genre.DRAMA);
        movies.add(movie);

        return movies;
    }

    private Date handleParseException() {
        Date releaseDate;
        logger.error("error in parsing date");
        releaseDate = new Date();
        return releaseDate;
    }
}
