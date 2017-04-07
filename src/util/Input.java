package dndsp.util;

import java.util.Scanner;

public class Input{
    
    private static Scanner s;
    
    public static void init(){
        s = new Scanner(System.in);
    }
    
    public static String getInput(){
        return s.nextLine();
    }
    
    public static String prompt(String message){
        System.out.print(message);
        return getInput();
    }
    
}