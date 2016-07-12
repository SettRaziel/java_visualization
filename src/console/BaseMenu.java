package console;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Parent class for simple console menus
 * @author Benjamin Held (07-12-2015)
 * @since 07-12-2016
 * @version 0.1.0
 */
public abstract class BaseMenu {

    /**
     * The head line of the menu
     */
    String title;
    /**
     * storage for the menu items and its related value
     */
    HashMap<Integer, String> menuItems;

    public BaseMenu() {
        this("Default Menu: Please set a title");
    }

    public BaseMenu(String title) {
        this.title = title;
        menuItems = new HashMap<>();
        defineMenuItems();
    }

    /**
     * public method to print the menu and wait for the user to provide input
     */
    public void printMenuAndAwaitInput() {
        System.out.println(title);
        for (Integer i: menuItems.keySet()) {
            System.out.println("(" + i + ") " + menuItems.get(i));
        }

        boolean hasFinished = false;
        while (!hasFinished) {
            hasFinished = determineAction(getInput("Input: "));
        }
    }

    /**
     * filles the {@link HashMap} with the menu items
     * @param index the key value specifying the index of the item
     * @param description the value specifying the description of the item
     */
    void addMenuItem(int index, String description) {
        this.menuItems.put(index, description);
    }

    /**
     * method to print the given message and read the input
     * @param message the message before the input prompt
     * @return the input of the user
     */
    private String getInput(String message) {
        Scanner console = new Scanner(System.in);
        System.out.print(message);
        return console.nextLine();
    }

    /**
     * abstract method to define all available menu items
     */
    abstract void defineMenuItems();

    /**
     * abstract method to map actions based on the provided input
     * @param input the provided input
     */
    abstract boolean determineAction(String input);
}