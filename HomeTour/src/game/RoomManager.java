// CONTAINS: Room definitions, Room to exit assignments
// DOES: What kind of rooms exist 

package src.game;

import src.fixtures.Room;

public class RoomManager {
        Room startingRoom;
        private Room rooms[] = new Room[8];
        Room foy, kit, lib, lr, apoth, gar, bed, bath;

        public void init() {

                // specify deets
                foy = new Room("The Foyer", "a small foyer",
                                "The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen."
                                                + "\n"
                                                + "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor."
                                                + "\n" + "To the north is a small room, where you can see a piano.");
                kit = new Room("The Foyer", "a small foyer",
                                "The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen."
                                                + "\n"
                                                + "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor."
                                                + "\n" + "To the north is a small room, where you can see a piano.");
                lib = new Room("The Foyer", "a small foyer",
                                "The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen."
                                                + "\n"
                                                + "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor."
                                                + "\n" + "To the north is a small room, where you can see a piano.");
                lr = new Room("The Foyer", "a small foyer",
                                "The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen."
                                                + "\n"
                                                + "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor."
                                                + "\n" + "To the north is a small room, where you can see a piano.");
                apoth = new Room("The Foyer", "a small foyer",
                                "The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen."
                                                + "\n"
                                                + "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor."
                                                + "\n" + "To the north is a small room, where you can see a piano.");
                gar = new Room("The Foyer", "a small foyer",
                                "The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen."
                                                + "\n"
                                                + "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor."
                                                + "\n" + "To the north is a small room, where you can see a piano.");
                bed = new Room("The Foyer", "a small foyer",
                                "The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen."
                                                + "\n"
                                                + "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor."
                                                + "\n" + "To the north is a small room, where you can see a piano.");
                bath = new Room("The Foyer", "a small foyer",
                                "The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen."
                                                + "\n"
                                                + "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor."
                                                + "\n" + "To the north is a small room, where you can see a piano.");

                foy.setExits(lr, null, null, lib);
                lr.setExits(gar, null, foy, kit);
                gar.setExits(null, null, lr, null);
                kit.setExits(bed, lr, lib, apoth);
                bed.setExits(null, null, kit, bath);
                bath.setExits(null, bed, null, null);
                apoth.setExits(null, kit, null, null);
                lib.setExits(kit, foy, null, null);
                // add objects to startingRoom and Rooms
                setSR(foy);

                // create room objects
                this.rooms[0] = foy;
                this.rooms[1] = lr;
                this.rooms[2] = gar;
                this.rooms[3] = kit;
                this.rooms[4] = bed;
                this.rooms[5] = bath;
                this.rooms[6] = apoth;
                this.rooms[7] = lib;

        }

        public void setSR(Room startingRoom) {
                this.startingRoom = startingRoom;
        }

        public Room getSR() {
                return startingRoom;
        }

        public Room[] getRM() {
                return rooms;
        }

        public void setRM(Room[] room) {
                this.rooms = room;
        }
}
