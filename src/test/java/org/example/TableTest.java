package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TableTest {
    private Table table;

    @BeforeEach
    public void setUp() {
        // Создание таблицы 2x2 перед каждым тестом
        table = new Table(2, 2);
    }

    @Test
    public void testInitialValues() {
        // Проверка, что значения по умолчанию равны 0
        assertEquals(0, table.getValue(0, 0));
        assertEquals(0, table.getValue(0, 1));
        assertEquals(0, table.getValue(1, 0));
        assertEquals(0, table.getValue(1, 1));
    }

    @Test
    public void testSetValueAndGetValue() {
        // Установка значений и проверка их корректности
        table.setValue(0, 0, 5);
        table.setValue(1, 1, 10);
        assertEquals(5, table.getValue(0, 0));
        assertEquals(10, table.getValue(1, 1));
    }

    @Test
    public void testAverage() {
        // Установка значений и проверка среднего арифметического
        table.setValue(0, 0, 4);
        table.setValue(0, 1, 6);
        table.setValue(1, 0, 8);
        table.setValue(1, 1, 2);
        assertEquals(5.0, table.average(), 0.001);
    }

    @Test
    public void testToString() {
        // Проверка корректности строкового представления таблицы
        table.setValue(0, 0, 1);
        table.setValue(0, 1, 2);
        table.setValue(1, 0, 3);
        table.setValue(1, 1, 4);
        String expectedOutput = "1 2\n3 4\n";
        assertEquals(expectedOutput, table.toString());
    }

    @Test
    public void testRowsAndCols() {
        // Проверка количества строк и столбцов
        assertEquals(2, table.rows());
        assertEquals(2, table.cols());
    }
}