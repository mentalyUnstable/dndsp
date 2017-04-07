package dndsp.item;

/**
     * @author mentalyUnstable/DarkSun
     * @description Contains all normal items in the game
     */
public class Items{
    
    public static class Gold extends Item{
        public Gold(int count){
            super("Gold", 1, 1000000000, count);
        }
    }
    
    public static class Rock extends Item{
        public Rock(int count){
            super("Rock", 0, 5, count);
        }
    }
    
}