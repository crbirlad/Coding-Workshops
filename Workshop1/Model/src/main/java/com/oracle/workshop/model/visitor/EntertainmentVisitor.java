package com.oracle.workshop.model.visitor;

import com.oracle.workshop.model.showbiz.Movie;
import com.oracle.workshop.model.showbiz.Trailer;
import com.oracle.workshop.model.showbiz.TvShow;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA for the Oracle Coding Workshops.
 * User: crbirlad
 */
public class EntertainmentVisitor implements ItemVisitor {
    //get log4j handler
    private static final Logger logger = Logger.getLogger(EntertainmentVisitor.class);

    @Override
    public void visit(Movie movie) {
        logger.info(movie.getMpaaRating() + " movie");
    }

    @Override
    public void visit(TvShow tvShow) {
        logger.info(tvShow.getSeasons() + " seasons");
    }

    @Override
    public void visit(Trailer trailer) {
        logger.info(trailer.isTeaser() ? "Teaser Trailer" : "Full Trailer");
    }
}
