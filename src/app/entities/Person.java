package app.entities;

import app.data.Status;
import app.map.Block;
import app.map.Map;
import app.virus.H3N1;
import app.virus.Virus;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 23/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 * Will handle all the people
 */
public class Person extends Entity {

    /**
     * Default constructor
     * @param status    Starting status
     * @param virus     Starting app.virus
     * @param m         The app.map
     */
    public Person(Status status, boolean virus, Map m, int width, int height) throws IllegalAccessException, InstantiationException {
        super(status, virus, m, width, height);
        this.setName("Person");
        this.infectionClass=H3N1.class;
        if (virus) this.contract(m);
    }

    /**
     * Willl determinate if the entity is a Person
     * @return True if she's a Person
     */
    public boolean isPerson(){return true;}
}
