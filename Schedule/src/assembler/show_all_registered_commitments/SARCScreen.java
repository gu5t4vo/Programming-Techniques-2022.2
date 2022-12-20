package assembler.show_all_registered_commitments;

import assembler.Txt;
import business.Commitment;
import business.Schedule;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class SARCScreen extends JPanel {
    private ArrayList<Commitment> commitments;

    public SARCScreen() {
        setLayout(new BorderLayout());

        add(Txt.formattedJLabel("All Registered Commitments", "georgia", 25, 150),
                BorderLayout.NORTH
        );

        commitments = Schedule.list();
        JPanel commitmentPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(Objects.requireNonNull(Schedule.list()).size(), 3);
        gridLayout.setHgap(1);
        gridLayout.setVgap(1);
        commitmentPanel.setLayout(gridLayout);

        for (Commitment commitment: commitments) {
            commitmentPanel.add(
                    Txt.formattedJLabel(commitment.dateToString(), "georgia", 15, 100)
            );
            commitmentPanel.add(
                    Txt.formattedJLabel(commitment.timeToString(), "georgia", 15, 50)
            );
            commitmentPanel.add(
                    Txt.formattedJLabel(commitment.toDo, "georgia", 15, 220)
            );
        }

        add(commitmentPanel, BorderLayout.CENTER);
    }
}
