package org.example;

import Exceptions.FigureNotSupportedException;
import geometry2d.Circle;
import geometry2d.Rectangle;
import geometry3d.Cylinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.Table.safeNextInt;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите задачу 1-6");

        int taskNumber = scanner.nextInt();
        switch (taskNumber) {
            case 1:
                Button button = new Button();

                button.click(); // 1
                button.click(); // 2
                button.click(); // 3

                System.out.println("Общее количество нажатий: " + button.getClickCount());
                break;
            case 2:
                Balance balance = new Balance();
                // Пример использования
                balance.addLeft(5);
                System.out.println(balance.result()); // L
                balance.addRight(5);
                System.out.println(balance.result()); // =
                balance.reset();
                System.out.println(balance.result()); // =
                balance.addLeft(5);
                System.out.println(balance.result()); // L
                balance.addRight(2);
                System.out.println(balance.result()); // L
                balance.reset();
                System.out.println(balance.result()); // =
                break;
            case 3:
                Bell bell = new Bell();

                // Пример использования
                for (int i = 0; i < 10; i++) {
                    bell.sound();
                }
                break;
            case 4:
                OddEvenSeparator separator = new OddEvenSeparator();
                separator.addNumber(1);
                separator.addNumber(2);
                separator.addNumber(3);
                separator.addNumber(4);
                separator.addNumber(5);
                separator.even();
                separator.odd();
                break;
            case 5:
                SeparatorEven();
                break;
            case 6:
                Geometric();
                break;
            default:
                System.out.println("Неверный выбор. Пожалуйста, выберите 1, 2 или 3.");
        }
        scanner.close();

    }

    private static void Geometric() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите задачу:");
        System.out.println("1. Площадь круга");
        System.out.println("2. Площадь прямоугольника");
        System.out.println("3. Объем цилиндра");

        int taskNumber = scanner.nextInt();
        switch (taskNumber) {
            case 1:
                System.out.print("Введите радиус круга: ");
                double radius =scanner.nextDouble();

                try {
                    Circle circle = new Circle(radius);
                    System.out.println(circle);
                    System.out.println("Площадь круга: " + circle.area());
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
                break;
            case 2:
                // Ввод сторон прямоугольника
                System.out.print("Введите ширину прямоугольника: ");
                double width = scanner.nextDouble();
                System.out.print("Введите высоту прямоугольника: ");
                double height = scanner.nextDouble();

                try {
                    Rectangle rectangle = new Rectangle(width, height);
                    System.out.println(rectangle);
                    System.out.println("Площадь прямоугольника: " + rectangle.area());
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
                break;
            case 3:
                System.out.print("Введите радиус круга для основания цилиндра: ");
                double radiusCylinder = scanner.nextDouble();

                Circle circleBase = new Circle(radiusCylinder);

                // Ввод высоты цилиндра
                System.out.print("Введите высоту цилиндра: ");
                double heightCylinder = scanner.nextDouble();

                try {
                    Cylinder cylinder = new Cylinder(circleBase, heightCylinder);
                    System.out.println(cylinder);
                    System.out.println("Объем цилиндра: " + cylinder.volume());
                } catch (FigureNotSupportedException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Неверный выбор. Пожалуйста, выберите 1, 2 или 3.");
        }
        scanner.close();
    }

    public static void SeparatorEven() {
        Scanner scanner = new Scanner(System.in);

        // Запрос размеров таблицы у пользователя
        System.out.print("Введите количество строк: ");
        int rows = safeNextInt(scanner);
        System.out.print("Введите количество столбцов: ");
        int cols = safeNextInt(scanner);

        Table table = new Table(rows, cols);

        for (int i = 0; i < table.rows(); i++) {
            for (int j = 0; j < table.cols(); j++) {
                System.out.printf("Введите значение для ячейки [%d][%d]: ", i, j);
                int value = safeNextInt(scanner);
                table.setValue(i, j, value);
            }
        }

        // Вывод таблицы и среднего арифметического

        System.out.printf("Таблица [%d x %d]:\n", table.rows(), table.cols());
        System.out.println(table);
        System.out.println("Среднее: " + table.average());

        System.out.printf("Значение в ячейке [1][1]: %d\n", table.getValue(1, 1));

        scanner.close();
    }

}


