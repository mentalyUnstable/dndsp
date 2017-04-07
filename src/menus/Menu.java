package dndsp.menus;

import java.util.LinkedList;

import dndsp.util.Input;
import dndsp.util.Command;
import dndsp.util.Util;

/**
     * @author mentalyUnstable/DarkSun
     * @description used as an inherited base for making menus
     */
public class Menu{
    
    protected LinkedList<String> options;
    protected String title;
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return Menu
     * @description Makes a menu
     * @param String title title of the menu
     * @param LinkedList<String> options the options in the menu
     */
    public Menu(String title, LinkedList<String> options){
        this.options = options;
        this.title = title;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return Menu
     * @description used for testing
     */
    public Menu(){
        options = new LinkedList<String>();
        title = "Menu";
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return int users choice
     * @description displays a menu and gets user input
     */
    public int display(){
        return pdisplay();
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return int users choice
     * @description displays a menu and gets user input, protected for use with inherited classes
     */
    protected int pdisplay(){
        while(true){
            Util.cls();
            System.out.println(title+"\n");
            for(int i = 0; i < options.size(); i++)
                System.out.println("["+(i+1)+"]: "+options.get(i));
            System.out.print(">>>");
            String in = Input.getInput();
            if(in.length() > 1 &&in.charAt(0) == '/'){
                String[] parts = (in.substring(1, in.length()-1)).split(" ");
                Command.run(parts);
            }
            else{
                return (Util.tryParseInt(in)==null)?-1:Util.tryParseInt(in)-1;
            }
        }
    }
    
}