package app.virus;

import app.entities.Entity;
import app.map.Map;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 23/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 * Will handle all the app.virus
 */
public abstract class Virus {
    protected int CONTAGIOUS=2;
    protected int RECOVERING=5;
    protected int IMMUNE=8;
    protected int day=0;

    public Virus() {}

    public abstract void time(Map m, Entity e);

    void day(){
        this.day++;
    }
}
