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
@ContextConfiguration("/Test-context.xml")
public class MovieListerTest {
    @Autowired
    private MovieLister lister;

    @Test
    public void testGetMoviesNewerThan() throws Exception {
        assertEquals(2, lister.getMoviesNewerThan(1990).size());
    }
}
