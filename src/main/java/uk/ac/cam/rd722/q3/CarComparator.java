package uk.ac.cam.rd722.q3;

import java.util.ArrayList;
import java.util.Comparator;

public class CarComparator implements Comparator<Car> {
    public int compare(Car x, Car y) {
        int manufacturerCompare = x.getManufacturer().compareTo(y.getManufacturer());
        if (manufacturerCompare == 0) return Integer.compare(x.getAge(), y.getAge());
        else return manufacturerCompare;
    }

    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car("Volkswagen", 60));
        cars.add(new Car("Ford", 12));
        cars.add(new Car("Volkswagen", 6));
        cars.add(new Car("Audi", 30));
        cars.add(new Car("Ford", 3));
        cars.sort(new CarComparator());
        for (Car c : cars) System.out.println(c.getDetails());
    }
}
