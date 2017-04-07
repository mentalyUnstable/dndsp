package dndsp.util;

import java.util.Scanner;
import java.io.File;
import java.net.URL;

public class Changelog{
    
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