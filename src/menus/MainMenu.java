package dndsp.menus;

import dndsp.util.Input;
import dndsp.util.Util;
import dndsp.util.Changelog;

/**
     * @author mentalyUnstable/DarkSun
     * @description The main menu of the game
     */
public class MainMenu extends Menu{
    
    public MainMenu(){
        super();
        options.add("New Game");
        options.add("View Changelog");
        options.add("Exit");
        title = "Main Menu";
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return int
     * @description displays menu and returns the choice users choice. returns -1 if an invalid choice is made
     */
    @Override
    public int display(){
        while(true){
            switch(pdisplay()){
                case -1:
                    Util.system("clear","");
                    System.out.println("Please make a valid selection!");
                    Util.system("sleep", "3");
                    break;
                case 0:
                    return 1;
                case 1:
                    Changelog.display();
                    break;
                case 2:
                    return 0;
            }
        }
    }
    
}