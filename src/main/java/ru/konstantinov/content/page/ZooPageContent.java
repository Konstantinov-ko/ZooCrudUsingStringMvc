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

        Map<Integer, Zoo> zooList = new BaseAction().getAll();
        zooHtml.openHtmlTag("div", "row");

        for (Map.Entry<Integer, Zoo> zooEntry : zooList.entrySet()) {

            zooHtml.openHtmlTag("div", "col-md-6 col-lg-4");
            zooHtml.openHtmlTag("div", "row zoo-container", "id", String.valueOf(zooEntry.getKey()));
            zooHtml.openHtmlTag("div", "col-md-12");
            zooHtml.appendHtml(zooEntry.getValue().getZooHtml());
            zooHtml.closeHtmlTag("div");

            zooHtml.openHtmlTag("div", "col-md-12");
            zooHtml.openHtmlTag("div", "btn-group btn-group-justified");
            zooHtml.openHtmlTag("div", "btn-group");
            zooHtml.openHtmlTag("button", "btn btn-danger remove-zoo");
            zooHtml.appendText("Удалить");
            zooHtml.closeHtmlTag("button");
            zooHtml.closeHtmlTag("div");
            zooHtml.openHtmlTag("div", "btn-group");
            zooHtml.openHtmlTag("button", "btn btn-info");
            zooHtml.appendText("Редактировать");
            zooHtml.closeHtmlTag("button");
            zooHtml.closeHtmlTag("div");


            zooHtml.closeHtmlTag("div");
            zooHtml.closeHtmlTag("div");

            zooHtml.closeHtmlTag("div");
            zooHtml.closeHtmlTag("div");
        }
        zooHtml.closeHtmlTag("div");
        this.attributes.put("content", zooHtml.toString());
    }
}
