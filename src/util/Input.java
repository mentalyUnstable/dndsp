package dndsp.util;

import java.util.Scanner;

/**
     * @author mentalyUnstable/DarkSun
     * @description gets user input
     */
public class Input{
    
    private static Scanner s;
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return void
     * @description initializes the input class
     */
    public static void init(){
        s = new Scanner(System.in);
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return String
     * @description gets user input
     */
    public static String getInput(){
        return s.nextLine();
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return String
     * @description prompts the user for input, and returns it
     */
    public static String prompt(String message){
        System.out.print(message);
        return getInput();
    }
    
}