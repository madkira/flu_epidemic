package app.virus;

import app.data.Status;
import app.entities.Entity;
import app.map.Map;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 23/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 * Will handle the H1N1 Virus, only for pigs
 */
public class H1N1 extends Virus {
    public H1N1(){
        super();
    }

    public void time(Map m, Entity e){
        m.getEntity(e.getWidth(), e.getHeight()).getVirus().day();
        if (day >CONTAGIOUS){
            m.getEntity(e.getWidth(), e.getHeight()).setStatus(Status.CONTAGIOUS);
        }
    }
}
