package assembler;

import javax.swing.*;

public class Instructions extends JPanel {

    public Instructions() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Txt.formattedJLabel("How to play:"));
        add(Txt.formattedJLabel("1. Click on one or more parts of the goal to kick"));
        add(Txt.formattedJLabel("2. When you're done, click the CONFIRM button"));
        add(Txt.formattedJLabel("3. If you want to reset your kicks, click the RESET button"));

    }

}
