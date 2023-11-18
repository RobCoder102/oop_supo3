package uk.ac.cam.rd722.cyber_pet;

public interface UI {
    public void displayMessage(String msg);
    public int petSelector(CyberPetList pets);
    public boolean getYesNo(String question);
    public int selectOption(String msg, String[] options);
    public String getString(String msg);
    public int getInteger(String msg);
    public void displayPets(CyberPetList pets);
    public void interactWith(CyberPet pet);
}
