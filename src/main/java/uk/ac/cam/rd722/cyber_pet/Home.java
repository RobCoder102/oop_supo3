package uk.ac.cam.rd722.cyber_pet;

public class Home {
    private CyberPetList pets = new CyberPetList();

    private CyberPetStore store = new CyberPetStore();
    private UI ui;


    public void homeLoop() {
        // 0 -> view
        // 1 -> interact
        // 2 -> get another
        // 3 -> remove pet
        // 4 -> quit
        ui.displayMessage("Welcome to your CyberPet home!");
        while (true) {
            int option = ui.selectOption("What would you like to do?", new String[]{
                    "View your CyberPets",
                    "Interact with a CyberPet",
                    "Get another CyberPet",
                    "Remove a CyberPet",
                    "Quit"
            });
            if (option == 0) viewPets();
            if (option == 1) interactPet();
            if (option == 2) getPet();
            if (option == 3) removePet();
            if (option == 4) return;
        }
    }

    private void viewPets() {
        if (pets.isEmpty()) ui.displayMessage("You have no CyberPets!");
        pets.updatePets();
        ui.displayPets(pets);
    }

    private void interactPet() {
        if (pets.isEmpty()) {
            ui.displayMessage("You have no CyberPets!");
            return;
        }
        pets.updatePets();
        ui.displayMessage("Which pet do you want to interact with?");
        CyberPet pet = pets.get(ui.petSelector(pets));
        if (!pet.isAlive()) {
            ui.displayMessage(pet.getName() + " is unavailable (RIP)");
            return;
        }
        ui.interactWith(pet);
    }

    private void getPet() {
        CyberPet newPet = store.getFromStore(ui);
        pets.updatePets();
        if (newPet != null) pets.add(newPet);
    }

    private void removePet() {
        if (pets.isEmpty()) {
            ui.displayMessage("You have no CyberPets!");
            return;
        }
        int petIndex = ui.petSelector(pets);
        CyberPet petToRemove = pets.get(petIndex);
        if (ui.getYesNo("Are you sure you want to get rid of " + petToRemove.summaryString() + "?")) {
            ui.displayMessage("Goodbye " + petToRemove.getName() + "!");
            pets.remove(petIndex);
        }
    }

    Home() {
        ui = new CLI();
    }

    public static void main(String[] args) {
        Home home = new Home();
        //home.pets.add(new CyberPet("Davidaniningo", "Snake"));

        home.homeLoop();
    }
}
