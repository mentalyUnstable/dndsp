package dndsp.world;

import dndsp.util.Rand;
import dndsp.invs.Inventory;
import dndsp.entities.Entity;
import dndsp.util.Direction;

import java.util.LinkedList;

public class Room{
    
    public enum RoomType{
        FOREST,
        THICK_FOREST,
        BUILDING,
        PLAINS,
        DUNGEON
    }
    
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
    
    public Room(){
        meta=new RoomMeta();
    }
    
    public RoomMeta getMeta(){
        return meta;
    }
    
    public boolean isEnterable(){
        return meta.enterable;
    }
    
    public boolean[] getDoors(){
        return meta.doors;
    }
    
    public Inventory getChest(){
        return meta.chest;
    }
    
    public boolean hasChest(){
        return (meta.chest!=null);
    }
    
    public int getX(){
        return meta.x;
    }
    
    public int getY(){
        return meta.y;
    }
    
    public RoomType getType(){
        return meta.roomType;
    }
    
    public Entity[] getNPCs(){
        return meta.npcs;
    }
    
    public Entity[] getMobs(){
        return meta.mobs;
    }
    
    public void setPlayerParty(LinkedList<Entity> pp){
        meta.playerParty = pp;
        for(Entity e : pp){
            e.setRoom(this);
        }
    }
    
    public LinkedList<Entity> getPlayerParty(){
        return meta.playerParty;
    }
    
    public boolean hasPlayer(){
        return (meta.playerParty!=null);
    }
    
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