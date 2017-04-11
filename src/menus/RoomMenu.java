package dndsp.menus;

import dndsp.world.Room;

public class RoomMenu extends Menu{
    
    /**
     * Creates a menu for the player while in a room.
     * 
     * @param room The room to make a menu for.
     */
    public RoomMenu(Room room){
        super.title = room.getRoomType().getName();
    }
    
}