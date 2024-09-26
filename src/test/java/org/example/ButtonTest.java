package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ButtonTest {
    private Button button;

    @BeforeEach
    public void setUp() {
        button = new Button();
    }

    @Test
    public void testInitialClickCount() {
        // Проверяем, что начальное количество нажатий равно 0
        assertEquals(0, button.getClickCount());
    }

    @Test
    public void testClickIncreasesCount() {
        // Проверяем, что количество нажатий увеличивается после каждого клика
        button.click();
        assertEquals(1, button.getClickCount());

        button.click();
        assertEquals(2, button.getClickCount());

        button.click();
        assertEquals(3, button.getClickCount());
    }

    @Test
    public void testMultipleClicks() {
        // Проверяем общее количество нажатий после нескольких кликов
        for (int i = 0; i < 5; i++) {
            button.click();
        }
        assertEquals(5, button.getClickCount());
    }
}