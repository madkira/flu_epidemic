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
        colors.putIfAbsent(Duck.class, Color.orange);
        colors.putIfAbsent(Chicken.class, Color.red);
        colors.putIfAbsent(Pig.class, Color.pink);


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
                    JButton square = new JButton(m.getEntity(i,j).getStatus().toString());
                    square.setBackground(colors.get(m.getEntity(i,j)));
                    theField.add(square);
                }
                else{
                    JButton square = new JButton("");
                    square.setBackground(EMPTY_COLOR);
                    theField.add(square);
                }
            }
        }

        add(theField, BorderLayout.CENTER);
        pack();
        setVisible(true);
        while (!m.end()) {
            for (Entity e : m.getList()) {
                e.move(m);
                e.update(m);
            }
            
            try {
                //Thread.sleep(1000 / Main.ACTUAL_FPS);
            } catch (Exception exc) {
            }
        }

    }

    /**
     * Define a color to be used for a given class of animal.
     *
     * @param animalClass The animal's Class object.
     */
/*    public void setColor(Class animalClass, Color color) {
        colors.put(animalClass, color);
    }

    /**
     * @return The color to be used for a given class of animal.
     */
    private Color getColor(Class animalClass) {
        Color col = colors.get(animalClass);
        if (col == null) {
            // no color defined for this class
            return UNKNOWN_COLOR;
        } else {
            return col;
        }
    }
}
    /*public void showStatus(int step, Field field) {
        if (!isVisible()) {
            setVisible(true);
        }

        stepLabel.setText(STEP_PREFIX + step);

        fieldView.preparePaint();

        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                Object animal = field.getObjectAt(row, col);
                if (animal != null) {
                    fieldView.drawMark(col, row, getColor(animal.getClass()));
                } else {
                    fieldView.drawMark(col, row, EMPTY_COLOR);
                }
            }
        }

        fieldView.repaint();
    }

    /**
     * Provide a graphical view of a rectangular field. This is a nested class
     * (a class defined inside a class) which defines a custom component for the
     * user interface. This component displays the field. This is rather
     * advanced GUI stuff - you can ignore this for your project if you like.
     *
    private class FieldView extends JPanel {
        private final int GRID_VIEW_SCALING_FACTOR = 6;

        private int gridWidth, gridHeight;
        private int xScale, yScale;
        Dimension size;
        private Graphics g;
        private Image fieldImage;

        /**
         * Create a new FieldView component.
         *
        public FieldView(int height, int width) {
            gridHeight = height;
            gridWidth = width;
            size = new Dimension(0, 0);
        }

        /**
         * Tell the GUI manager how big we would like to be.
         *
        public Dimension getPreferredSize() {
            return new Dimension(gridWidth * GRID_VIEW_SCALING_FACTOR,
                    gridHeight * GRID_VIEW_SCALING_FACTOR);
        }

        /**
         * Prepare for a new round of painting. Since the component may be
         * resized, compute the scaling factor again.
         *
        public void preparePaint() {
            if (!size.equals(getSize())) { // if the size has changed...
                size = getSize();
                fieldImage = fieldView.createImage(size.width, size.height);
                g = fieldImage.getGraphics();

                xScale = size.width / gridWidth;
                if (xScale < 1) {
                    xScale = GRID_VIEW_SCALING_FACTOR;
                }
                yScale = size.height / gridHeight;
                if (yScale < 1) {
                    yScale = GRID_VIEW_SCALING_FACTOR;
                }
            }
        }

        /**
         * Paint on grid location on this field in a given color.
         *
        public void drawMark(int x, int y, Color color) {
            g.setColor(color);
            g.fillRect(x * xScale, y * yScale, xScale - 1, yScale - 1);
        }

        /**
         * The field view component needs to be redisplayed. Copy the internal
         * image to screen.
         *
        public void paintComponent(Graphics g) {
            if (fieldImage != null) {
                Dimension currentSize = getSize();
                if (size.equals(currentSize)) {
                    g.drawImage(fieldImage, 0, 0, null);
                } else {
                    // Rescale the previous image.
                    g.drawImage(fieldImage, 0, 0, currentSize.width,
                            currentSize.height, null);
                }
            }
        }
    }
}

/*

package foxesandrabbits.graph;

import java.awt.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * A graphical view of the simulation grid. The view displays a colored
 * rectangle for each location representing its contents. Colors for each type
 * of species can be defined using the setColor method.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 *public class GridView extends JFrame implements SimulatorView {
    // Colors used for empty locations.
    private static final Color EMPTY_COLOR = Color.white;

    // Color used for objects that have no defined color.
    private static final Color UNKNOWN_COLOR = Color.gray;

    private final String STEP_PREFIX = "Step: ";
    private final String POPULATION_PREFIX = "Population: ";
    private JLabel stepLabel, population;
    private FieldView fieldView;

    // A map for storing colors for participants in the simulation
    private Map<Class, Color> colors;
    // A statistics object computing and storing simulation information
    private FieldStats stats;

    /**
     * Create a view of the given width and height.
     *
     * @param height
     *            The simulation's height.
     * @param width
     *            The simulation's width.
     *
    public GridView(int height, int width) {
        stats = new FieldStats();
        colors = new HashMap<>();

        setTitle("Fox and Rabbit Simulation");
        stepLabel = new JLabel(STEP_PREFIX, JLabel.CENTER);
        population = new JLabel(POPULATION_PREFIX, JLabel.CENTER);

        setLocation(20, 50);

        fieldView = new FieldView(height, width);

        Container contents = getContentPane();
        contents.add(stepLabel, BorderLayout.NORTH);
        contents.add(fieldView, BorderLayout.CENTER);
        contents.add(population, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    /**
     * Define a color to be used for a given class of animal.
     *
     * @param animalClass
     *            The animal's Class object.
     * @param color
     *            The color to be used for the given class.
     *
    public void setColor(Class animalClass, Color color) {
        colors.put(animalClass, color);
    }

    /**
     * @return The color to be used for a given class of animal.
     *
    private Color getColor(Class animalClass) {
        Color col = colors.get(animalClass);
        if (col == null) {
            // no color defined for this class
            return UNKNOWN_COLOR;
        } else {
            return col;
        }
    }

    /**
     * Show the current status of the field.
     *
     * @param step
     *            Which iteration step it is.
     * @param field
     *            The field whose status is to be displayed.
     *
    public void showStatus(int step, Field field) {
        if (!isVisible()) {
            setVisible(true);
        }

        stepLabel.setText(STEP_PREFIX + step);
        stats.reset();

        fieldView.preparePaint();

        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                Object animal = field.getObjectAt(row, col);
                if (animal != null) {
                    stats.incrementCount(animal.getClass());
                    fieldView.drawMark(col, row, getColor(animal.getClass()));
                } else {
                    fieldView.drawMark(col, row, EMPTY_COLOR);
                }
            }
        }
        stats.countFinished();

        population.setText(POPULATION_PREFIX
                + stats.getPopulationDetails(field));
        fieldView.repaint();
    }

    /**
     * Determine whether the simulation should continue to run.
     *
     * @return true If there is more than one species alive.
     *
    public boolean isViable(Field field) {
        return stats.isViable(field);
    }

    /**
     * Prepare for a new run.
     *
    public void reset() {
    }

    /**
     * Provide a graphical view of a rectangular field. This is a nested class
     * (a class defined inside a class) which defines a custom component for the
     * user interface. This component displays the field. This is rather
     * advanced GUI stuff - you can ignore this for your project if you like.
     *
    private class FieldView extends JPanel {
        private final int GRID_VIEW_SCALING_FACTOR = 6;

        private int gridWidth, gridHeight;
        private int xScale, yScale;
        Dimension size;
        private Graphics g;
        private Image fieldImage;

        /**
         * Create a new FieldView component.
         *
        public FieldView(int height, int width) {
            gridHeight = height;
            gridWidth = width;
            size = new Dimension(0, 0);
        }

        /**
         * Tell the GUI manager how big we would like to be.
         *
        public Dimension getPreferredSize() {
            return new Dimension(gridWidth * GRID_VIEW_SCALING_FACTOR,
                    gridHeight * GRID_VIEW_SCALING_FACTOR);
        }

        /**
         * Prepare for a new round of painting. Since the component may be
         * resized, compute the scaling factor again.
         *
        public void preparePaint() {
            if (!size.equals(getSize())) { // if the size has changed...
                size = getSize();
                fieldImage = fieldView.createImage(size.width, size.height);
                g = fieldImage.getGraphics();

                xScale = size.width / gridWidth;
                if (xScale < 1) {
                    xScale = GRID_VIEW_SCALING_FACTOR;
                }
                yScale = size.height / gridHeight;
                if (yScale < 1) {
                    yScale = GRID_VIEW_SCALING_FACTOR;
                }
            }
        }

        /**
         * Paint on grid location on this field in a given color.
         *
        public void drawMark(int x, int y, Color color) {
            g.setColor(color);
            g.fillRect(x * xScale, y * yScale, xScale - 1, yScale - 1);
        }

        /**
         * The field view component needs to be redisplayed. Copy the internal
         * image to screen.
         *
        public void paintComponent(Graphics g) {
            if (fieldImage != null) {
                Dimension currentSize = getSize();
                if (size.equals(currentSize)) {
                    g.drawImage(fieldImage, 0, 0, null);
                } else {
                    // Rescale the previous image.
                    g.drawImage(fieldImage, 0, 0, currentSize.width,
                            currentSize.height, null);
                }
            }
        }
    }
}
*/


