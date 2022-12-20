package assembler.export_commitments;

import assembler.Txt;
import assembler.show_commitments_by_date.DateBtn;
import business.Commitment;
import business.Schedule;

import javax.swing.*;
import java.awt.*;

public class ExportScreen extends JPanel {

    public ExportScreen() {
        setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titlePanel.add(Txt.formattedJLabel("Export Commitments", "georgia", 25, 150));

        add(titlePanel, BorderLayout.NORTH);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(Schedule.listByDate().size(), 1));

        for (Commitment commitment: Schedule.listByDate()) {
            JPanel downloadPanel = new JPanel();
            downloadPanel.setLayout(new FlowLayout());

            ExportBtn exportBtn = new ExportBtn(commitment);
            exportBtn.setAlignmentX(CENTER_ALIGNMENT);
            exportBtn.setHorizontalTextPosition(SwingConstants.CENTER);

            downloadPanel.add(Txt.formattedJLabel(commitment.dateToString(), "georgia", 15, 100));
            downloadPanel.add(exportBtn);

            btnPanel.add(downloadPanel);
        }

        add(btnPanel, BorderLayout.CENTER);
    }
}
