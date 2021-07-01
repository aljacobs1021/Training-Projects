/*  ROOMS: Foyer, library, apothecary, kitchen, bedroom, living room, bathroom
    OBTAINABLE ITEMS: key, rosemary*, lavender*
    INSPECTABLE ITEMS: bookshelf, apothecary herbs, pot of soup, garden plants
*/
package game;

// import fixtures.Fixture;
// import fixtures.Room;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    private static ArrayList<String> commands;

    public static void main(String[] args) {

        System.out.println("You arrive home, weary from day's work");
        System.out.println("Unfortunately, you still have work to do. Tour your home to find out more.");
        System.out.println("Your commands are: " + commands(commands));
    }

    public static ArrayList<String> commands(ArrayList<String> commands) {
        ArrayList<String> com = new ArrayList<String>();
        com.add("go");
        com.add("inspect");
        com.add("collect");
        com.add("use");
        return commands;
    }
}
