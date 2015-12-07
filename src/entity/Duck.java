package entity;

import data.Status;
import map.Block;
import map.Map;
import virus.H5N1;
import virus.Virus;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 23/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 * Will handle the Ducks
 */
public class Duck implements Entity{
    /**
     * Constructor for the equality test
     */
    public Duck(){}

    /**
     * Default constructor
     * @param status    Starting status
     * @param virus     Starting virus
     * @param m         The map
     */
    public Duck(Status status, boolean virus, Map m){
        this.setName("Duck");
        this.setStatus(status);
        if (virus) this.contract(m);
    }

    @Override
    public void move(Map m) {

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

    @Override
    public void update(Map m) {
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

    /**
     * The duck will contract the virus
     * @param m The map
     */
    @Override
    public void contract(Map m){
        if (this.getVirus() == null){
            this.setVirus(new H5N1());
            this.setStatus(Status.SICK);
        }else{
            this.getVirus().time(this, m);
        }
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public Virus getVirus() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setHeight(int height) {

    }

    @Override
    public void setWidth(int width) {

    }

    @Override
    public void setVirus(Virus virus) {

    }

    @Override
    public Status getStatus() {
        return null;
    }

    @Override
    public void setStatus(Status status) {

    }

    @Override
    public void setName(String name) {

    }
}
