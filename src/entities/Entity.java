package dndsp.entities;

import dndsp.invs.Inventory;
import dndsp.world.Room;

import java.util.UUID;

public class Entity{
    
    private class EntityMeta{
        public EntityMeta(){
            health = 0;
            money = 0;
            level = 0;
            exp = 0;
            uuid = UUID.randomUUID();
            inventory = new Inventory(uuid,10);
        }
        public UUID uuid;
        public int health;
        public int money;
        public int level;
        public int exp;
        public Room room;
        
        public Inventory inventory;
    }
    
    private EntityMeta meta;
    
    protected Entity(){
        meta = new EntityMeta();
    }
    
    public void printInfo(){
        
    }
    
    public void setRoom(Room room){
        meta.room = room;
    }
    
    public Room getRoom(){
        return meta.room;
    }
    
}