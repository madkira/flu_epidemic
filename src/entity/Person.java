package entity;

import data.Status;
import map.Map;
import virus.H3N1;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 23/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 * Will handle all the people
 */
public class Person extends Entity{
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
    @Override
    public boolean equals(Object o){
        return o instanceof Person;
    }
}
