package geometry3d;

import Exceptions.InvalidDimensionException;
import geometry2d.Figure;

public class Cylinder {
    private final Figure base; // Основание цилиндра
    private final double height; // Высота цилиндра

    public Cylinder(Figure base, double height) {
        if (base == null) {
            throw new InvalidDimensionException("Основание не может быть нулевым.");
        }
        if (height <= 0) {
            throw new InvalidDimensionException("Высота должна быть положительным числом.");
        }
        this.base = base;
        this.height = height;
    }

    public double volume() {
        return base.area() * height; // Объем = площадь основания * высота
    }

    @Override
    public String toString() {
        return base + " и высота: " + height;
    }
}
