package com.springapp.mvc;

import com.springapp.model.TextEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {
    private TextEditor textEditor;

    @Autowired
    public HelloController(TextEditor textEditor)   {
        this.textEditor = textEditor;
    }

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", textEditor.spellCheck());
		return "hello";
	}
}