package assembler.export_commitments;

import business.Commitment;
import business.Schedule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ExportBtn extends JButton implements ActionListener {
    private final Commitment commitment;

    public ExportBtn(Commitment commitment) {
        this.commitment = commitment;

        ImageIcon download =
                new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/Download.png")));

        setIcon(download);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Schedule schedule = new Schedule();
        schedule.saveSchedule(commitment.getDate());
        setEnabled(false);
    }
}
