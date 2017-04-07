package dndsp.world;

import dndsp.entities.Entity;
import dndsp.util.Util;
import dndsp.util.Rand;

import java.util.LinkedList;
import java.util.UUID;

public class World{
    
    private UUID uuid;
    private static LinkedList<Entity> entities;
    private LinkedList<Entity> playerParty;
    private Room[][] rooms;
    private int rows;
    private int cols;
    
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
    
    public UUID getUUID(){
        return uuid;
    }
    
    public LinkedList<Entity> getEntities(){
        return entities;
    }
    
    public Room[][] getRooms(){
        return rooms;
    }
    
    public void setRooms(Room[][] rooms){
        this.rooms = rooms;
    }
    
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
    
    public void printInfo(){
        System.out.println("World("+uuid+"):");
        for(Room[] r : rooms){
            for(Room room : r){
                room.printInfo();
            }
        }
    }
    
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
    
    public boolean placePlayer(int x, int y){
        if(rooms[y][x].getMeta().enterable){
            rooms[y][x].setPlayerParty(playerParty);
            return true;
        }
        return false;
    }
}