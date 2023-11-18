package uk.ac.cam.rd722.cyber_pet;

public class Fish extends CyberPet {
    @Override
    public void sleep(UI ui) {
        double sleepTime = ui.getInteger("How many minutes should " + getName() + " sleep for?");
        sleep = Math.min(1.0, sleep+sleepTime/120);
        food -= sleepTime/600;
        play -= sleepTime/600;
        checkForDeath();
        if (!alive) ui.displayMessage("Oops... " + getName() + " might have slept a little too long...");
    }

    @Override
    public void feed(UI ui) {
        ui.displayMessage(getName() + " eats the tasty fish food");
        food = 1.0;
    }

    @Override
    public void play(UI ui) {
        if (Math.random() > 0.5) {
            ui.displayMessage(getName() + " loved your game");
            play = 1.0;
        } else {
            ui.displayMessage("Your game made no sense to " + getName());
            play = Math.min(1.0, play+0.01);
        };
    }

    @Override
    public String getSpeciesName() {
        return "Fish";
    }
}
