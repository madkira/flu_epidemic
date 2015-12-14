package app.entities;

import app.data.Status;
import app.map.Map;

import java.util.Random;

/**
 * flu_epidemic created on 14/12/2015 by Keynes Timothy - Aloysius_tim
 */
public abstract class Animal extends Entity {

    public Animal(Status status, boolean virus, Map m, int width, int height) throws IllegalAccessException, InstantiationException {
        super(status, virus, m, width, height);
    }

    /**
     * Will determine if the entity is a Person
     * @return True if she's a Person
     */
    public boolean isPerson(){return false;}

    /**
     * Will handle the infection of an entity
     * @param e  The infective entity
     * @param m The app.map
     */
    public void infect (Entity e, Map m) throws InstantiationException, IllegalAccessException {
        Random r =new Random();
        double rand=r.nextDouble();
        if (!e.isPerson()){
            if (rand > 0.1){
                this.contract(m);
            }
        }else if (e.isPerson()){
            if (rand > 0.25) this.contract(m);
        }
    }
}
