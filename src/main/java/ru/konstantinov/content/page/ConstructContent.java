package ru.konstantinov.content.page;

import java.util.Map;
import java.util.Set;

/**
 * Created by Asus on 20.03.2017.
 */
public interface ConstructContent {
    Set<Map.Entry<String, String>> getAttributes();

    String getAttribute(String key);

    String getView();
}
