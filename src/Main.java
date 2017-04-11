import dndsp.world.*;
import dndsp.invs.*;
import dndsp.util.*;
import dndsp.item.*;
import dndsp.menus.*;

import java.util.UUID;
import java.util.LinkedList;

/**
     * @author mentalyUnstable/DarkSun
     * @description start of program
     */
public class Main{
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return void
     * @description runs init functions of other classes, sets up the game
     */
    public static void init(){
        Rand.init();
        Input.init();
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return void
     * @description starts the game
     */
    public static void main(String[] args){
        init();
        
        MainMenu mm = new MainMenu();
        int choice = mm.display();
        if(choice == 1){
            World world = new WorldGenerator(30, 100, 0.1, 1.0, 1.0, 1.0).create();
            world.printMap();
        }
        else if(choice == 2){
            Util.cls();
            int c = Util.tryParseInt(Input.prompt("Dice Count: "));
            int s = Util.tryParseInt(Input.prompt("Dice Sides: "));
            int m = Util.tryParseInt(Input.prompt("Modifier: "));
            int rc = Util.tryParseInt(Input.prompt("Roll Count: "));
            for(int i = 0; i < rc; i++){
                System.out.println(Dice.roll(c,s,m));
            }
            System.out.println("\nPress [ENTER] to continue.");
            Input.getInput();
        }
        
    }
    
}