package org.example;

public class Button {
    private int clickCount;

    public Button() {
        this.clickCount = 0;
    }

    public void click() {
        clickCount++;
        System.out.println("Количество нажатий: " + clickCount);
    }

    public int getClickCount() {
        return clickCount;
    }

    public static void main(String[] args) {
        Button button = new Button();

        // Демонстрация работы кнопки
        button.click(); // 1
        button.click(); // 2
        button.click(); // 3

        // Проверка количества нажатий
        System.out.println("Общее количество нажатий: " + button.getClickCount());
    }
}
