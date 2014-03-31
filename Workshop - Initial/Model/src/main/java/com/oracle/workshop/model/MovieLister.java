package com.oracle.workshop.model;

import com.oracle.workshop.model.impl.SimpleMovieFinder;
import com.oracle.workshop.model.showbiz.Movie;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created with IntelliJ IDEA for the Oracle Coding Workshops.
 * User: crbirlad
 */
public class MovieLister {
    //get log4j handler
    private static final Logger logger = Logger.getLogger(MovieLister.class);

    /**
     * filter by year
     */
    public List<Movie> getMoviesNewerThan(int year) {
        SimpleMovieFinder finder = new SimpleMovieFinder();
        List<Movie> movies = finder.findAll();

        List<Movie> results = new ArrayList<>();

        for (Movie movie : movies) {
            if (movie.getYear() >= year) {
                results.add(movie);
            }
        }

        return results;
    }

    /**
     * filter by year range
     */
    public List<Movie> getMoviesInYearRange(List<Movie> movies, int startYear, int endYear) {
        List<Movie> results = new ArrayList<>();

        for (Movie movie : movies) {
            if (startYear <= movie.getYear() && movie.getYear() <= endYear) {
                results.add(movie);
            }
        }

        return results;
    }

    public void printMovies(List<Movie> movies, CheckMovie tester) {
        for (Movie movie : movies) {
            if (tester.test(movie)) {
                logger.info(movie);
            }
        }
    }

    public void printMoviesWithPredicate(List<Movie> movies, Predicate<Movie> tester) {
        for (Movie movie : movies) {
            if (tester.test(movie)) {
                logger.info(movie);
            }
        }
    }

    public void processMovies(List<Movie> movies,
                              Predicate<Movie> tester,
                              Consumer<Movie> block) {
        for (Movie movie : movies) {
            if (tester.test(movie)) {
                block.accept(movie);
            }
        }
    }

    public <X, Y> void processMoviesWithFunction(Iterable<X> source,
                                                 Predicate<X> tester,
                                                 Function<X, Y> mapper,
                                                 Consumer<Y> block) {
        for (X x : source) {
            if (tester.test(x)) {
                Y data = mapper.apply(x);
                block.accept(data);
            }
        }
    }
}
