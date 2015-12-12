package entities;

import data.Status;
import map.Block;
import map.Map;
import virus.H1N1;
import virus.Virus;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 23/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 * Will handle the pigs
 */
public class Pig implements Entity{
    // Width position
    private int width = 0;
    // Height position
    private int height = 0;
    // Virus the entities have
    private Virus virus = null;
    // Status of the entities
    private Status status=Status.HEALTHY;
    // Name of the entities
    private String name = null;


    /**
     * Default constructor
     * @param status    Starting status
     * @param virus     Starting virus
     * @param m         The map
     */
    public Pig(Status status, boolean virus, Map m, int width, int height){
        this.width=width;
        this.height=height;
        this.setName("Pig");
        this.setStatus(status);
        m.add(this, width, height);
        if (virus)this.contract(m);
        m.addList(this);

    }


    /**
     * The pig will contract the virus
     * @param m The map
     */
    @Override
    public void contract(Map m){
        if (this.getVirus() == null){
            m.getEntity(this.getWidth(), this.getHeight()).setVirus(new H1N1());
            m.getEntity(this.getWidth(), this.getHeight()).setStatus(Status.SICK);
        }else{
            this.getVirus().time(m, this);
        }
    }

    /**
     * Will handle the person movement
     * @param m The map
     */
    public void move (Map m){
        if (this.getStatus() == Status.CONTAGIOUS && m.getDay() %2 == 0)return;
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
    }

    /**
     * Will handle the update of the entities
     * @param m The map
     */
    public void update(Map m){
        int width =m.getWidth();
        int height = m.getHeight();
        Block tmp;
        if (this.getVirus() != null){
            this.getVirus().time(m, this);

        }
        if (this.getWidth() + 1 < width){
            Entity e=m.getEntity(this.getWidth() + 1, this.getHeight());
            if ( e != null){
                e.infect(this, m);
            }
        }
        if (this.getWidth() - 1 > 0){
            Entity e=m.getEntity(this.getWidth() - 1, this.getHeight());
            if ( e != null){
                e.infect(this, m);
            }
        }
        if (this.getHeight() + 1 < height){
            Entity e=m.getEntity(this.getWidth(), this.getHeight() + 1);
            if ( e != null){
                e.infect(this, m);
            }
        }
        if (this.getHeight() - 1 > 0){
            Entity e=m.getEntity(this.getWidth(), this.getHeight() - 1);
            if ( e != null){
                e.infect(this, m);
            }
        }
        if (m.getNear() == 8){
            if (this.getWidth() + 1 < width && this.getHeight() + 1 < height){
                Entity e=m.getEntity(this.getWidth() + 1, this.getHeight() + 1);
                if ( e != null){
                    e.infect(this, m);
                }
            }
            if (this.getWidth() - 1 > 0 && this.getHeight() - 1 > 0){
                Entity e=m.getEntity(this.getWidth() - 1, this.getHeight() - 1);
                if ( e != null){
                    e.infect(this, m);
                }
            }
            if (this.getHeight() + 1 < height && this.getWidth() - 1 > 0){
                Entity e=m.getEntity(this.getWidth() - 1, this.getHeight() + 1);
                if ( e != null){
                    e.infect(this, m);
                }
            }
            if (this.getHeight() - 1 > 0 && this.getWidth() + 1 < width){
                Entity e=m.getEntity(this.getWidth() + 1, this.getHeight() - 1);
                if ( e != null){
                    e.infect(this, m);
                }
            }
        }

    }
    public boolean isPerson(){return false;}
    public void infect (Entity e, Map m){
        Random r =new Random();
        double rand=r.nextDouble();
        if (e instanceof Pig){
            if (rand > 0.1){
                this.contract(m);
            }

        }else if (e instanceof Person){
            if (rand > 0.25) this.contract(m);
        }
    }
    public int getHeight(){return this.height;}

    public int getWidth(){return this.width;}

    public Virus getVirus(){return this.virus;}

    public String getName(){return this.name;}

    public void setHeight(int height){this.height=height;}
    public void setWidth(int width){this.width=width;}

    public void setVirus(Virus virus){this.virus=virus;}

    public Status getStatus(){return this.status;}

    public void setStatus(Status status){this.status=status;}

    public void setName(String name){this.name=name;}
}
