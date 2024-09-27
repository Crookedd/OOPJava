package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OddEvenSeparator {
    private List<Integer> numbers;

    public OddEvenSeparator() {
        numbers = new ArrayList<>();
    }

    public void addNumber(int number) {
        numbers.add(number);
    }

    public void even() {
        System.out.print("Чётные числа:");
        for (int number : numbers) {
            if (number % 2 == 0) {
                System.out.print(" " + number);
            }
        }
    }

    public void odd() {
        System.out.print(" Нечётные числа:");
        for (int number : numbers) {
            if (number % 2 != 0) {
                System.out.print(" " + number);
            }
        }
    }

    public static void main(String[] args) {
        OddEvenSeparator separator = new OddEvenSeparator();
        separator.addNumber(1);
        separator.addNumber(2);
        separator.addNumber(3);
        separator.addNumber(4);
        separator.addNumber(5);
        separator.even();
        separator.odd();
    }
}