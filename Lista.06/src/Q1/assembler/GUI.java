package Q1.assembler;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JFrame {

    protected ColorPanel colorPanel;

    public GUI(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(500, 500);
        setLayout(new BorderLayout());

        colorPanel = new ColorPanel();

        ArrayList<JButton> jButtons = new ArrayList<>();
        BtnPanel btnPanel;

        add(colorPanel, BorderLayout.CENTER);

        jButtons.add(new ColorButton(Color.GREEN, "GREEN", colorPanel));
        jButtons.add(new ColorButton(Color.BLUE, "BLUE", colorPanel));
        jButtons.add(new ColorButton(Color.yellow, "YELLOW", colorPanel));

        btnPanel = new BtnPanel(jButtons);

        add(btnPanel, BorderLayout.NORTH);

        setVisible(true);
    }
}
