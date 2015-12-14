package map;

import data.Status;
import entities.Entity;

import java.util.ArrayList;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 23/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 * Will handle the global map
 */
public class Map{

    // Current day
    private int day=1;
    //List of all the current entities
    private ArrayList<Entity> entities=new ArrayList<>();
    // The current map
    private Block[][] map;
    // Width of the map
    private int width;
    // Height of the map
    private int height;
    // For the update
    private int near;

    /**
     * Default constructor
     * @param height    Height od the map
     * @param width     Width of the map
     */
    public Map(int height, int width, int near) {
        this.near=near;
        this.map = new Block[width][height];
        this.setHeight(height);
        this.setWidth(width);
        for (int i=0; i<width; i++){
            for (int j=0; j<height; j++){
                map[i][j]=new Block(null, i, j);
            }
        }
    }

    /**
     * Add an entities
     * @param e         Entity to add
     * @param width     Width to add
     * @param height    Height to add
     */
    public void add(Entity e, int width, int height){
        e.setWidth(width);
        e.setHeight(height);
        map[width][height].setEntity(e);
    }

    /**
     * Remove an entities
     * @param width     Width to remove
     * @param height    Height to remove
     */
    public void remove(int width, int height){
        map[width][height].remove();
    }

    /**
     * Will print the map in the console and check the end
     * @return True if it's finish
     */
    public boolean end() {
        System.out.println(String.format("%100s", "##### DAY "+day+" #####"));
        day++;
        boolean ret=true;
        int height=this.getHeight();
        int width=this.getHeight();
        int cpt1=0;
        int cpt2=0;
        System.out.print(String.format("%-20s", ""));
        for (int i=0; i<width; i++){
            System.out.print(String.format("%-20s", cpt1));
            cpt1++;
        }
        System.out.println();
        for (int i=0; i<width; i++){
            System.out.print(cpt2+"\t\t|");
            cpt2++;
            for (int j=0; j<height;j++){
                Entity e=this.getEntity(i, j);
                if (e != null){
                    System.out.print(String.format("%-20s", e.getName()+" ["+e.getStatus()+"]"));
                        if (e.isPerson()) {
                            if (!e.getStatus().equals(Status.DEAD) && !e.getStatus().equals(Status.IMMUNE)) ret = false;
                        }
                }
                else{System.out.print(String.format("%-20s", ""));}
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("\n\n");
        return ret;

    }

    // Setters and Getters
    public Block getBlock(int width, int height){
        return map[width][height];
    }
    public Entity getEntity(int width, int height){
        return this.getBlock(width, height).getEntity();
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width=width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height=height;
    }
    public void addList(Entity e){entities.add(e);}
    public ArrayList<Entity> getList(){return entities;}
    public int getDay(){return day;}
    public int getNear(){return near;}
}
