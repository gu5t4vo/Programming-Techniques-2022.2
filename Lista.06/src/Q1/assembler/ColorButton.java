package Q1.assembler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorButton extends JButton implements ActionListener {

    protected ColorPanel    colorPanel;
    protected Color         color;

    public ColorButton(Color color, String txt, ColorPanel colorPanel){
        setBackground(color);
        setText(txt);

        this.colorPanel = colorPanel;
        this.color      = color;

        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        colorPanel.setBackground(color);
    }
}
