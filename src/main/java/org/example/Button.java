package org.example;

public class Button {
    private int clickCount;

    public void click() {
        clickCount++;
        System.out.println("Количество нажатий: " + clickCount);
    }

    public int getClickCount() {
        return clickCount;
    }
}
