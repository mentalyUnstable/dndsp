package dndsp.world;

import dndsp.util.Rand;
import dndsp.invs.Inventory;
import dndsp.entities.Entity;
import dndsp.util.Direction;

import java.util.LinkedList;

/**
     * @author mentalyUnstable/DarkSun
     * @description a room
     */
public class Room{
    
    /**
     * @author mentalyUnstable/DarkSun
     * @description what type of room is it
     */
    public enum RoomType{
        FOREST,
        THICK_FOREST,
        BUILDING,
        PLAINS,
        DUNGEON
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @description contains meta data for the room
     */
    public class RoomMeta{
        
        public RoomMeta(){
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
        
        public boolean[] doors;
        public boolean enterable;
        public int x;
        public int y;
        public RoomType roomType;
        public Inventory chest;
        public Entity[] npcs;
        public Entity[] mobs;
        public LinkedList<Entity> playerParty;
    }
    
    private RoomMeta meta;
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return Room
     * @description creates a blank room
     */
    public Room(){
        meta=new RoomMeta();
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return RoomMeta
     * @description gets the room meta
     */
    public RoomMeta getMeta(){
        return meta;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return boolean
     * @description isenterable
     */
    public boolean isEnterable(){
        return meta.enterable;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return boolean[]
     * @description gets the list of doors
     */
    public boolean[] getDoors(){
        return meta.doors;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return Inventory
     * @description gets the chest that is in the room
     */
    public Inventory getChest(){
        return meta.chest;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return boolean
     * @description does the room have a chest
     */
    public boolean hasChest(){
        return (meta.chest!=null);
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return int
     * @description gets the column of the room
     */
    public int getX(){
        return meta.x;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return int
     * @description gets the row of the room
     */
    public int getY(){
        return meta.y;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return RoomType
     * @description gets room type
     */
    public RoomType getType(){
        return meta.roomType;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return Entity[]
     * @description gets the npcs in the room
     */
    public Entity[] getNPCs(){
        return meta.npcs;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return Entity[]
     * @description gets the hostile entities in the room
     */
    public Entity[] getMobs(){
        return meta.mobs;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return void
     * @description sets the players party in this room
     */
    public void setPlayerParty(LinkedList<Entity> pp){
        meta.playerParty = pp;
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
        return meta.playerParty;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return boolean
     * @description does this room contain the player
     */
    public boolean hasPlayer(){
        return (meta.playerParty!=null);
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return void
     * @description prints debug info
     */
    public void printInfo(){
        System.out.println("Room:");
        System.out.println("X: "+meta.x);
        System.out.println("Y: "+meta.y);
        System.out.println("Type: "+meta.roomType);
        System.out.println("Enterable: "+meta.enterable);
        System.out.println("Doors:");
        for(int d : Direction.DIRECTIONS)
            System.out.println("\t"+d+": "+meta.doors[d]);
        System.out.println("NPCs:\n");
        for(Entity e : meta.npcs)
            e.printInfo();
        System.out.println("Mobs:\n");
        for(Entity e : meta.mobs)
            e.printInfo();
        System.out.println("Player Party:\n");
        for(Entity e : meta.playerParty)
            e.printInfo();
        System.out.println("Chest: "+(meta.chest!=null));
        if(meta.chest!=null)
            meta.chest.printInfo();
    }
}