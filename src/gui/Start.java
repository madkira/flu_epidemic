package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Raphael KUMAR on 1/5/16.
 */
public class Start extends JPanel implements ActionListener {
    JButton start;
    Initialisation init;

    public Start(Initialisation init){
        this.init = init;
        start = new JButton("Start Simulation");
        start.addActionListener(this);
        add(start);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        init.closeInit();
        new Simulation();
    }
}
