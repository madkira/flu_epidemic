package virus;

import data.Status;
import entities.Entity;
import map.Map;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 23/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 * Will handle the H2N1 virus only for chickens
 */
public class H2N1 implements Virus{
    private int CONTAGIOUS=2;
    private int RECOVERING=5;
    private int IMMUNE=8;
    private int day=0;
    public void time(Map m, Entity e){
        m.getEntity(e.getWidth(), e.getHeight()).getVirus().day();
        if (day >CONTAGIOUS){
            m.getEntity(e.getWidth(), e.getHeight()).setStatus(Status.CONTAGIOUS);
        }
    }

    public H2N1(){}
    public void day(){
        day++;
    }
}
