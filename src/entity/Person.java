package entity;

import data.Status;
import map.Block;
import map.Map;
import virus.H3N1;
import virus.Virus;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 23/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 * Will handle all the people
 */
public class Person implements Entity{
    // Width position
    private int width = 0;
    // Height position
    private int height = 0;
    // Virus the entity have
    private Virus virus = null;
    // Status of the entity
    private Status status=Status.HEALTHY;
    // Name of the entity
    private String name = null;
    /**
    /**
     * Constructor for the equality test
     */
    public Person(){}

    /**
     * Default constructor
     * @param status    Starting status
     * @param virus     Starting virus
     * @param m         The map
     */
    public Person(Status status, boolean virus, Map m){
        this.setName("Person");
        this.setStatus(status);
        if (virus)this.contract(m);

    }

    /**
     * The person will contract the virus
     * @param m  The map
     */
    public void contract(Map m){
        if (this.getVirus() == null){
            this.setVirus(new H3N1());
            this.setStatus(Status.SICK);
        }else{
            this.getVirus().time(this, m);

        }
    }

    /**
     * Will handle the person movement
     * @param m The map
     */
    public void move (Map m){
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
    }

    /**
     * Will handle the update of the entities
     * @param m The map
     */
    public void update(Map m){
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
    }


    public int getHeight(){return this.height;}

    public int getWidth(){return this.width;}

    public Virus getVirus(){return this.virus;}

    public String getName(){return this.name;}

    public void setHeight(int height){this.height=height;}
    public void setWidth(int width){this.width=width;}

    public void setVirus(Virus virus){this.virus=virus;}

    public Status getStatus(){return this.status;}

    public void setStatus(Status status){this.status=status;}

    public void setName(String name){this.name=name;}
}
