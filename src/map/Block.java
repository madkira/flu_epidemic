package map;

import entities.Entity;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 23/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 * Will handle a block of the map
 */
public class Block {
    // Width position in map
    private int width;
    // Height position in map
    private int height;
    // Entity in the block
    private Entity entity;

    /**
     * Default constructor
     * @param current   Current entities
     * @param width     Current width
     * @param height    Current height
     */
    public Block(Entity current, int width, int height)
    {
        this.entity =current;
        this.width=width;
        this.height=height;
    }

    public Entity getEntity(){return entity;}
    public void setEntity(Entity e){entity =e;}
    public void remove(){entity =null;}

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
