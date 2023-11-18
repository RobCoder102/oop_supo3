package uk.ac.cam.rd722.q7;

public class Ellipse {
    private double semiMinorAxis;
    private double semiMajorAxis;

    Ellipse(double semiMinor, double semiMajor) {
        semiMinorAxis = semiMinor;
        semiMajorAxis = semiMajor;
    }

    public void stretchMajor(double factor) {
        semiMajorAxis *= factor;
    }

    public void stretchMinor(double factor) {
        semiMinorAxis *= factor;
    }
}
