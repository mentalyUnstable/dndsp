package dndsp.util;

import dndsp.world.World;
import dndsp.entities.Entity;
import dndsp.entities.Player;

/**
     * @author mentalyUnstable/DarkSun
     * @description for when someone runs a debug command
     */
public class Command{
    
    private static World world;
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return void
     * @description initilizes the Command class
     * @param World world the world you are playing in
     */
    public static void init(World w){
        world = w;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return void
     * @description runs a command
     */
    public static void run(String[] args){
        
    }
    
}