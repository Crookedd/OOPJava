package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalanceTest {
    private Balance balance;

    @BeforeEach
    public void setUp() {
        balance = new Balance();
    }

    @Test
    public void testInitialBalance() {
        assertEquals("=", balance.getResult());
    }

    @Test
    public void testAddLeft() {
        balance.addLeft(5);
        balance.addRight(3);
        assertEquals("L", balance.getResult());
    }

    @Test
    public void testAddRight() {
        balance.addRight(2);
        assertEquals("R", balance.getResult());
    }

    @Test
    public void testEqualWeights() {
        balance.addLeft(5);
        balance.addRight(5);
        assertEquals("=", balance.getResult());
    }

    @Test
    public void testMultipleOperations() {
        balance.addLeft(10);
        balance.addRight(5);
        assertEquals("L", balance.getResult());

        balance.addRight(5);
        assertEquals("=", balance.getResult());

        balance.reset();
        balance.addLeft(7);
        balance.addRight(10);
        assertEquals("R", balance.getResult());
    }
}