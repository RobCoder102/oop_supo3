package uk.ac.cam.rd722.cyber_pet;

import java.util.ArrayList;

public class CyberPetList extends ArrayList<CyberPet> {
    long lastUpdated;

    public void updatePets() {
        long currentTime = System.currentTimeMillis();
        long timeDiff = currentTime - lastUpdated;
        lastUpdated = currentTime;
        if (timeDiff <= 0) return; // possible due to clocks changing etc.
        for (CyberPet pet : this) {
            if (!pet.isAlive()) continue;
            pet.timeElapsed(timeDiff);
            if (pet.isAlive()) pet.checkForDeath();
        }
    }

    CyberPetList() {
        lastUpdated = System.currentTimeMillis();
    }
}
