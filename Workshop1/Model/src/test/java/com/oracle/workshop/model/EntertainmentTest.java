package com.oracle.workshop.model;

import com.oracle.workshop.common.util.ShowBizUtil;
import com.oracle.workshop.model.showbiz.*;
import com.oracle.workshop.model.visitor.ItemVisitor;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA for the Oracle Coding Workshops.
 * User: crbirlad
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/Test-context.xml")
public class EntertainmentTest {
    //get log4j handler
    private static final Logger logger = Logger.getLogger(EntertainmentTest.class);

    @Autowired
    private ItemVisitor itemVisitor;

    private List<Item> items;

    @Before
    public void setUpTestDataWithinTransaction() {
        // set up test data
        items = new ArrayList<>();

        Movie movie = new Movie("The Dark Knight", ShowBizUtil.getDateFullFormat("July 25, 2008"), "Nolan", EntertainmentItem.Genre.ACTION, Movie.MpaaRating.PG_13);
        TvShow tvShow = new TvShow("Lost", ShowBizUtil.getDateOnlyYear("2008"), "Abrams", EntertainmentItem.Genre.SCI_FI, 6);
        Trailer trailer = new Trailer("Captain America: Winter Soldier", ShowBizUtil.getDateFullFormat("January 1, 2014"), "Russos", EntertainmentItem.Genre.ACTION, false);
        movie.setMpaaRating(Movie.MpaaRating.R);

        items.add(movie);
        items.add(tvShow);
        items.add(trailer);
    }

    @Test
    public void canVisitEntertainmentItem() {
        for(Item item : items)  {
            item.accept(itemVisitor);
        }
    }
}