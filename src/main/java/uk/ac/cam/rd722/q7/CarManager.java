package uk.ac.cam.rd722.q7;

public class CarManager {
    public Car constructCar() {
        return new Car();
    }
    public void startCar(Car c) {
        c.start();
    }

    public static void main(String[] args) {
        // no poltergeist
        Car myCar = new Car();
        myCar.start();

        // with poltergeist
        CarManager myCarManager = new CarManager();
        Car myCar2 = myCarManager.constructCar();
        myCarManager.startCar(myCar2);
    }
}
