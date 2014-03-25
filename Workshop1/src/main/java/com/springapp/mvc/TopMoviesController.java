package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: crbirlad
 */
@Controller
@RequestMapping("/TopMovies")
public class TopMoviesController {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        return "TopMovies";
    }
}
