package org.example;

public class Bell {
    private boolean isDing;
    public Bell() {
        isDing = true; // Начинаем с "ding"
    }

    public void sound() {
        if (isDing) {
            System.out.println("ding");
        } else {
            System.out.println("dong");
        }
        isDing = !isDing; // Переключаем состояние
    }
}
