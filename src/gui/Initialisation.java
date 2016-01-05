package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Raphael KUMAR on 12/14/15.
 */
public class Initialisation extends JFrame {
    // The default width of the grid.
    protected static final int DEFAULT_WIDTH = 10;
    // The default depth of the grid.
    protected static final int DEFAULT_DEPTH = 10;

    public Initialisation(){
        setTitle("Pandemic initialisation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent nbMove = new MovementChoise();
        nbMove.setOpaque(true); //content panes must be opaque
        JComponent speedSlider = new SpeedSlider();
        speedSlider.setOpaque(true); //content panes must be opaque
        JComponent start = new Start(this);
        start.setOpaque(true);
        add(speedSlider, BorderLayout.CENTER);
        add(nbMove,BorderLayout.WEST);
        add(start, BorderLayout.SOUTH);
        /**/
        pack();
        setVisible(true);
    }

    public void closeInit() {
        setVisible(false);
        dispose();
    }


}
