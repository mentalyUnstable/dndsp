package dndsp.menus;

import dndsp.util.Input;
import dndsp.util.Util;
import dndsp.util.Changelog;

public class MainMenu extends Menu{
    
    public MainMenu(){
        super();
        options.add("New Game");
        options.add("View Changelog");
        options.add("Exit");
        title = "Main Menu";
    }
    
    @Override
    public int display(){
        while(true){
            switch(pdisplay()){
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