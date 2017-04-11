package dndsp.world;

import dndsp.util.Rand;
import dndsp.invs.Inventory;
import dndsp.entities.Entity;
import dndsp.util.Direction;

import java.util.LinkedList;

/**
     * @author mentalyUnstable/DarkSun
     * A room in the world.
     */
public class Room{
    
    /**
     * @author mentalyUnstable/DarkSun
     * What type of room is it
     */
    public enum RoomType{
        FOREST,
        THICK_FOREST,
        BUILDING,
        PLAINS,
        DUNGEON
    }
    
    private boolean[] doors;
    private boolean enterable;
    private int x;
    private int y;
    private RoomType roomType;
    private Inventory chest;
    private Entity[] npcs;
    private Entity[] mobs;
    private LinkedList<Entity> playerParty;
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return Room
     * Creates a blank room
     */
    public Room(){
        doors = new boolean[4];
        for(int i = 0; i < 4; i++)
            doors[i] = false;
        enterable = false;
        x=y=0;
        chest = null;
        npcs=mobs = new Entity[0];
        playerParty = new LinkedList<Entity>();
        roomType=RoomType.FOREST;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return boolean
     * @description isenterable
     */
    public boolean isEnterable(){
        return enterable;
    }
    
    public void setIsEnterable(boolean enter){
        this.enterable = enter;
    }
    
    public void setRoomType(RoomType rt){
        this.roomType = rt;
    }
    
    public void setDoor(int door, boolean isDoor){
        this.doors[door] = isDoor;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return boolean[]
     * @description gets the list of doors
     */
    public boolean[] getDoors(){
        return doors;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return Inventory
     * @description gets the chest that is in the room
     */
    public Inventory getChest(){
        return chest;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return boolean
     * @description does the room have a chest
     */
    public boolean hasChest(){
        return (chest!=null);
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return int
     * @description gets the column of the room
     */
    public int getX(){
        return x;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return int
     * @description gets the row of the room
     */
    public int getY(){
        return y;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return RoomType
     * @description gets room type
     */
    public RoomType getType(){
        return roomType;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return Entity[]
     * @description gets the npcs in the room
     */
    public Entity[] getNPCs(){
        return npcs;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return Entity[]
     * @description gets the hostile entities in the room
     */
    public Entity[] getMobs(){
        return mobs;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return void
     * @description sets the players party in this room
     */
    public void setPlayerParty(LinkedList<Entity> pp){
        playerParty = pp;
        for(Entity e : pp){
            e.setRoom(this);
        }
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return LinkedList<Entity>
     * @description gets the players party
     */
    public LinkedList<Entity> getPlayerParty(){
        return playerParty;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return boolean
     * @description does this room contain the player
     */
    public boolean hasPlayer(){
        return (playerParty!=null);
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return void
     * @description prints debug info
     */
    public void printInfo(){
        System.out.println("Room:");
        System.out.println("X: "+x);
        System.out.println("Y: "+y);
        System.out.println("Type: "+roomType);
        System.out.println("Enterable: "+enterable);
        System.out.println("Doors:");
        for(int d : Direction.DIRECTIONS)
            System.out.println("\t"+d+": "+doors[d]);
        System.out.println("NPCs:\n");
        for(Entity e : npcs)
            e.printInfo();
        System.out.println("Mobs:\n");
        for(Entity e : mobs)
            e.printInfo();
        System.out.println("Player Party:\n");
        for(Entity e : playerParty)
            e.printInfo();
        System.out.println("Chest: "+(chest!=null));
        if(chest!=null)
            chest.printInfo();
    }
}