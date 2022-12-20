package assembler.import_commitments;

import business.Commitment;
import business.Schedule;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;

public class CommitmentChooser extends JFileChooser implements ActionListener {
    public CommitmentChooser() {
        setFileSelectionMode(FILES_ONLY);
        setFileFilter(new FileNameExtensionFilter("Commitment files", "txt"));
        addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Schedule schedule = new Schedule();
        ArrayList<String> commitmentParts = schedule.getSchedule(getSelectedFile());

        Date date = Date.valueOf(commitmentParts.get(0));

        for (int i = 1; i < commitmentParts.size(); i += 2){
            Time time = Time.valueOf(commitmentParts.get(i));
            String toDo;
            try {
                toDo = commitmentParts.get(i + 1);
            } catch (IndexOutOfBoundsException exception){
                toDo = "";
            }

            Commitment commitment = new Commitment(date, time, toDo);
            commitment.insert();
        }
    }
}
