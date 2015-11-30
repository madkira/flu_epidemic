package virus;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 23/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 * Will handle the H2N1 virus only for chickens
 */
public class H2N1 extends Virus{
    public H2N1(){}
    @Override
    public boolean equals(Object o){
        return o instanceof H2N1;
    }
}
