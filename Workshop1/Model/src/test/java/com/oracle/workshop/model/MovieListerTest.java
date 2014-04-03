package com.oracle.workshop.model;

import com.oracle.workshop.model.showbiz.EntertainmentItem;
import com.oracle.workshop.model.showbiz.Movie;
import com.oracle.workshop.model.strategy.CheckMovie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA for the Oracle Coding Workshops.
 * User: crbirlad
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/Test-context.xml")
public class MovieListerTest {
    @Autowired
    private MovieLister lister;

    @Test
    public void testGetMoviesNewerThan() throws Exception {
        assertEquals(2, lister.getMoviesNewerThan(1990).size());
    }

    @Test
    public void testGetMoviesInYearRange() throws Exception {
        assertEquals(2, lister.getMoviesInYearRange(1990, 2009).size());
    }

    @Test
    public void testPrintMovies() throws Exception {
        lister.printMovies(new CheckMovie() {
            public boolean test(Movie movie) {
                return movie.getGenre() == EntertainmentItem.Genre.DRAMA
                        && movie.getYear() >= 1990
                        && movie.getYear() <= 2020;
            }
        }
        );
    }

    @Test
    public void testPrintMoviesWithPredicate() throws Exception {
        lister.printMoviesWithPredicate(
                movie -> movie.getGenre() == Movie.Genre.DRAMA
                        && movie.getYear() >= 1990
                        && movie.getYear() <= 2020
        );
    }

    @Test
    public void testProcessMovies() throws Exception {
        List<Movie> results = new ArrayList<>();

        lister.processMovies(
                movie -> movie.getGenre() == Movie.Genre.DRAMA
                        && movie.getYear() >= 1990
                        && movie.getYear() <= 2020,
                movie -> results.add(movie)
        );

        assertEquals(2, results.size());
    }

    @Test
    public void testProcessMoviesWithFunction() throws Exception {
        List<String> results = new ArrayList<>();

        lister.processMoviesWithFunction(
                lister.getMovieFinder().findAll(),
                movie -> movie.getGenre() == Movie.Genre.DRAMA
                        && movie.getYear() >= 1990
                        && movie.getYear() <= 2020,
                movie -> movie.getDirector(),
                director -> results.add(director)
        );

        assertEquals(2, results.size());
    }

    @Test
    public void testGenericApproach() {
        List<String> results = new ArrayList<>();

        lister.getMovieFinder().findAll()
                .stream()
                .filter(
                        movie -> (movie.getGenre() == Movie.Genre.ACTION || movie.getGenre() == Movie.Genre.DRAMA)
                                && movie.getYear() >= 1990
                                && movie.getYear() <= 2020)
                .map(movie -> movie.getTitle())
                .forEach(title -> results.add(title));

        assertEquals(2, results.size());
    }
}
