package entity;

import data.Status;
import map.Block;
import map.Map;
import virus.Virus;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 23/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 * Will handle all the entities
 */
public interface Entity {
    // Width position
    private int width;
    // Height position
    private int height;
    // Virus the entity have
    private Virus virus;
    // Status of the entity
    private Status status=Status.HEALTHY;
    // Name of the entity
    private String name;
    /**
     * Will handle the movement of the entities
     * @param m The map
     */
    public void move(Map m);
        /*
        if (this.getStatus().equals(Status.DEAD))return;
        ArrayList<Block> possibilities=new ArrayList<>();
        int width=this.getWidth();
        int height=this.getHeight();
        if (width+1<m.getWidth() && m.getBlock(width+1, height).getEntity() == null){
            possibilities.add(m.getBlock(width+1, height));
        }
        if (height+1<m.getHeight() && m.getBlock(width, height+1).getEntity() == null){
            possibilities.add(m.getBlock(width, height+1));
        }
        if (width-1 >=0 && m.getBlock(width-1, height).getEntity() == null){
            possibilities.add(m.getBlock(width-1, height));
        }
        if (height-1 >=0 && m.getBlock(width, height-1).getEntity() == null){
            possibilities.add(m.getBlock(width, height-1));
        }
        if (possibilities.size()==0)return;
        Random r=new Random();
        int rand=(int)r.nextFloat()*possibilities.size();
        m.remove(width, height);
        this.setHeight(possibilities.get(rand).getHeight());
        this.setWidth(possibilities.get(rand).getWidth());
        m.add(this, this.getWidth(), this.getHeight());
        */



    /**
     * Will handle the update of the data of the entity, and his neighbours
     * @param m The map
     */
    public void update(Map m);
        /*
        Block tmp;
        if (this.getVirus() != null){
            this.getVirus().time(this, m);

        }
        if (this.getStatus().equals(Status.CONTAGIOUS)) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (this.getWidth() + i > 0 && this.getHeight() + j > 0 && this.getWidth() + i < m.getWidth() && this.getHeight() + j < m.getHeight()) {
                        tmp = m.getBlock(this.getWidth() + i, this.getHeight() + j);
                        Entity e = tmp.getEntity();
                        if (e != null && this.getVirus() != null) {
                            this.getVirus().infect(this, e, m);
                        }
                    }
                }
            }
        }
        */



    /**
     * When an entity contract a virus
     * @param m The map
     */
    public abstract void contract(Map m);

    public int getHeight() ;

    public int getWidth() ;

    public Virus getVirus() ;

    public String getName() ;

    public void setHeight(int height) ;
    public void setWidth(int width) ;

    public void setVirus(Virus virus) ;

    public Status getStatus() ;

    public void setStatus(Status status);

    public void setName(String name) ;

}
