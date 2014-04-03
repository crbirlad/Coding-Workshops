package com.springapp.mvc;

import com.oracle.workshop.model.IMovieFinder;
import com.oracle.workshop.model.MovieLister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA for the Oracle Coding Workshops.
 * User: crbirlad
 */
@Controller
@RequestMapping("/MovieList")
public class MovieListController {
    @Autowired
    private IMovieFinder finder;

    @Autowired
    private MovieLister lister;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("messages", lister.getMoviesInYearRange(1980, 2009));
        return "MovieList";
    }
}
