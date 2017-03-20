package ru.konstantinov.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.konstantinov.content.ConstructContent;
import ru.konstantinov.content.ContentFactory;
import ru.konstantinov.content.ContentType;

import java.util.Map;

/**
 * Created by Asus on 19.03.2017.
 */
@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping(value = "/zoo.html", method = RequestMethod.GET)
    public String openZooPage(Model model) {
        ConstructContent content = ContentFactory.getContentInstance(ContentType.ZOO_PAGE);

        for (Map.Entry<String, String> attribute : content.getAttributes()) {
            model.addAttribute(attribute.getKey(), attribute.getValue());
        }

        return content.getView();
    }

    @RequestMapping(value = "/zoo.html", method = RequestMethod.POST, produces = "text/html")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String catchZooPageAjax(String data) {
        return "{'name' : 'catchHtmlPageAjax'}";
    }
}