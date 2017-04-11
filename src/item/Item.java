package dndsp.item;

/**
     * @author mentalyUnstable/DarkSun
     * @description Item base
     */
public class Item{
    
    /**
     * @author mentalyUnstable/DarkSun
     * @description contains meta data for the item
     */
    private class ItemMeta{
        public ItemMeta(){
            name="Empty";
            value=0;
            maxStack=0;
        }
        String name;
        int value;
        int maxStack;
        int count;
    }
    
    private ItemMeta meta;
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return Item
     * @description returns an "Empty" item
     */
    public Item(){
        meta = new ItemMeta();
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return Item
     * @description returns an item, used to be inherited from
     * @param String name name of item
     * @param int value how much the item is worth
     * @param int maxStack how many can fit in one item slot
     * @param int count how many are in the stack
     */
    protected Item(String name, int value, int maxStack, int count){
        meta = new ItemMeta();
        meta.name = name;
        meta.value=value;
        meta.maxStack = maxStack;
        meta.count = count;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return ItemMeta
     * @description gets meta data for the item
     */
    public ItemMeta getItemMeta(){
        return meta;
    }
    
    /**
    * @author mentalyUnstable/DarkSun
    * @return number of item in the stack
    * @description gets how many are in the stack
    */
    public int getCount(){
        return meta.count;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return String
     * @description gets the name of the item
     */
    public String getName(){
        return meta.name;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return int
     * @description gets the value of the item
     */
    public int getValue(){
        return meta.value;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return int
     * @description gets how many fit in one item slot
     */
    public int getMaxStack(){
        return meta.maxStack;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return String
     * @description used for printing items 
     */
    public String toString(){
        String s = "";
        s += "Name: "+meta.name+", ";
        s += "Value: "+meta.value+", ";
        s += "Count: "+meta.count+"\n";
        return s;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return void
     * @description prints debug info about the item
     */
    public void printInfo(){
        System.out.println("Name: "+meta.name);
        if(meta.name.equalsIgnoreCase("Empty")) return;
        System.out.println("\tCount: "+meta.count);
        System.out.println("\tValue: "+meta.value);
        System.out.println("\tMax Stack: "+meta.maxStack);
    }
}