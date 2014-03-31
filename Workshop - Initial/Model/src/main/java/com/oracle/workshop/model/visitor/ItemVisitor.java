package com.oracle.workshop.model.visitor;

import com.oracle.workshop.model.showbiz.Movie;
import com.oracle.workshop.model.showbiz.Trailer;
import com.oracle.workshop.model.showbiz.TvShow;

/**
 * Created with IntelliJ IDEA for the Oracle Coding Workshops.
 * User: crbirlad
 */
public interface ItemVisitor {
    public void visit(Movie movie);
    public void visit(TvShow tvShow);
    public void visit(Trailer trailer);
}
