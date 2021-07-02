//CONTAINS: Basic rooms, Exits
//DOES: 

package src.fixtures;

public class Room extends Fixtures {
    private Room[] exits;

    public Room() {

    }

    public void deBug() {
        System.out.println(getName());
    }

    // constructor with name and descriptions, plus assigning exits a value
    public Room(String name, String shortDesc, String longDesc) {
        super(name, shortDesc, longDesc);
        this.exits = new Room[4];
    }

    public Room[] getExits() {
        return this.exits;
    }

    public void setExits(Room north, Room east, Room south, Room west) {
        this.exits[0] = north;
        this.exits[1] = east;
        this.exits[2] = south;
        this.exits[3] = west;
    }

    public Room getExits(String direction) {
        switch (direction) {
            case "north":
                return exits[0];
            case "east":
                return exits[1];
            case "south":
                return exits[2];
            case "west":
                return exits[3];
            default:
                return null;
        }
    }

    /*
     * public void setRooms(Room foy, Room kit, Room lib, Room lr, Room apoth, Room
     * gar, Room bed, Room bath) { this.foy = foy; this.kit = kit; this.lib = lib;
     * this.lr = lr; this.apoth = apoth; this.gar = gar; this.bed = bed; this.bath =
     * bath; }
     */
}
