package com.oracle.workshop.model;

import com.oracle.workshop.model.impl.SimpleMovieFinder;
import com.oracle.workshop.model.showbiz.Movie;
import com.oracle.workshop.model.strategy.CheckMovie;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

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
    @Autowired
    private IMovieFinder movieFinder;

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
    public List<Movie> getMoviesInYearRange(int startYear, int endYear) {
        List<Movie> results = new ArrayList<>();
        List<Movie> movies = movieFinder.findAll();

        for (Movie movie : movies) {
            if (startYear <= movie.getYear() && movie.getYear() <= endYear) {
                results.add(movie);
            }
        }

        return results;
    }

    public void printMovies(CheckMovie tester) {
        List<Movie> movies = movieFinder.findAll();

        for (Movie movie : movies) {
            if (tester.test(movie)) {
                logger.info(movie);
            }
        }
    }

    public void printMoviesWithPredicate(Predicate<Movie> tester) {
        List<Movie> movies = movieFinder.findAll();

        for (Movie movie : movies) {
            if (tester.test(movie)) {
                logger.info(movie);
            }
        }
    }

    public void processMovies(Predicate<Movie> tester,
                              Consumer<Movie> block) {
        List<Movie> movies = movieFinder.findAll();

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

    public IMovieFinder getMovieFinder() {
        return movieFinder;
    }

    public void setMovieFinder(IMovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }
}
