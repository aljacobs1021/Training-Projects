/*  ROOMS: Foyer, library, apothecary, kitchen, bedroom, living room, bathroom
    OBTAINABLE ITEMS*: key*, rosemary*, lavender*
    INSPECTABLE ITEMS: bookshelf, hearth/fireplace, apothecary herbs*, pot of soup*, garden plants*, kitchen sink*, bed*
    COMMANDS: go, inspect, use*, quit, collect*

    *may not be able to implement 

*/
package src.game;

// import fixtures.Fixture;
// import fixtures.Room;
import java.util.Scanner;

import src.fixtures.Room;

// import java.util.List;
// import java.util.ListIterator;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.Iterator;
// import java.util.Map;

public class Main {
    // static ArrayList<String> com = new ArrayList<String>();
    static String commands;
    static Scanner input = new Scanner(System.in);
    static Player player = new Player();
    static Room rooms = new Room();
    static RoomManager RM = new RoomManager();
    static Room currentRoom = RM.getSR();
    // static Room currentRoom = player.getCR();

    // static String[] cmdList = new String[5];

    public static void main(String[] args) {
        RM.init();
        player.setCR(RM.getSR());

        // program start and initial input
        System.out.println("-----------------------------------");
        System.out.println("Welcome to Home Tour!");
        // System.out.println("You arrive home, weary from the day's activities.");
        // System.out.println("Unfortunately, you still have work to do. Tour your home
        // to find out more.");
        System.out.println("-----------------------------------");
        System.out.println("Your commands are: ");
        returnCmd(args);
        System.out.println("");
        System.out.println("-----------------------------------");
        System.out.println(player.getCR().getName());
        System.out.println(player.getCR().getLD());
        System.out.println("-----------------------------------");
        // put do while loop here
        do {
            System.out.println("What would you like to do?");
            String[] s = colInput();
            System.out.println("-----------------------------------");
            parse(s, player);
        } while (colInput() != null);

    }

    public static String[] returnCmd(String[] sentence) {
        String[] commands = { "go", "inspect", "quit", "collect", "use" };

        for (int i = 0; i < commands.length; i++) {
            System.out.print("|" + commands[i] + "|");
        }
        return commands;
    }

    // collect input
    public static String[] colInput() {
        String sentence = input.nextLine();
        String[] words = sentence.split(" ");

        return words;

    }

    public static void printRM() {
        System.out.println("Your current room: " + player.getCR().getName());
        System.out.println(player.getCR().getLD());
    }

    // parse through the string of words in previous input
    public static void parse(String[] words, Player player) {
        String direction = words[1];
        // System.out.println(words[0] + words[1]);

        Room currentRoom = player.getCR();

        // Room nextRoom = currentRoom.getExits(direction);
        printRM();

        // System.out.println(words[0] == "go");
        if (words[0].equals("go")) {
            Room exit = currentRoom.getExits(direction);
            if (exit == null) {
                System.out.println("Please type a valid command, or type 'quit' to leave");
            } else {
                player.setCR(exit);
            }

        } else if (words[0].equals("quit")) {
            System.out.println("You leave the house.");
            System.exit(0);
        }

    }

}

/*
 * public static ArrayList<String> commands() { ArrayList<String> com = new
 * ArrayList<String>(); com.add("go"); com.add("inspect"); com.add("collect");
 * com.add("use"); return commands; }
 */

// public static String doSum(String string) {
// String doSum = input.nextLine();
// return doSum;
// }

// This adds and prints out commands
/*
 * public static ArrayList<String> returnCmd(ArrayList<String> string) {
 * com.add("go"); com.add("inspect"); com.add("collect"); com.add("use");
 * com.add("quit");
 * 
 * Iterator<String> cmd = com.iterator(); while (cmd.hasNext()) { String
 * commands = cmd.next(); System.out.print("|" + commands + "|"); }
 * 
 * return com;
 * 
 * public Map<String, String> returnCmd(String commands, String object) {
 * 
 * Map<String, String> heck; return heck; } }
 * 
 * 
 * if (player.getCR().getExits("north") != null) { System.out.println("North: "
 * + player.getCR().getExits("north").getSD()); } if
 * (player.getCR().getExits("south") != null) { System.out.println("South: " +
 * player.getCR().getExits("south").getSD()); } if
 * (player.getCR().getExits("east") != null) { System.out.println("East: " +
 * player.getCR().getExits("east").getSD()); } if
 * (player.getCR().getExits("west") != null) { System.out.println("West: " +
 * player.getCR().getExits("west").getSD()); }
 */
