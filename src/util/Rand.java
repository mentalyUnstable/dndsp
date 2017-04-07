package dndsp.util;

import java.util.Random;

public class Rand{
    
    private static Random r;
    
    public static void init(){
        r = new Random();
    }
    
    public static int getInt(int min, int max){
        return r.nextInt(max - min + 1) + min;
    }
    
    public static double getDouble(){
        return r.nextDouble();
    }
    
}