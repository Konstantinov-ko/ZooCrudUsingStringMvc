package ru.konstantinov.content.page;

import ru.konstantinov.base.BaseAction;
import ru.konstantinov.html.HtmlTagWrapper;
import ru.konstantinov.zoo.Zoo;

import java.util.Map;

/**
 * Created by Asus on 20.03.2017.
 */
public class ZooPageContent extends PageContent {
    void constructAttributes() {
        this.view = "main";
        this.attributes.put("selectedMenu", "active");
    }

    void constructContent() {
        HtmlTagWrapper zooHtml = new HtmlTagWrapper();

        Map<Integer, Zoo> zooList = BaseAction.GET_ALL.action();
        zooHtml.openHtmlTag("div", "row");

        for (Map.Entry<Integer, Zoo> zooEntry : zooList.entrySet()) {
            zooHtml.openHtmlTag("div", "col-md-6 col-lg-4");
            zooHtml.appendHtml(zooEntry.getValue().getZooHtml());
            zooHtml.closeHtmlTag("div");
        }
        zooHtml.closeHtmlTag("div");
        this.attributes.put("content", zooHtml.toString());
    }
}
