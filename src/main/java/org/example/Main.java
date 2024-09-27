package org.example;

import Exceptions.FigureNotSupportedException;
import geometry2d.Circle;
import geometry2d.Rectangle;
import geometry3d.Cylinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

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
}


