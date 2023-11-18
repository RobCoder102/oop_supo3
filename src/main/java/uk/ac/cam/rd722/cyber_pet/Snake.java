package uk.ac.cam.rd722.cyber_pet;

public class Snake extends CyberPet {

    public String getSpeciesName() {

        return "Snake";
    }

    public void sleep(UI ui) {
        ui.displayMessage("You put "+getName()+" to sleep... hisszzzz....");
        sleep = 1.0;
    }
    public void feed(UI ui) {
        ui.displayMessage("You feed "+getName()+" a mouse... tasty!");
        food = Math.min(1.0, food+0.6);
    }
    public void play(UI ui) {
        ui.displayMessage("You let "+getName()+" slither along the obstacle course.");
        sleep -= 0.2;
        food -= 0.2;
        play = Math.min(1.0, play+Math.random());
    }
    Snake() {
        super();
    }
}
