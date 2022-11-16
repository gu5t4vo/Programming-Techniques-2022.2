package assembler.counters;

import javax.swing.*;
import java.awt.*;

public class CounterPanel extends JPanel {

    private final Counter p1;
    private final Counter p2;

    public        int     playerCont;

    public CounterPanel() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        p1  = new Counter(1);
        add(p1);

        add(new JLabel("----------------------------"), BorderLayout.CENTER);

        p2  = new Counter(2);
        add(p2);
    }

    public Counter getP1() {
        return p1;
    }

    public Counter getP2() {
        return p2;
    }
}
