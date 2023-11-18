package uk.ac.cam.rd722.q1;

public class StaticExample {
    private static String sName = "Static Steve (s1)";
    private String mName = "Non-static Noah (m1)";
    private static int totalNameChanges = 0;

    public static String getSName() {
        // return static variable
        return sName;
    }
    public static void setSName(String newName) {
        // modify static variable
        sName = newName;
        // modify another static variable
        totalNameChanges++;
    }
    public String getMName() {
        // return instance variable
        return mName;
    }
    public void setMName(String newName) {
        // modify instance variable
        mName = newName;
        // modify static variable
        totalNameChanges++;
    }

    public void getDetails() {
        System.out.println("Instance name: " + mName);
        System.out.println("Static name: " + sName);
        System.out.println("Total name change count: " + totalNameChanges);
    }

    public static void main(String[] args) {
        StaticExample ex1 = new StaticExample();
        StaticExample ex2 = new StaticExample();
        System.out.println("ex1:");
        ex1.getDetails();
        System.out.println("ex2:");
        ex2.getDetails();
        System.out.println("-- ex1 instance name change --");
        ex1.setMName("Non-static Nobby (m2)");
        System.out.println("ex1:");
        ex1.getDetails();
        System.out.println("ex2:");
        ex2.getDetails();
        System.out.println("-- ex2 static name change --");
        ex2.setSName("Static Simon (s2)");
        // equivalent to StaticExample.setSName(...)
        System.out.println("ex1:");
        ex1.getDetails();
        System.out.println("ex2:");
        ex2.getDetails();
    }
}
