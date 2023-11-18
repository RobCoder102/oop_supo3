package uk.ac.cam.rd722.cyber_pet;

public abstract class CyberPet {

    public boolean isAlive() {
        return alive;
    }

    protected boolean alive = true;

    public String getCauseOfDeath() {
        return causeOfDeath;
    }

    protected String causeOfDeath = "";

    public double getSleep() {
        return sleep;
    }

    public double getFood() {
        return food;
    }

    public double getPlay() {
        return play;
    }

    protected double sleep = 1.0;
    protected double food = 1.0;
    protected double play = 1.0;
    private String name;

    public abstract void sleep(UI ui);
    public abstract void feed(UI ui);
    public abstract void play(UI ui);

    // designed to be overridden by each CyberPet as each of them will react to time differently
    // default behaviour: decrease all needs
    public void timeElapsed(long ms) {
        sleep -= ms/100000.0;
        food -= ms/100000.0;
        play -= ms/100000.0;
    }

    public void checkForDeath() {
        if (food < 0) {
            alive = false;
            causeOfDeath = "Starvation";
        } else if (sleep < 0) {
            alive = false;
            causeOfDeath = "Sleep deprivation";
        } else if (play < 0) {
            alive = false;
            causeOfDeath = "Boredom";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public abstract String getSpeciesName();

    public String summaryString() {
        return name + " (" + getSpeciesName() + ")";
    }

}
