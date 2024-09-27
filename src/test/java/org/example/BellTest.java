package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class BellTest {
    private Bell bell;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        bell = new Bell();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testSound() {
        // Вызываем метод sound 10 раз
        for (int i = 0; i < 10; i++) {
            bell.sound();
        }

        // Ожидаемый вывод
        String expectedOutput = "ding\ndong\nding\ndong\nding\ndong\nding\ndong\nding\ndong";
        String actualOutput = outputStreamCaptor.toString().trim(); // Убираем лишние пробелы и переносы

        // Сравнение строк без скрытых символов
        String cleanExpected = expectedOutput.replaceAll("[^\\x20-\\x7E]", "");
        String cleanActual = actualOutput.replaceAll("[^\\x20-\\x7E]", "");
        assertEquals(cleanExpected, cleanActual);
    }
}