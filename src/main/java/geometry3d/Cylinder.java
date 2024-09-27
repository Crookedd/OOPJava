package geometry3d;

import Exceptions.InvalidDimensionException;
import geometry2d.Figure;

public class Cylinder {
    private Figure base; // Основание цилиндра
    private double height; // Высота цилиндра

    public Cylinder(Figure base, double height) {
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
        return base.toString() + " и высота: " + height;
    }
}
