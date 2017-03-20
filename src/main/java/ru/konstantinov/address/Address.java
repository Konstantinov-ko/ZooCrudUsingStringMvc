package ru.konstantinov.address;

import ru.konstantinov.html.HtmlTagWrapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Asus on 16.03.2017.
 */
public class Address implements Serializable {
    private final String city;
    private final String street;
    private final String house;

    private final List<Underground> undergroundList = new ArrayList<Underground>();

    public Address(String city, String street, String house) {
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public Address(String city, String street, String house, Underground[] underground) {
        this.city = city;
        this.street = street;
        this.house = house;
        undergroundList.addAll(Arrays.asList(underground));
    }

    public void setUndergroundList(Underground underground) {
        undergroundList.add(underground);
    }

    public Underground[] getUndergroundList() {
        return (Underground[]) undergroundList.toArray();
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getAddressHtml() {
        HtmlTagWrapper htmlBlock = new HtmlTagWrapper();

        htmlBlock.openHtmlTag("address");

        htmlBlock.appendTagWrapper("strong", getCity());
        htmlBlock.appendHtml("<br />");
        htmlBlock.appendText(getStreet());
        htmlBlock.appendText(", ");
        htmlBlock.appendText("дом ");
        htmlBlock.appendText(getHouse());
        for (Underground underground : undergroundList) htmlBlock.appendHtml(underground.getUndergroundHtml());

        htmlBlock.closeHtmlTag("address");

        return htmlBlock.toString();
    }

    @Override
    public String toString() {
        return getCity();
    }
}
