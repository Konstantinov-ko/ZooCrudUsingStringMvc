package ru.konstantinov.content.page;

/**
 * Фабрика контента
 */
public final class ContentFactory {

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
