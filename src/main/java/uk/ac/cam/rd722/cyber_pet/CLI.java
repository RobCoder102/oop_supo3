package uk.ac.cam.rd722.cyber_pet;

import java.util.Scanner;

public class CLI implements UI {
    private final Scanner sc;

    private static final int HOUSE_WIDTH = 5;

    public static String strInBox(String str, int width) {
        if (str.length() > width) return str.substring(0, width-1) + ".";
        int space = width - str.length();
        int lspace = space/2;
        int rspace = space - lspace;
        return " ".repeat(lspace) + str + " ".repeat(rspace);
    }

    public String getNeedBar(double value, int width) {
        double size = value*width;
        int fullSize = (int) Math.ceil(size-1);
        String result = "█".repeat(fullSize);
        size -= fullSize;
        if (size > 0.8) result += "█";
        else if (size > 0.6) result += "▓";
        else if (size > 0.4) result += "▒";
        else if (size > 0.2) result += "░";
        else result += " ";
        result += " ".repeat(width-1-fullSize);
        return result;
    }

    public String[] getThumbnail(CyberPet pet, int petNo) {
        String[] result = new String[16];
        result[0] = "┏" + "━".repeat(14) + "┓";
        result[1] = "┃ " + strInBox(pet.getName(), 12) + " ┃";
        result[2] = "┃ (" + strInBox(pet.getSpeciesName(), 10) + ") ┃";
        result[14] = "┃" + strInBox(String.valueOf(petNo), 14) + "┃";
        result[15] = "┗" + "━".repeat(14) + "┛";
        for (int i = 3; i < 14; i++) result[i] = "┃" + " ".repeat(14) + "┃";
        if (!pet.isAlive()) {
            result[8] = "┃"+strInBox("DEAD",14)+"┃";
            result[9] = "┃"+strInBox("("+pet.getCauseOfDeath()+")", 14)+"┃";
        } else {
            result[4] = "┃"+strInBox("FOOD", 14) + "┃";
            result[5] = "┃ "+getNeedBar(pet.getFood(), 12)+" ┃";
            result[7] = "┃"+strInBox("SLEEP", 14) + "┃";
            result[8] = "┃ "+getNeedBar(pet.getSleep(), 12)+" ┃";
            result[10] = "┃"+strInBox("PLAY", 14) + "┃";
            result[11] = "┃ "+getNeedBar(pet.getPlay(), 12)+" ┃";
        }

        return result;
    }

    @Override
    public void displayPets(CyberPetList pets) {
        for (int y = 0; y < pets.size(); y += HOUSE_WIDTH) {
            String[] lines = new String[16];
            for (int i = 0; i < 16; i++) lines[i] = "";
            for (int x = 0; x < HOUSE_WIDTH && x+y < pets.size(); x++) {
                CyberPet p = pets.get(x+y);
                String[] thumbnail = getThumbnail(p, x+y+1);
                for (int i = 0; i < 16; i++) lines[i] = lines[i] + thumbnail[i];
            }
            for (int i = 0; i < 16; i++) System.out.println(lines[i]);
        }
    }

    @Override
    public void interactWith(CyberPet pet) {
        switch (selectOption("What would you like to do?", new String[] {
                "Feed " + pet.getName(),
                "Play with " + pet.getName(),
                "Put " + pet.getName() + " to sleep"
        })) {
            case 0: pet.feed(this); break;
            case 1: pet.play(this); break;
            case 2: pet.sleep(this); break;
        }
    }

    @Override
    public void displayMessage(String msg) {
        System.out.println(msg);
    }

    @Override
    public int petSelector(CyberPetList pets) {
        if (pets.isEmpty()) throw new RuntimeException("Cannot select from empty pets");
        int numWidth = (int)Math.log10(pets.size()) + 1;
        for (int i = 0; i < pets.size(); i++) {
            System.out.println(" ".repeat(numWidth-String.valueOf(i+1).length())+(i+1)+") " + pets.get(i).summaryString());
        }
        int choice = sc.nextInt();
        sc.nextLine();
        return choice - 1;
    }

    @Override
    public boolean getYesNo(String question) {
        displayMessage(question + "(y/n)");
        String choice = sc.nextLine().toLowerCase();
        return choice.equals("y");
    }


    @Override
    public int selectOption(String msg, String[] options) {
        if (options.length == 0) throw new RuntimeException("Cannot select from no options");
        System.out.println(msg);
        int numWidth = (int)Math.log10(options.length) + 1;
        for (int i = 0; i < options.length; i++) {
            System.out.println(" ".repeat(numWidth-String.valueOf(i+1).length()) + (i+1) + ") " + options[i]);
        }
        int choice = sc.nextInt();
        sc.nextLine();
        return choice - 1;
    }

    @Override
    public String getString(String msg) {
        System.out.println(msg);
        return sc.nextLine();
    }

    @Override
    public int getInteger(String msg) {
        System.out.println(msg);
        int n = sc.nextInt();
        sc.nextLine();
        return n;
    }

    CLI() {
        sc = new Scanner(System.in);
    }
}
