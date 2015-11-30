package entity;

import data.Status;
import map.Map;
import virus.H5N1;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 23/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 * Will handle the Ducks
 */
public class Duck extends Animal{
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
    public boolean equals(Object o){
        return o instanceof Duck;
    }
}
