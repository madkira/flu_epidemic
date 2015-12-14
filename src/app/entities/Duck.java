package app.entities;

import app.data.Status;
import app.map.Block;
import app.map.Map;
import app.virus.H2N1;
import app.virus.H5N1;
import app.virus.Virus;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 23/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 * Will handle the Ducks
 */
public class Duck extends Animal {
    /**
     * Default constructor
     * @param status    Starting status
     * @param virus     Starting app.virus
     * @param m         The app.map
     */
    public Duck(Status status, boolean virus, Map m, int width, int height) throws InstantiationException, IllegalAccessException {
        super(status, virus, m, width, height);
        this.setName("Duck");
        infectionClass = H5N1.class;
        if (virus) this.contract(m);
    }
}
