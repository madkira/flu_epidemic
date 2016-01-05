package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Raphael KUMAR on 12/14/15.
 */
public class Simulation extends JFrame{

    Simulation(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent speedSlider = new SpeedSlider();
        speedSlider.setOpaque(true); //content panes must be opaque

        add(speedSlider, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }
}
