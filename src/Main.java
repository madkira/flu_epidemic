import data.Status;
import entity.*;
import map.Map;

import java.util.ArrayList;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 24/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume Will run the main program
 */
public class Main {
    public static void main (String[] args) {
        ArrayList<Entity> entitys=new ArrayList<>();
        Map m = new Map(10, 10);
        Duck d1=new Duck(Status.HEALTHY, false, m);
        Pig p1=new Pig(Status.HEALTHY, true, m);
        Chicken c1=new Chicken(Status.HEALTHY, true, m);
        Person P1=new Person(Status.HEALTHY, false, m);
        Person P2=new Person(Status.HEALTHY, false, m);
        Person P3=new Person(Status.HEALTHY, false ,m);
        Person P4=new Person(Status.HEALTHY, false , m);
        Person P5=new Person(Status.HEALTHY, false, m);
        Person P6=new Person(Status.IMMUNE, false, m);
        entitys.add(d1);
        entitys.add(p1);
        entitys.add(c1);
        entitys.add(P1);
        entitys.add(P2);
        entitys.add(P3);
        entitys.add(P4);
        entitys.add(P5);
        entitys.add(P6);
        m.add(d1, 9, 1);
        m.add(p1, 5, 0);
        m.add(c1, 0, 5);
        m.add(P1, 1, 1);
        m.add(P2, 2, 1);
        m.add(P3, 1, 2);
        m.add(P4, 2, 2);
        m.add(P5, 3, 1);
        m.add(P6, 1, 3);
        while (!m.end()){
            for (Entity e : entitys){
                e.move(m);
                e.update(m);

            }
        }
    }
}
