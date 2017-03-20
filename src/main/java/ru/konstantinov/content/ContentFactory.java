package ru.konstantinov.content;

import ru.konstantinov.content.page.ZooPageContent;

/**
 * Фабрика контента
 */
final public class ContentFactory {

    private ContentFactory() {
    }

    public static ConstructContent getContentInstance(ContentType type) {
        switch (type) {
            case ZOO_PAGE:
                return new ZooPageContent();
            default:
                throw new IllegalArgumentException("Неизвестный тип контента");
        }
    }
}
