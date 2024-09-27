package org.example;

import Exceptions.FigureNotSupportedException;
import Exceptions.InvalidDimensionException;
import geometry2d.Circle;
import geometry2d.Rectangle;
import geometry3d.Cylinder;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FigureTest {

    @Test
    public void testCircle() {
        try {
            Circle circle = new Circle(5);
            assertEquals(78.53981633974483, circle.area(), 0.0001);
            assertEquals("Радиус: 5.0", circle.toString());
        } catch (IllegalArgumentException e) {
            fail("Исключение не должно быть выброшено");
        }

        assertThrows(IllegalArgumentException.class, () -> new Circle(0));
        assertThrows(IllegalArgumentException.class, () -> new Circle(-1));
    }

    @Test
    public void testReactagle() {
        Rectangle rectangle = new Rectangle(4, 6);
        assertEquals(24, rectangle.area());
        assertEquals("Прямоугольник: ширина - 4.0 высота - 6.0", rectangle.toString());

        assertThrows(FigureNotSupportedException.class, () -> new Rectangle(0, 5));
        assertThrows(FigureNotSupportedException.class, () -> new Rectangle(4, -1));
    }

    @Test
    public void testCylinder() {
        Circle circleBase = new Circle(3);
        Cylinder cylinder = new Cylinder(circleBase, 5);
        assertEquals(141.3716694115407, cylinder.volume(), 0.01);
        assertEquals("Радиус: 3.0 и высота: 5.0", cylinder.toString());

        // Изменяем ожидаемое исключение на InvalidDimensionException
        assertThrows(InvalidDimensionException.class, () -> new Cylinder(circleBase, -1));
    }

}