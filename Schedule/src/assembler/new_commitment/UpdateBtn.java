package assembler.new_commitment;

import assembler.GUI;
import business.Commitment;
import business.Schedule;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class UpdateBtn extends JButton implements ActionListener {

    public UpdateBtn() {

        setText("Update");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<CommitmentPanel> commitmentPanels = CommitmentsListPanel.commitments;

        int index = 0;

        for (Commitment commitment: Objects.requireNonNull(Schedule.list())) {
            if (DateScreen.date.equals(commitment.getDate())) {
                commitmentPanels.get(index).commitment.toDo = commitmentPanels.get(index).getToDo().getText();

                commitment.update(commitmentPanels.get(index).commitment);
                index++;
            }
        }
        GUI.getInitScreen().setVisible(true);
        GUI.getNewCommitmentsScreen().setVisible(false);
    }
}
