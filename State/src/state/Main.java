package state;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter character name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            name = "Hero";
        }

        GameCharacter character = new GameCharacter(name);
        System.out.println("Welcome, " + character.getName() + ". Begin your journey.");

        boolean quit = false;
        while (!quit && !character.isMaster()) {
            showStatus(character);
            List<Action> actions = character.getState().getAvailableActions();
            quit = !promptForAction(scanner, actions, character);
        }

        if (character.isMaster()) {
            showStatus(character);
            System.out.println("You have reached the Master level. Game over.");
        } else {
            System.out.println("Goodbye.");
        }
    }

    private static void showStatus(GameCharacter character) {
        System.out.println("\n--- Status ---");
        System.out.println("Name: " + character.getName());
        System.out.println("Level: " + character.getLevelName());
        System.out.println("Exp: " + character.getExperience());
        System.out.println("Health: " + character.getHealth());
    }

    private static boolean promptForAction(Scanner scanner, List<Action> actions, GameCharacter character) {
        System.out.println("Available actions:");
        int index = 1;
        for (Action action : actions) {
            System.out.println(index + ") " + action.getLabel());
            index++;
        }
        System.out.println(index + ") " + Action.QUIT.getLabel());

        System.out.print("Choose an action: ");
        String input = scanner.nextLine().trim();
        int choice;
        try {
            choice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice.");
            return true;
        }

        if (choice == index) {
            return false;
        }

        if (choice < 1 || choice > actions.size()) {
            System.out.println("Invalid choice.");
            return true;
        }

        Action selected = actions.get(choice - 1);
        performAction(selected, character);
        return true;
    }

    private static void performAction(Action action, GameCharacter character) {
        switch (action) {
            case TRAIN -> character.train();
            case MEDITATE -> character.meditate();
            case FIGHT -> character.fight();
            default -> System.out.println("Nothing happens.");
        }
    }
}
