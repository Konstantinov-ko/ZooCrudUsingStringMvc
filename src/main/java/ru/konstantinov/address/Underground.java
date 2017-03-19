package ru.konstantinov.address;

import ru.konstantinov.html.HtmlTagWrapper;

/**
 * Uderground class
 *
 * @author Konstantinov
 * @version 1.0
 * @since 1.0
 */
public class Underground {
    /**
     * @value name - The underground name
     */
    private final String name;
    /**
     * @value minutesToBuilding - Minutes to the underground building
     */
    private short minutesToBuilding;
    /**
     * @value metersToBuilding - Meters to the underground building
     */
    private short metersToBuilding;

    /**
     * Constructor
     *
     * @param name - The underground name
     */
    public Underground(String name) {
        this.name = name;
    }

    /**
     * Constructor
     *
     * @param name              - The underground name
     * @param minutesToBuilding - Minutes to the underground building
     */
    public Underground(String name, short minutesToBuilding) {
        this.name = name;
        this.minutesToBuilding = minutesToBuilding;
    }

    /**
     * Constructor
     *
     * @param name              - The underground name
     * @param minutesToBuilding - Minutes to the underground building
     * @param metersToBuilding  - Meters to the underground building
     */
    public Underground(String name, short minutesToBuilding, short metersToBuilding) {
        this.name = name;
        this.minutesToBuilding = minutesToBuilding;
        this.metersToBuilding = metersToBuilding;
    }

    public String getName() {
        return name;
    }

    public short getMinutesToBuilding() {
        return minutesToBuilding;
    }

    public short getMetersToBuilding() {
        return metersToBuilding;
    }

    public void setMinutesToBuilding(short minutesToBuilding) {
        this.minutesToBuilding = minutesToBuilding;
    }

    public void setMetersToBuilding(short metersToBuilding) {
        this.metersToBuilding = metersToBuilding;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Cтанция метро ");
        stringBuilder.append(name);

        appendToBuildingText(stringBuilder, minutesToBuilding, " минут пешком");
        appendToBuildingText(stringBuilder, metersToBuilding, " м до здания");

        return stringBuilder.toString();
    }

    /**
     * @param stringBuilder - row builder
     * @param value         - appending value
     * @param text          - text to append in row after the value
     */
    private void appendToBuildingText(StringBuilder stringBuilder, short value, String text) {
        if (value != 0) {
            stringBuilder.append(", ");
            stringBuilder.append(value);
            stringBuilder.append(text);
        }
    }

    public String getUndergroundHtml() {
        HtmlTagWrapper htmlTagWrapper = new HtmlTagWrapper();

        htmlTagWrapper.openHtmlTag("dl", "dl-horizontal");

        htmlTagWrapper.appendTagWrapper("dt", getName());
        htmlTagWrapper.appendTagWrapper("dd", getMinutesToBuilding() + " минут");
        htmlTagWrapper.appendTagWrapper("dd", getMetersToBuilding() + " метров");

        htmlTagWrapper.closeHtmlTag("dl");

        return htmlTagWrapper.toString();
    }
}
