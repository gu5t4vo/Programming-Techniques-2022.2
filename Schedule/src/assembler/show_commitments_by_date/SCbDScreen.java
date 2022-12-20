package assembler.show_commitments_by_date;

import assembler.Txt;
import business.Commitment;
import business.Schedule;

import javax.swing.*;
import java.awt.*;

public class SCbDScreen extends JPanel {
    public SCbDScreen() {
        setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titlePanel.add(Txt.formattedJLabel("Commitments by Date", "georgia", 25, 150));

        add(titlePanel, BorderLayout.NORTH);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.Y_AXIS));

        if (Schedule.listByDate().size() != 0) {
            for (Commitment commitment : Schedule.listByDate()) {
                DateBtn datesBtn = new DateBtn(commitment);
                datesBtn.setAlignmentX(CENTER_ALIGNMENT);
                datesBtn.setHorizontalTextPosition(SwingConstants.CENTER);

                btnPanel.add(datesBtn);
            }
            add(btnPanel, BorderLayout.CENTER);
        }
    }
}
