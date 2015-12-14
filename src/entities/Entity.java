package entities;


import data.Status;
import map.Map;
import virus.Virus;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 23/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 * Will handle all the entities
 */
public interface Entity {

    /**
     * This method will determinate if the entity is a Person
     * @return True if it's a Person
     */
    boolean isPerson();

    /**
     * Will handle the infection of an entity
     * @param E  The infective entity
     * @param m The map
     */
    void infect (Entity E, Map m);

    /**
     * Will handle the movement of the entities
     * @param m The map
     */
    void move(Map m);

    /**
     * Will handle the update of the data of the entities, and his neighbours
     * @param m The map
     */
    void update(Map m);

    /**
     * When an entities contract a virus
     * @param m The map
     */
     void contract(Map m);

    // Setters and Getters
    int getHeight() ;
    int getWidth() ;
    Virus getVirus() ;
    String getName() ;
    void setHeight(int height) ;
    void setWidth(int width) ;
    void setVirus(Virus virus) ;
    Status getStatus() ;
    void setStatus(Status status);
    void setName(String name) ;

}
