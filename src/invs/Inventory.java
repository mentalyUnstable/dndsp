package dndsp.invs;

import dndsp.item.Item;
import java.util.UUID;

/**
 * @author mentalyUnstable/DarkSun
 */
public class Inventory{
    
    private int size;
    
    private UUID owner;
    private Item[] items;
    
    /**
     * @param UUID ownerUUID who owns the inventory
     * @param int size how many slots are in it
     */
    public Inventory(UUID ownerUUID, int size){
        this.size = size;
        owner = ownerUUID;
        
        items = new Item[size];
        for(int i = 0; i < items.length; i++)
            items[i] = new Item();
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return int
     * @description gets the size of the inventory
     */
    public int getSize(){
        return size;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return Item
     * @description gets an item at index
     * @param int index 
     */
    public Item getItem(int index){
        return items[index];
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return Item[]
     * @description gets all items in inventory
     */
    public Item[] getItems(){
        return items;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return void
     * @description sets what item is at index
     * @param Item item what item to set
     * @param int index at what index
     */
    public void set(Item item, int index){
        items[index] = item;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return UUID
     * @description gets uuid of the owner
     */
    public UUID getOwnerUUID(){
        return owner;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return void
     * @description prints info about object
     */
    public void printInfo(){
        System.out.println("Inventory ("+owner+"):");
        for(Item i : items)
            i.printInfo();
    }
}