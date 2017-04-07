package dndsp.invs;

import dndsp.item.Item;
import java.util.UUID;

public class Inventory{
    
    private int size;
    
    private UUID owner;
    private Item[] items;
    
    public Inventory(UUID ownerUUID, int size){
        this.size = size;
        owner = ownerUUID;
        
        items = new Item[size];
        for(int i = 0; i < items.length; i++)
            items[i] = new Item();
    }
    
    public int getSize(){
        return size;
    }
    
    public Item getItem(int index){
        return items[index];
    }
    
    public Item[] getItems(){
        return items;
    }
    
    public void set(Item item, int index){
        items[index] = item;
    }
    
    public UUID getOwnerUUID(){
        return owner;
    }
    
    public void printInfo(){
        System.out.println("Inventory ("+owner+"):");
        for(Item i : items)
            i.printInfo();
    }
}