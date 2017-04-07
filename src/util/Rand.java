package dndsp.util;

import java.util.Random;

/**
     * @author mentalyUnstable/DarkSun
     * @description makes random numbers
     */
public class Rand{
    
    private static Random r;
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return void
     * @description initializes the rand class
     */
    public static void init(){
        r = new Random();
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return int
     * @description creates a random number in a range
     */
    public static int getInt(int min, int max){
        return r.nextInt(max - min + 1) + min;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return double
     * @description makes a random double between 0 and 1
     */
    public static double getDouble(){
        return r.nextDouble();
    }
    
}