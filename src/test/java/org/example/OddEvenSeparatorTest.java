package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class OddEvenSeparatorTest {
    private OddEvenSeparator separator;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        separator = new  OddEvenSeparator();
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    public void testEvenNumbers() {
        PrintStream originalOut = System.out;

        separator.addNumber(1);
        separator.addNumber(2);
        separator.addNumber(3);
        separator.addNumber(4);
        separator.addNumber(5);

        separator.even();

        assertEquals("Чётные числа: 2 4", outputStreamCaptor.toString());

        System.setOut(originalOut);
    }

    @Test
    public void testOddNumbers() {

        PrintStream originalOut = System.out;

        separator.addNumber(1);
        separator.addNumber(2);
        separator.addNumber(3);
        separator.addNumber(4);
        separator.addNumber(5);

        separator.odd();

        assertEquals(" Нечётные числа: 1 3 5", outputStreamCaptor.toString());

        System.setOut(originalOut);
    }
}