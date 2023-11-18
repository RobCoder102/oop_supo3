package uk.ac.cam.rd722.q6;

public class AppleTree extends FruitTree {
    public AppleTree(double quality) {
        super(quality);
    }

    @Override
    protected Fruit getFruit() {
        return new Apple();
    }
}
