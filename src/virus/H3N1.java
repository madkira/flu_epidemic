package virus;

import map.Map;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 23/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 * Will handle the H3N1 virus only for person
 */
public class H3N1 implements Virus {
    private int CONTAGIOUS=2;
    private int RECOVERING=5;
    private int IMMUNE=8;
    private int day=0;
    public H3N1() {
    }
    public void time(Map m){

    }
}