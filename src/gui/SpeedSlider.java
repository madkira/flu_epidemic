package gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Raphael KUMAR on 1/5/16.
 */
public class SpeedSlider extends JPanel implements ChangeListener {
    JSlider speedSlide;

    public SpeedSlider(){
        super(new BorderLayout());
        JLabel sliderLabel = new JLabel("Speed of execution");
        speedSlide = new JSlider(JSlider.HORIZONTAL,
                Main.FPS_MIN, Main.FPS_MAX, Main.ACTUAL_FPS);
        speedSlide.setPreferredSize(new Dimension(200, 80));
        add(sliderLabel,BorderLayout.NORTH);
        add(speedSlide, BorderLayout.CENTER);

        speedSlide.setMajorTickSpacing(10);
        speedSlide.setMinorTickSpacing(0);
        speedSlide.setPaintTicks(true);
        speedSlide.setPaintLabels(true);
        speedSlide.setBorder(
                BorderFactory.createEmptyBorder(0,0,10,0));
        Font font = new Font("Serif", Font.ITALIC, 15);
        speedSlide.setFont(font);
        speedSlide.addChangeListener(this);
    }


    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        JSlider source = (JSlider)changeEvent.getSource();
        if (!source.getValueIsAdjusting()) {
            Main.setActualFps((int)source.getValue());
        }
    }
}
