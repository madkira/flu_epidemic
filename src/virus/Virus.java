package virus;

import data.Status;
import entity.*;
import map.Map;

import java.util.Random;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 23/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 * Will handle all the virus
 */
public class Virus {
    final static int CONTAGIOUS=2;
    final static int RECOVERING=5;
    final static int IMMUNE=8;
    private int day=0;
    public void time(Entity e, Map m){
        if (e.getStatus().equals(Status.DEAD))return;
        day++;
        Random rand=new Random();
        float f=rand.nextFloat();
        if (!new Animal().equals(e) && this.getDay()>IMMUNE && e.getStatus() != Status.IMMUNE && e.getStatus() != Status.DEAD ){
            e.setStatus(Status.IMMUNE);
        }
        else if (!new Animal().equals(e) && this.getDay()>RECOVERING){
            if (f<0.5){
                e.setStatus(Status.DEAD);
            }else{
                e.setStatus(Status.RECOVERING);
            }
        }else if (this.getDay()>CONTAGIOUS){
            e.setStatus(Status.CONTAGIOUS);
        }
        m.add(e, e.getWidth(), e.getHeight());
    }
    public void infect(Entity carrier, Entity target, Map m){
        if (target.getStatus().equals(Status.IMMUNE))return;
        Random rand=new Random();
        float f=rand.nextFloat();
        if (new Person().equals(carrier)){
            if (new Person().equals(target)){
                if (f>0.5){target.contract(m);}
            }
        }
        if (new Pig().equals(carrier)){
            if (new Person().equals(target)){
                if (f<0.1){target.contract(m);}
            }
            if (new Pig().equals(target)){
                if (f<0.5){target.contract(m);}
            }
        }
        if (new Chicken().equals(carrier)){
            if (new Person().equals(target)){
                if (f<0.1){target.contract(m);}
            }
            if (new Chicken().equals(target)){
                if (f<0.5){target.contract(m);}
            }
        }
        else{
            if (new Person().equals(target)){
                if (f<0.1){target.contract(m);}
            }
            if (new Duck().equals(target)){
                if (f<0.5){target.contract(m);}
            }
        }
    }

    public int getDay() {
        return day;
    }
}
