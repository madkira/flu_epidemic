package app.virus;

import app.data.Status;
import app.entities.Entity;
import app.map.Map;

import java.util.Random;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 23/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 * Will handle the H3N1 app.virus only for person
 */
public class H3N1 extends Virus {
    public H3N1() {
        super();
    }

    public void time(Map m, Entity e){
        m.getEntity(e.getWidth(), e.getHeight()).getVirus().day();
        if (day > IMMUNE && e.getStatus() == Status.RECOVERING){
            Random r=new Random();
            double rand=r.nextDouble();
            if (rand >0.5){
                e.setStatus(Status.DEAD);
                m.getEntity(e.getWidth(), e.getHeight()).setStatus(Status.DEAD);
            }else{
                e.setStatus(Status.IMMUNE);
                m.getEntity(e.getWidth(), e.getHeight()).setStatus(Status.IMMUNE);
            }
        }
        else if (day > CONTAGIOUS && day < RECOVERING){
            m.getEntity(e.getWidth(), e.getHeight()).setStatus(Status.RECOVERING);
        }
    }
}