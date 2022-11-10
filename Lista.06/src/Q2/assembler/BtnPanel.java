package Q2.assembler;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BtnPanel extends JPanel {

    public BtnPanel(ArrayList<NameBtn> jButtons) {

        setLayout(new FlowLayout(FlowLayout.CENTER));

        for (NameBtn jButton: jButtons) {
            add(jButton);
        }

        setVisible(true);

    }
}
