package ru.konstantinov.zoo;

import ru.konstantinov.address.Address;
import ru.konstantinov.html.HtmlTagWrapper;

/**
 * Created by Asus on 16.03.2017.
 */
public class Zoo {
    private final String name;
    private final Address address;

    public Zoo(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getZooHtml() {
        HtmlTagWrapper htmlBlock = new HtmlTagWrapper();

        htmlBlock.appendTagWrapper("h2", getName());
        htmlBlock.appendHtml(address.getAddressHtml());

        return htmlBlock.toString();
    }

    @Override
    public String toString() {
        return name;
    }
}
