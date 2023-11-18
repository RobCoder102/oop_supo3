package uk.ac.cam.rd722.cyber_pet;

public class Ninja extends CyberPet {

    @Override
    public void sleep(UI ui) {
        ui.displayMessage("A ninja never rests...");
    }

    @Override
    public void feed(UI ui) {
        ui.displayMessage("You feed " + getName() + " some tasty ninja snacks.");
        food = 1.0;
    }

    @Override
    public void play(UI ui) {
        ui.displayMessage("The ninja issues you a challenge - you must guess his number!");
        int num = (int)(100*Math.random())+1;
        int guess = -1;
        int guesses = 5;
        while (guesses > 0 && guess != num) {
            System.out.println("You have " + guesses + " guesses left.");
            guess = ui.getInteger("Enter a number:");
            if (guess > num) ui.displayMessage(getName() + " says \"too high\"");
            if (guess < num) ui.displayMessage(getName() + " says \"too low\"");
            guesses--;
        }
        if (guess == num) {
            ui.displayMessage(getName() + " is impressed with your skill...");
            food = 1.0;
            play = 1.0;
        } else {
            ui.displayMessage("The number was " + num);
            ui.displayMessage(getName() + " is disappointed... but it was still entertaining");
            play = 1.0;
            food -= 0.1;
        }
    }

    @Override
    public void timeElapsed(long ms) {
        // no sleep decay
        food -= ms/200000.0;
        play -= ms/80000.0;
        // chance to get assassinated
        if (Math.pow(0.5, ms/1000.0) < 0.1) {
            alive = false;
            causeOfDeath = "Assassinated";
        }
    }

    @Override
    public String getSpeciesName() {
        return "Ninja";
    }
}
