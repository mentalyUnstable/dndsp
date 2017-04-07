package dndsp.menus;

import java.util.LinkedList;

import dndsp.util.Input;
import dndsp.util.Command;
import dndsp.util.Util;

public class Menu{
    
    protected LinkedList<String> options;
    protected String title;
    
    public Menu(String title, LinkedList<String> options){
        this.options = options;
        this.title = title;
    }
    
    public Menu(){
        options = new LinkedList<String>();
        title = "Menu";
    }
    
    public int display(){
        while(true){
            Util.cls();
            System.out.println(title+"\n");
            for(int i = 0; i < options.size(); i++)
                System.out.println("["+(i+1)+"]: "+options.get(i));
            System.out.print(">>>");
            String in = Input.getInput();
            if(in.charAt(0) == '/'){
                String[] parts = (in.substring(1, in.length()-1)).split(" ");
                Command.run(parts);
            }
            else{
                return (Util.tryParseInt(in)==null)?-1:Util.tryParseInt(in)-1;
            }
        }
    }
    
    protected int pdisplay(){
        while(true){
            Util.cls();
            System.out.println(title+"\n");
            for(int i = 0; i < options.size(); i++)
                System.out.println("["+(i+1)+"]: "+options.get(i));
            System.out.print(">>>");
            String in = Input.getInput();
            if(in.charAt(0) == '/'){
                String[] parts = (in.substring(1, in.length()-1)).split(" ");
                Command.run(parts);
            }
            else{
                return (Util.tryParseInt(in)==null)?-1:Util.tryParseInt(in)-1;
            }
        }
    }
    
}