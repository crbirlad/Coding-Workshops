package com.oracle.workshop.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA for the Oracle Coding Workshops.
 * User: crbirlad
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/MovieListerTest-context.xml")
public class MovieListerTest {
    @Autowired
    private IMovieFinder finder;

    @Test
    public void testGetMoviesNewerThan() throws Exception {
        assertEquals(2, MovieLister.getMoviesNewerThan(1990).size());
    }

    @Test
    public void testGetMoviesInYearRange() throws Exception {
        System.out.println(MovieLister.getMoviesInYearRange(finder.findAll(), 1990, 2009));
    }

    @Test
    public void testPrintMovies() throws Exception {

    }

    @Test
    public void testPrintMoviesWithPredicate() throws Exception {

    }

    @Test
    public void testProcessMovies() throws Exception {

    }

    @Test
    public void testProcessMoviesWithFunction() throws Exception {

    }
}
