package app.virus;

import app.data.Status;
import app.entities.Entity;
import app.map.Map;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 23/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 * Will handle the H2N1 app.virus only for chickens
 */
public class H2N1 extends Virus {

    public H2N1() {
        super();
    }

    public void time(Map m, Entity e){
        m.getEntity(e.getWidth(), e.getHeight()).getVirus().day();
        if (day >CONTAGIOUS){
            m.getEntity(e.getWidth(), e.getHeight()).setStatus(Status.CONTAGIOUS);
        }
    }
}
