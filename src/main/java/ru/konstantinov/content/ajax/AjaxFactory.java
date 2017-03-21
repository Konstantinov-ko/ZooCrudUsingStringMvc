package ru.konstantinov.content.ajax;

/**
 * Created by Asus on 21.03.2017.
 */
public final class AjaxFactory {
    private AjaxFactory() {
    }

    public static AjaxAction getAjaxInstance(AjaxType type, int zoo_id) {
        switch (type) {
            case REMOVE_ZOO:
                return new Removing(zoo_id);
            default:
                throw new IllegalArgumentException("Неизвестный тип контента");
        }
    }
}
