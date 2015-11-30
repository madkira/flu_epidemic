package entity;

import data.Status;
import map.Map;
import virus.H2N1;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 23/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 * Will handle the chicken
 */
public class Chicken extends Animal{
    /**
     * Constructor for the equality test
     */
    public Chicken(){}

    /**
     * Default constructor
     * @param status    Starting status
     * @param virus     Starting virus
     * @param m         The map
     */
    public Chicken(Status status, boolean virus, Map m){
        this.setName("Chicken");
        this.setStatus(status);
        if (virus) this.contract(m);
    }

    /**
     * The chicken will contract the virus
     * @param m The map
     */
    @Override
    public void contract(Map m){
        if (this.getVirus() == null){
            this.setVirus(new H2N1());
            this.setStatus(Status.SICK);
        }else{
            this.getVirus().time(this, m);
        }
    }
    @Override
    public boolean equals(Object o){
        return o instanceof Chicken;
    }
}
