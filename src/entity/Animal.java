package entity;

import map.Map;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 23/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 * Will handle al the animals
 */
public class Animal extends Entity{
    /**
     * Constructor for the equality test
     */
    public Animal(){}
    /**
     * The animal will contract the virus
     * @param m The map
     */
    public  void contract(Map m){}
    @Override
    public boolean equals(Object o){
        return o instanceof Animal ;
    }
}
