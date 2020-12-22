package ui.scenes;

import ui.InputEventTarget;
import ui.UIElement;

import java.util.ArrayList;

public class BaseScene implements InputEventTarget {

    private ArrayList<UIElement> elements;

    public BaseScene() {
        elements = new ArrayList<>();
    }

    public void addElement(UIElement element) {
        elements.add(element);
    }

    public void start() {

    }

    public void pause() {

    }

    public void update() {
        for(UIElement element: elements) {
            element.update();
        }
    }

    public void draw() {
        for(UIElement element: elements) {
            element.draw();
        }
    }

    public void handleMouseClick(int x, int y) {
        for(UIElement element: elements) {
            element.handleMouseClick(x, y);
        }
    }

    public void handleKeyPressed(int keyCode) {
        for(UIElement element: elements) {
            element.handleKeyPressed(keyCode);
        }
    }

}
