package assembler.show_all_registered_commitments;

import javax.swing.*;

public class SARCScrollPane extends JScrollPane {
    public SARCScrollPane() {
        setViewportView(new SARCScreen());
        setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
    }
}
