package dndsp.world;

import java.util.UUID;

import dndsp.util.Rand;
import dndsp.util.Util;
import dndsp.util.Direction;

public class WorldGenerator{
    
    private int rows;
    private int cols;
    private double noise;
    private double chestBooster;
    private double entityBooster;
    private double NPCBooster;
    
    public WorldGenerator(int rows, int cols, double noise, double chestBooster, double entityBooster, double NPCBooster){
        this.rows = rows;
        this.cols = cols;
        this.noise = noise;
        this.chestBooster = chestBooster;
        this.entityBooster = entityBooster;
        this.NPCBooster = NPCBooster;
    }
    
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
    
    private Room setDoors(Room room, Room[] around){
        Room r = room;
        Room.RoomMeta rm = r.getMeta();
        
        for(int d : Direction.DIRECTIONS){
            if(around[d].getMeta().enterable)
                rm.doors[d] = true;
        }
        
        return r;
    }
    
    private Room createRoom(int x, int y){
        Room r = new Room();
        Room.RoomMeta rm = r.getMeta();
        
        rm.x = x;
        rm.y = y;
        
        if(x == 0 || y == 0 || x == (cols-1) || y == (rows-1)){
            rm.enterable = false;
            rm.roomType = Room.RoomType.THICK_FOREST;
        }
        else if(noise<=Rand.getDouble()){
            rm.enterable = true;
            rm.roomType = Room.RoomType.PLAINS;
        }
        else{
            rm.enterable = false;
            rm.roomType = Room.RoomType.THICK_FOREST;
        }
        
        return r;
    }
}