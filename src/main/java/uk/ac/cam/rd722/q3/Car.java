package uk.ac.cam.rd722.q3;

public class Car {
    public String getManufacturer() {
        return manufacturer;
    }

    public int getAge() {
        return age;
    }

    private String manufacturer;
    private int age;

    Car(String manufacturer, int age) {
        this.manufacturer = manufacturer;
        this.age = age;
    }

    public String getDetails() {
        return manufacturer + ", " + age + " years old";
    }
}
