import data.Status;
import entities.*;
import map.Map;

import java.util.ArrayList;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 24/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume Will run the main program
 */
public class Main {
    public static void main (String[] args) {
        ArrayList<Entity> entitys=new ArrayList<>();
        Map m = new Map(10, 10, 8);
        Duck d1=new Duck(Status.HEALTHY, false, m, 9, 1);
        Pig p1=new Pig(Status.HEALTHY, true, m, 5, 0);
        Chicken c1=new Chicken(Status.HEALTHY, true, m, 0, 5);
        Person P1=new Person(Status.HEALTHY, false, m, 1, 1);
        Person P2=new Person(Status.HEALTHY, false, m, 2, 1);
        Person P3=new Person(Status.HEALTHY, false ,m, 1, 2);
        Person P4=new Person(Status.HEALTHY, false , m, 2, 1);
        Person P5=new Person(Status.HEALTHY, false, m, 3, 1);
        Person P6=new Person(Status.IMMUNE, false, m, 1, 3);
        while (!m.end()){
            for (Entity e : m.getList()){
                e.move(m);
                e.update(m);
            }
            try{
                Thread.sleep(1000);
            }catch (Exception exc){}
        }
    }
}
