package dndsp.world;

import dndsp.entities.Entity;
import dndsp.util.Util;
import dndsp.util.Rand;

import java.util.LinkedList;
import java.util.UUID;

/**
     * @author mentalyUnstable/DarkSun
     * @description the world that contains the game
     */
public class World{
    
    private UUID uuid;
    private static LinkedList<Entity> entities;
    private LinkedList<Entity> playerParty;
    private Room[][] rooms;
    private int rows;
    private int cols;
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return World
     * @description creates a world
     * @param UUID uuid world uuis
     * @param int rows
     * @param int cols
     */
    public World(UUID uuid, int rows, int cols){
        this.uuid = uuid;
        rooms = new Room[rows][cols];
        for(Room r[] : rooms)
            for(Room room : r)
                room = new Room();
        entities = new LinkedList<Entity>();
        playerParty = new LinkedList<Entity>();
        this.rows = rows;
        this.cols = cols;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return UUID
     * @description get world uuid
     */
    public UUID getUUID(){
        return uuid;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return LinkedList<Entities>
     * @description returns all entities in the game
     */
    public LinkedList<Entity> getEntities(){
        return entities;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return Room[][]
     * @description returns all the rooms in the world
     */
    public Room[][] getRooms(){
        return rooms;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return void
     * @description sets the rooms to the param
     * @param Room[][] rooms
     */
    public void setRooms(Room[][] rooms){
        this.rooms = rooms;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return void
     * @description prints a map of the world in ascii
     */
    public void printMap(){
        Util.cls();
        for(Room[] r : rooms){
            for(Room room : r){
                if(room.getMeta().enterable){
                    System.out.print(" ");
                }
                else{
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return void
     * @description prints debug info
     */
    public void printInfo(){
        System.out.println("World("+uuid+"):");
        for(Room[] r : rooms){
            for(Room room : r){
                room.printInfo();
            }
        }
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return boolean
     * @description tries to place the player in a random room in the room
     */
    public boolean placePlayerRandom(){
        boolean tryagain = true;
        int tries = 0;
        while(tryagain){
            tries++;
            if(tries > 1000)
                return false;
            int x = Rand.getInt(0, cols);
            int y = Rand.getInt(0, rows);
            if(placePlayer(x, y))
                return true;
        }
        return true;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return boolean
     * @description 
     */
    public boolean placePlayer(int x, int y){
        if(rooms[y][x].getMeta().enterable){
            rooms[y][x].setPlayerParty(playerParty);
            return true;
        }
        return false;
    }
}