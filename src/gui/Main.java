package gui;

/**
 * Created by Raphael KUMAR on 12/14/15.
 * @author Raphael KUMAR Will run the main program
 */
public class Main {
    protected static final int FPS_MIN = 0;
    protected static final int FPS_MAX = 30;
    protected static int ACTUAL_FPS =15;
    protected static int KINDOFMOV = 4;
    protected static final int FOUR = 4;
    protected static final int EIGHT = 8;


    public static void setActualFps(int actualFps) {
        ACTUAL_FPS = actualFps;
    }

    public static void main(String[] args) {
        new Initialisation();
    }
}

/*
    speed exec (radio bouton, au cours de l'exec)
    4 / 8 voision (au debut)
 */