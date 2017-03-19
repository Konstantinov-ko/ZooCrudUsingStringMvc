package ru.konstantinov.html;

/**
 * HTML tag wrapper
 *
 * @author Konstantinov
 * @version 1.0
 * @since 1.0
 */
public class HtmlTagWrapper {
    private StringBuilder htmlBlock;

    public HtmlTagWrapper(String htmlBlock) {
        this.htmlBlock = new StringBuilder(htmlBlock);
    }

    public HtmlTagWrapper() {
        this.htmlBlock = new StringBuilder();
    }

    public void appendText(String htmlBlock) {
        this.htmlBlock.append(htmlBlock);
    }

    public void appendHtml(String htmlBlock) {
        this.htmlBlock.append(htmlBlock);
    }

    public void insertHtml(String htmlBlock) {
        this.htmlBlock.insert(0, htmlBlock);
    }

    public void openHtmlTag(String tag, String className) {
        htmlBlock.append("<").append(tag).append(" class=\"").append(className).append("\"").append(">");
    }

    public void openHtmlTag(String tag) {
        htmlBlock.append("<").append(tag).append(">");
    }

    public void closeHtmlTag(String tag) {
        htmlBlock.append("</").append(tag).append(">");
    }

    public void appendTagWrapper(String tag, String text) {
        if (text != null) {
            openHtmlTag(tag);
            appendText(text);
            closeHtmlTag(tag);
        }
    }

    @Override
    public String toString() {
        return htmlBlock.toString();
    }
}
