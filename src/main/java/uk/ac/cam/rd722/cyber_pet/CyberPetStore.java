package uk.ac.cam.rd722.cyber_pet;

public class CyberPetStore {
    public CyberPet getFromStore(UI ui) {
        // get species
        int option = ui.selectOption("What pet would you like? You can get:", new String[] {
                "Snake",
                "Ninja",
                "Fish"
        });
        CyberPet newPet = switch (option) {
            case 0 -> new Snake();
            case 1 -> new Ninja();
            case 2 -> new Fish();
            default -> null;
        };
        if (newPet == null) return null;
        String name = ui.getString("What name would you like to give your pet?");
        newPet.setName(name);
        return newPet;
    }
}
