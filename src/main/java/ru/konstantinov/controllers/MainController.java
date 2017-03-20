package ru.konstantinov.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Asus on 19.03.2017.
 */
@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping(value="/zoo.html", method = RequestMethod.GET)
    public String openZooPage(Model model) {
        model.addAttribute("selectedMenu", "active");
        model.addAttribute("content", "");
        return "main";
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String openMainPage(Model model) {
        model.addAttribute("content", "");
        return "main";
    }

    @RequestMapping(value="/", method = RequestMethod.POST, produces="text/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String catchMainAjax(String data) {
        System.out.println(data);

        return "{'name' : 'catchMainAjax'}";
    }


    @RequestMapping(value="/zoo.html", method = RequestMethod.POST, produces="text/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String catchHtmlPageAjax(String data) {
        System.out.println(data);

        return "{'name' : 'catchHtmlPageAjax'}";
    }
    /*
    Пример ajax запроса
    var pst = {};
    $.ajax({
        type: 'POST',
        url: "http://localhost:8080/zoo.html",
        success: function(result) {
            console.log(result);
        },
        error: function() {
            console.log("bad");
        }
    });*/
}