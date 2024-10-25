package geometry3d;

import Exceptions.InvalidDimensionException;
import geometry2d.Circle;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CylinderTest {
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