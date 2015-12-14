package app.data;

/**
 * Created by FILIOL DE RAIMOND-MICHEL Guillaume on 23/11/2015.
 * @author FILIOL DE RAIMOND-MICHEL Guillaume
 * Will handle the app.data
*/
public enum Status {
    HEALTHY("Healthy"), SICK("Sick"), CONTAGIOUS("Contagious"), RECOVERING("Recovering"), DEAD("Dead"), IMMUNE("Immune");
    private String status;
    Status(String status) {this.status=status;}

}