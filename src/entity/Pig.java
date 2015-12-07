package entity;

import data.Status;
import map.Map;
import virus.H1N1;
import virus.Virus;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 23/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 * Will handle the pigs
 */
public class Pig implements Entity{
    /**
     * Constructor for the equality test
     */
    public Pig(){}

    /**
     * Default constructor
     * @param status    Starting status
     * @param virus     Starting virus
     * @param m         The map
     */
    public Pig(Status status, boolean virus, Map m){
        this.setName("Pig");
        this.setStatus(status);
        if (virus)this.contract(m);
    }

    @Override
    public void move(Map m) {

    }

    @Override
    public void update(Map m) {

    }

    /**
     * The pig will contract the virus
     * @param m The map
     */
    @Override
    public void contract(Map m){
        if (this.getVirus() == null){
            this.setVirus(new H1N1());
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

    @Override
    public boolean equals(Object o){
        return o instanceof Pig;
    }
}
