package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Raphael KUMAR on 1/5/16.
 */
public class MovementChoise extends JPanel implements ActionListener {
    private String four = Main.FOUR + " Mouvements";
    private String eight = Main.EIGHT + " Mouvements";
    JRadioButton fourMovement;
    JRadioButton eightMovement;

    MovementChoise(){
        fourMovement = new JRadioButton(four);
        fourMovement.addActionListener(this);
        fourMovement.setSelected(true);
        eightMovement = new JRadioButton(eight);
        eightMovement.addActionListener(this);

        ButtonGroup group = new ButtonGroup();
        group.add(fourMovement);
        group.add(eightMovement);
        JPanel radioPanel = new JPanel(new GridLayout(2,1));
        radioPanel.add(fourMovement);
        radioPanel.add(eightMovement);

        add(radioPanel, BorderLayout.SOUTH);
    }




    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand() == four) {
            Main.KINDOFMOV = Main.FOUR;
        } else {
            Main.KINDOFMOV = Main.EIGHT;
        }
    }
}
