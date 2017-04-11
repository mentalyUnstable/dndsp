package dndsp.world;

import java.util.UUID;

import dndsp.util.Rand;
import dndsp.util.Util;
import dndsp.util.Direction;

/**
 * @author mentalyUnstable/DarkSun
 * @description Creates Worlds
 */
public class WorldGenerator{
    
    private int rows;
    private int cols;
    private double noise;
    private double chestBooster;
    private double entityBooster;
    private double NPCBooster;
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return WorldGenerator
     * @description creates a worldgenerator for creating worlds
     * @param int rows
     * @param int cols
     * @param double noise how many should be non-enterable
     * @param double chestbooster
     * @param double entitybooster
     * @param double npcbooster
     */
    public WorldGenerator(int rows, int cols, double noise, double chestBooster, double entityBooster, double NPCBooster){
        this.rows = rows;
        this.cols = cols;
        this.noise = noise;
        this.chestBooster = chestBooster;
        this.entityBooster = entityBooster;
        this.NPCBooster = NPCBooster;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return World
     * @description creates a world based on settings
     */
    public World create(){
        World w = new World(UUID.randomUUID(), rows, cols);
        Room[][] rooms = new Room[rows][cols];
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                rooms[r][c] = createRoom(c, r);
            }
        }
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                Room[] around = new Room[4];
                around[0] = rooms[Util.constrain(r-1, 0, rows-1)][c];
                around[1] = rooms[Util.constrain(r+1, 0, rows-1)][c];
                around[2] = rooms[r][Util.constrain(c-1, 0, cols-1)];
                around[3] = rooms[r][Util.constrain(c+1, 0, cols-1)];
                rooms[r][c] = setDoors(rooms[r][c], around);
            }
        }
        w.setRooms(rooms);
        return w;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return Room
     * @description sets the doors of a room based on its surroundings
     */
    private Room setDoors(Room room, Room[] around){
        Room r = room;
        
        for(int d : Direction.DIRECTIONS){
            if(around[d].isEnterable())
                r.setDoor(d, true);
        }
        
        return r;
    }
    
    /**
     * @author mentalyUnstable/DarkSun
     * @return Room
     * @description creates a room with random settings
     */
    private Room createRoom(int x, int y){
        Room r = new Room();
        
        r.setX(x);
        r.setY(y);
        
        if(x == 0 || y == 0 || x == (cols-1) || y == (rows-1)){
            r.setIsEnterable(false);
            r.setRoomType(Room.RoomType.THICK_FOREST);
        }
        else if(noise<=Rand.getDouble()){
            r.setIsEnterable(true);
            r.setRoomType(Room.RoomType.PLAINS);
        }
        else{
            r.setIsEnterable(false);
            r.setRoomType(Room.RoomType.THICK_FOREST);
        }
        
        return r;
    }
}