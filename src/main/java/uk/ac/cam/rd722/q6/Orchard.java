package uk.ac.cam.rd722.q6;

import java.util.ArrayList;
import java.util.List;

public class Orchard {
    List<FruitTree> trees;
    public void addTree(FruitTree tree) {
        trees.add(tree);
    }
    public List<Fruit> getHarvest() {
        List<Fruit> harvest = new ArrayList<Fruit>();
        for (FruitTree t : trees) {
            harvest.addAll(t.getHarvest());
        }
        return harvest;
    }
    public Orchard() {
        trees = new ArrayList<FruitTree>();
    }

    public static void main(String[] args) {
        Orchard myOrchard = new Orchard();
        myOrchard.addTree(new AppleTree(0.7));
        myOrchard.addTree(new BananaTree(0.75));
        myOrchard.addTree(new AppleTree(0.9));
        myOrchard.addTree(new BananaTree(0.85));

        List<Fruit> harvest = myOrchard.getHarvest();
        for (Fruit f : harvest) {
            System.out.println(f.getDescription());
        }
    }
}
