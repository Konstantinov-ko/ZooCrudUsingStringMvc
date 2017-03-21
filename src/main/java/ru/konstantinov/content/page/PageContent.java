package ru.konstantinov.content.page;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Asus on 20.03.2017.
 */
abstract class PageContent implements ConstructContent {
    String view;
    Map<String, String> attributes = new HashMap<String, String>();

    PageContent() {
        constructAttributes();
        constructContent();
    }

    public Set<Map.Entry<String, String>> getAttributes() {
        return attributes.entrySet();
    }

    public String getAttribute(String key) {
        return attributes.get(key);
    }

    public String getView() {
        return view;
    }

    abstract void constructAttributes();

    abstract void constructContent();
}
