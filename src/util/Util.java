package dndsp.util;

import java.lang.Runtime;

public class Util{
    
    public static int constrain(int x, int min, int max){
        int val = x;
        if(x < min)
            val = min;
        if(x > max)
            val = max;
        return val;
    }
    
    public static void system(String command, String args){
        try{
            new ProcessBuilder(command, args).inheritIO().start().waitFor();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }
    
    public static void cls(){
        system("clear","");
    }
    
}