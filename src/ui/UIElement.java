package ui;

import de.ur.mi.oop.colors.Color;

public class UIElement {

    private final int xPosition;
    private final int yPosition;

    public UIElement(int x, int y, int width, int height, Color backgroundColor) {
        this.xPosition = x;
        this.yPosition = y;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void draw() {
    }

    public void handleMouseClick(int x, int y) {

    }

}
