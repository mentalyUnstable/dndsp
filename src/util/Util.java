package dndsp.util;

import java.lang.Runtime;

/**
     * @author mentalyUnstable/DarkSun
     * @description contains utility functions that may be used in many places
     */
public class Util{
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return int
     * @description makes sure and int is between two numbers
     */
    public static int constrain(int x, int min, int max){
        int val = x;
        if(x < min)
            val = min;
        if(x > max)
            val = max;
        return val;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return void
     * @description runs a system command
     * @param String command
     * @param String args args for command
     */
    public static void system(String command, String args){
        try{
            new ProcessBuilder(command, args).inheritIO().start().waitFor();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return Integer parsed int
     * @description tries to parse an int from a string
     * @param String text text to parse for int
     */
    public static Integer tryParseInt(String text) {
        try {
            if(!containsOnlyNumbers(text)){
                return null;
            }
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return boolean
     * @description makes sure a string only has numbers
     * @param String s
     */
    public static boolean containsOnlyNumbers(String s){
        if(s.length()==0){
            return false;
        }
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!(c=='0' || c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9')){
                return false;
            }
        }
        return true;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return void
     * @description clear console screen
     */
    public static void cls(){
        system("clear","");
    }
    
}