package uk.ac.cam.rd722.q6;

public class BananaTree extends FruitTree {
    public BananaTree(double quality) {
        super(quality);
    }

    @Override
    protected Fruit getFruit() {
        return new Banana();
    }
}
