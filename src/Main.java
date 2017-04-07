import dndsp.world.*;
import dndsp.invs.*;
import dndsp.util.*;
import dndsp.item.*;
import dndsp.menus.*;

import java.util.UUID;
import java.util.LinkedList;

public class Main{
    
    public static void init(){
        Rand.init();
        Input.init();
    }
    
    public static void main(String[] args){
        init();
        
        MainMenu mm = new MainMenu();
        if(mm.display() == 1){
            World world = new WorldGenerator(30, 100, 0.1, 1.0, 1.0, 1.0).create();
            world.printMap();
        }
    }
    
}