package dndsp.util;

import java.util.Scanner;
import java.io.File;
import java.net.URL;

/**
     * @author mentalyUnstable/DarkSun
     * @description Gets an online changelog to show you whats new
     */
public class Changelog{
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return void
     * @description gets an online chengelog to show you whats new
     */
    public static void display(){
        try {
            Util.cls();
            Scanner s = new Scanner(new URL("https://raw.githubusercontent.com/mentalyUnstable/dndsp/master/changes.txt").openStream());
            while(s.hasNextLine())
                System.out.println(s.nextLine());
            
            Input.prompt("\nPress [ENTER] to continue.");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}