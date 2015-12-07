package entity;

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
     * Will handle the movement of the entities
     * @param m The map
     */
    void infect (Entity E, Map m);
    void move(Map m);
        /*
        if (this.getStatus().equals(Status.DEAD))return;
        ArrayList<Block> possibilities=new ArrayList<>();
        int width=this.getWidth();
        int height=this.getHeight();
        if (width+1<m.getWidth() && m.getBlock(width+1, height).getEntity() == null){
            possibilities.add(m.getBlock(width+1, height));
        }
        if (height+1<m.getHeight() && m.getBlock(width, height+1).getEntity() == null){
            possibilities.add(m.getBlock(width, height+1));
        }
        if (width-1 >=0 && m.getBlock(width-1, height).getEntity() == null){
            possibilities.add(m.getBlock(width-1, height));
        }
        if (height-1 >=0 && m.getBlock(width, height-1).getEntity() == null){
            possibilities.add(m.getBlock(width, height-1));
        }
        if (possibilities.size()==0)return;
        Random r=new Random();
        int rand=(int)r.nextFloat()*possibilities.size();
        m.remove(width, height);
        this.setHeight(possibilities.get(rand).getHeight());
        this.setWidth(possibilities.get(rand).getWidth());
        m.add(this, this.getWidth(), this.getHeight());
        */



    /**
     * Will handle the update of the data of the entity, and his neighbours
     * @param m The map
     */
    void update(Map m);
        /*
        Block tmp;
        if (this.getVirus() != null){
            this.getVirus().time(this, m);

        }
        if (this.getStatus().equals(Status.CONTAGIOUS)) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (this.getWidth() + i > 0 && this.getHeight() + j > 0 && this.getWidth() + i < m.getWidth() && this.getHeight() + j < m.getHeight()) {
                        tmp = m.getBlock(this.getWidth() + i, this.getHeight() + j);
                        Entity e = tmp.getEntity();
                        if (e != null && this.getVirus() != null) {
                            this.getVirus().infect(this, e, m);
                        }
                    }
                }
            }
        }
        */



    /**
     * When an entity contract a virus
     * @param m The map
     */
     void contract(Map m);

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
