package uk.ac.cam.rd722.q6;

import java.util.ArrayList;
import java.util.List;

public abstract class FruitTree {
    private final double quality;
    abstract protected Fruit getFruit();
    public List<Fruit> getHarvest() {
        List<Fruit> harvest = new ArrayList<Fruit>();
        while (Math.random() < quality) {
            harvest.add(getFruit());
        }
        return harvest;
    }

    public FruitTree(double quality) {
        this.quality = quality;
    }
}
