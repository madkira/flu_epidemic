package gui;

import app.data.Status;
import app.entities.*;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Raphael KUMAR on 12/14/15.
 */
public class Simulation extends JFrame {    // Colors used for empty locations.
    private static final Color EMPTY_COLOR = Color.white;

    // Color used for objects that have no defined color.
    private static final Color UNKNOWN_COLOR = Color.gray;

    JPanel theField = new JPanel();
    //private FieldView fieldView;

    // A map for storing colors for participants in the simulation
    private Map<Class, Color> colors;
    // A statistics object computing and storing simulation information

    //private FieldStats stats;

    /**
     * Create a view of the given width and height.
     *
     * @param height The simulation's height.
     * @param width  The simulation's width.
     */
    public Simulation(int height, int width) throws IllegalAccessException, InstantiationException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        colors = new HashMap<>();
        //  stats = new FieldStats();
        colors.put(Person.class, Color.green);
        colors.put(Duck.class, Color.orange);
        colors.put(Chicken.class, Color.red);
        colors.put(Pig.class, Color.pink);


        JComponent speedSlider = new SpeedSlider();
        speedSlider.setOpaque(true); //content panes must be opaque


        add(speedSlider, BorderLayout.SOUTH);


        app.map.Map m = new app.map.Map(Initialisation.DEFAULT_DEPTH, Initialisation.DEFAULT_WIDTH, Main.KINDOFMOV);
        Duck d1 = new Duck(Status.HEALTHY, false, m, 9, 1);
        Pig p1 = new Pig(Status.HEALTHY, true, m, 5, 0);
        Chicken c1 = new Chicken(Status.HEALTHY, true, m, 0, 5);
        Person P1 = new Person(Status.HEALTHY, false, m, 1, 1);
        Person P2 = new Person(Status.HEALTHY, false, m, 2, 1);
        Person P3 = new Person(Status.HEALTHY, false, m, 1, 2);
        Person P4 = new Person(Status.HEALTHY, false, m, 2, 1);
        Person P5 = new Person(Status.HEALTHY, false, m, 3, 1);
        Person P6 = new Person(Status.IMMUNE, false, m, 1, 3);

        GridLayout field = new GridLayout(Initialisation.DEFAULT_WIDTH, Initialisation.DEFAULT_DEPTH);
        theField.setLayout(field);

        for(int i = 0; i < Initialisation.DEFAULT_WIDTH; i++){
            for(int j = 0; j < Initialisation.DEFAULT_DEPTH; j++) {
                if (m.getEntity(i,j)!= null){
                    JLabel square = new JLabel(m.getEntity(i,j).getStatus().toString());
                    square.setBackground(colors.get(m.getEntity(i,j).getClass()));
                    square.setOpaque(true);
                    theField.add(square);
                }
                else{
                    JLabel square = new JLabel();
                    square.setBackground(EMPTY_COLOR);
                    theField.add(square);
                }
            }
        }
        JPanel viewField = new JPanel();
        viewField.add(theField);
        add(viewField, BorderLayout.CENTER);
        pack();
        setVisible(true);
        while (!m.end()) {
            for (Entity e : m.getList()) {
                e.move(m);
                e.update(m);
            }
            /*field = null;
            field = new GridLayout(Initialisation.DEFAULT_WIDTH, Initialisation.DEFAULT_DEPTH);
            theField.setLayout(field);
            for(int i = 0; i < Initialisation.DEFAULT_WIDTH; i++){
                for(int j = 0; j < Initialisation.DEFAULT_DEPTH; j++) {
                    if (m.getEntity(i,j)!= null){
                        JLabel square = new JLabel(m.getEntity(i,j).getStatus().toString());
                        square.setBackground(colors.get(m.getEntity(i,j).getClass()));
                        square.setOpaque(true);
                        theField.add(square);
                    }
                    else{
                        JButton square = new JButton("");
                        square.setBackground(EMPTY_COLOR);
                        theField.add(square);
                    }
                }
            }

            //viewField.add(theField);
            //add(viewField, BorderLayout.CENTER);
            //setVisible(false);
            //setVisible(true);
*/
            try {
                Thread.sleep(1000 / Main.ACTUAL_FPS);
            } catch (Exception exc) {
            }
        }

    }
}
