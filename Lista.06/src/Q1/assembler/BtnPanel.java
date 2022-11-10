package Q1.assembler;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BtnPanel extends JPanel {

    public BtnPanel(ArrayList<JButton> jButtons){

        setLayout(new FlowLayout(FlowLayout.CENTER));

        for (JButton jButton: jButtons) {
            add(jButton);
        }
    }
}
