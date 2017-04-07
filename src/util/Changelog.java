package dndsp.util;

import java.util.Scanner;
import java.io.File;

public class Changelog{
    
    public static void display(){
        try {
            Util.cls();
            Scanner s = new Scanner(new File("/home/.dndsp/changes.txt"));
            while(s.hasNextLine())
                System.out.println(s.nextLine());
            
            Input.prompt("\nPress [ENTER] to continue.");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}