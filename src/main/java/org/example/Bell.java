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

    public static void main(String[] args) {
        Bell bell = new Bell();

        // Пример использования
        for (int i = 0; i < 10; i++) {
            bell.sound();
        }
    }
}
