package uk.ac.cam.rd722.q7;

public class Circle extends Ellipse {
    private double radius;

    Circle(double radius) {
        super(radius, radius);
        this.radius = radius;
    }

    public void stretch(double factor) {
        radius *= factor;
    }

    @Override
    public void stretchMajor(double factor) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void stretchMinor(double factor) {
        throw new UnsupportedOperationException();
    }
}
