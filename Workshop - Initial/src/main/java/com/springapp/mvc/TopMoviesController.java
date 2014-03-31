package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: crbirlad
 */
@Controller

public class TopMoviesController {
    @RequestMapping("/TopMovies")
    public String getTopMovies(ModelMap model) {
        return getCommonData(model);
    }

    @RequestMapping("/")
    public String getDefaultContext(ModelMap model) {
        return getCommonData(model);
    }

    private String getCommonData(ModelMap model) {
        return "TopMovies";
    }
}
