package com.oracle.workshop.model;

import com.oracle.workshop.model.showbiz.Movie;

import java.util.List;

/**
 * Created with IntelliJ IDEA for the Oracle Coding Workshops.
 * User: crbirlad
 */
public interface IMovieFinder {
    public List<Movie> findAll();
}
