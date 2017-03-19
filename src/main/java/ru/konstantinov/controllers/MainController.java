package ru.konstantinov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Asus on 19.03.2017.
 */
@Controller
@RequestMapping("/zoo.html")
public class MainController {
    //@RequestParam(value="name", required=false, defaultValue="World") String name,
    @RequestMapping(method = RequestMethod.GET)
    public String openPage(Model model) {
        //model.addAttribute("visitorCount", name);
        return "index.jsp";
    }
}
