package ru.konstantinov.zoo;

import ru.konstantinov.html.HtmlTagWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 16.03.2017.
 */
public class ZooService {
    private final List<Zoo> zooList = new ArrayList<Zoo>();

    public void setZooList(List<Zoo> zooList) {
        this.zooList.addAll(zooList);
    }

    public String getZooHtml() {
        HtmlTagWrapper htmlBlock = new HtmlTagWrapper();

        htmlBlock.openHtmlTag("div", "container");

        htmlBlock.openHtmlTag("div", "blog-header");
        htmlBlock.openHtmlTag("h1", "blog-title");
        htmlBlock.appendText("Список зоопарков");
        htmlBlock.closeHtmlTag("h1");
        htmlBlock.closeHtmlTag("div");

        for (Zoo zoo : zooList) {
            htmlBlock.openHtmlTag("div", "row");
            htmlBlock.openHtmlTag("div", "col-sm-8 blog-main");
            htmlBlock.appendHtml(zoo.getZooHtml());
            htmlBlock.closeHtmlTag("div");
            htmlBlock.closeHtmlTag("div");
        }

        htmlBlock.closeHtmlTag("div");

        return htmlBlock.toString();
    }
}
