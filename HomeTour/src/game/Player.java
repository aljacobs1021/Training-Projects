package src.game;

import src.fixtures.Room;

public class Player {
    private Room currentRoom;

    public void setCR(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getCR() {
        return currentRoom;
    }
}
