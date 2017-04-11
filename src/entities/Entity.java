package dndsp.entities;

import dndsp.invs.Inventory;
import dndsp.world.Room;

import java.util.UUID;

/**
 * @author mentalyUnstable/DarkSun
 * Base for all entities.
*/
public class Entity{
    
    /**
     * @author mentalyUnstable/DarkSun
     * Contains all meta data for the entity class
     */
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
    
    /**
     * @author mentalyUnstable/DarkSun
     * Prints info the object
     * @return void
     */
    public void printInfo(){
        
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @returns void
     * @param room The room the entities is in
     * Sets the current room the entity is in
     */
    public void setRoom(Room room){
        meta.room = room;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @returns Room
     * Gets the current room the entity is in
     */
    public Room getRoom(){
        return meta.room;
    }
    
}