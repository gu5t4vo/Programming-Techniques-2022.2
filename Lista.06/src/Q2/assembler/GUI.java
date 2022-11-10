package Q2.assembler;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JFrame {

    protected JLabel jLabel;

    public GUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(new BorderLayout());
        jLabel = new JLabel("Try to Click!");

        ArrayList<NameBtn> buttons = new ArrayList<>();

        buttons.add(new NameBtn("Java",         jLabel));
        buttons.add(new NameBtn("JavaScrip",    jLabel));
        buttons.add(new NameBtn("C++",          jLabel));
        buttons.add(new NameBtn("Python",       jLabel));

        add(jLabel, BorderLayout.NORTH);
        add(new BtnPanel(buttons), BorderLayout.CENTER);

        setVisible(true);
    }
}
