package uk.ac.cam.rd722.q5;

public class SingletonExample {
    private int specialNumber;
    private static SingletonExample singleton;
    public static SingletonExample getSingleton() {
        if (singleton == null) singleton = new SingletonExample();
        return singleton;
    }
    private SingletonExample() {
        generateNewNumber();
    }
    private void generateNewNumber() {
        specialNumber = (int) (100*Math.random());
    }
    public int getSpecialNumber() {
        specialNumber *= 2;
        return specialNumber;
    }

    public static void main(String[] args) {
        SingletonExample a = SingletonExample.getSingleton();
        System.out.println(a.getSpecialNumber());
        SingletonExample b = SingletonExample.getSingleton();
        System.out.println(b.getSpecialNumber());
    }
}
