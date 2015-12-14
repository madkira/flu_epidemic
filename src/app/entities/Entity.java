package app.entities;


import app.data.Status;
import app.map.Map;
import app.virus.Virus;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 23/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 * Will handle all the app.entities
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
     * @param m The app.map
     */
    void infect (Entity E, Map m);

    /**
     * Will handle the movement of the app.entities
     * @param m The app.map
     */
    void move(Map m);

    /**
     * Will handle the update of the app.data of the app.entities, and his neighbours
     * @param m The app.map
     */
    void update(Map m);

    /**
     * When an app.entities contract a app.virus
     * @param m The app.map
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
