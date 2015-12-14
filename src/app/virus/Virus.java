package app.virus;

import app.entities.Entity;
import app.map.Map;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 23/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 * Will handle all the app.virus
 */
public interface Virus {
    void time(Map m, Entity e);
    void day();
}
