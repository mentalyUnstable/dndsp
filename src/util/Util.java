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
    
    public static boolean containsOnlyNumbers(String s){
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!(c=='0' || c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9')){
                return false;
            }
        }
        return true;
    }
    
    public static void cls(){
        system("clear","");
    }
    
}