package dndsp.item;

public class Item{
    
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
    
    public Item(){
        meta = new ItemMeta();
    }
    
    protected Item(String name, int value, int maxStack, int count){
        meta = new ItemMeta();
        meta.name = name;
        meta.value=value;
        meta.maxStack = maxStack;
        meta.count = count;
    }
    
    public ItemMeta getItemMeta(){
        return meta;
    }
    
    public int getCount(){
        return meta.count;
    }
    
    public String getName(){
        return meta.name;
    }
    
    public int getVaule(){
        return meta.value;
    }
    
    public int getMaxStack(){
        return meta.maxStack;
    }
    
    public String toString(){
        String s = "";
        s += "Name: "+meta.name+", ";
        s += "Value: "+meta.value+", ";
        s += "Max Stack: "+meta.maxStack+"\n";
        return s;
    }
    
    public void printInfo(){
        System.out.println("Name: "+meta.name);
        if(meta.name.equalsIgnoreCase("Empty")) return;
        System.out.println("\tCount: "+meta.count);
        System.out.println("\tValue: "+meta.value);
    }
}