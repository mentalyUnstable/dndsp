package dndsp.util;

/**
 * @author mentalyUnstable/DarkSun
 * @description start of program
 */
public class Dice{
    
    public int c,s,m;
    
    /**
     * rolls some dice and returns the sum
     * 
     * @author mentalyUnstable/DarkSun
     * @param c number of dice, "count"
     * @param s number of sides on each die
     * @param m modifier to be added
     */
    public Dice(int c, int s, int m){
        this.c=c;
        this.s=s;
        this.m=m;
    }
    
    /**
     * Rolls some dice and returns the sum
     * 
     * @author mentalyUnstable/DarkSun
     * @param c number of dice, "count"
     * @param s number of sides on each die
     * @param m modifier to be added
     * @return sum of modifier and rolled dice
     */
    public static int roll(int c, int s, int m){
        int sum = m;
        for(int i = 0; i < c; i++)
            sum += Rand.getInt(1, s);
        return sum;
    }
    
    public int roll(){
        return Dice.roll(c,s,m);
    }
    
}