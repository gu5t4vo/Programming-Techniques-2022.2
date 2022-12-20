package assembler.show_commitments_by_date;

import assembler.GUI;
import assembler.init_screen.btns.NewCommitmentBtn;
import assembler.new_commitment.DateScreen;
import assembler.new_commitment.NewCommitmentsScreen;
import assembler.new_commitment.SendBtn;
import business.Commitment;
import business.Schedule;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

public class DateBtn extends JButton implements ActionListener {
    private final Commitment commitment;

    public DateBtn(Commitment commitment) {
        this.commitment = commitment;

        setText(commitment.dateToString());
        addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DateScreen.date = commitment.getDate();
        NewCommitmentsScreen.title.setText
                ("<html>Commitments " + commitment.dateToString() + "<br><br></html>");
        GUI.getNewCommitmentsScreen().setVisible(true);

        ArrayList<String> tasks = new ArrayList<>();
        ArrayList<Commitment> commitmentsDB = Schedule.list();

        if (commitmentsDB != null) {
            for (Commitment commitment : commitmentsDB) {

                if (commitment.getDate().equals(DateScreen.date)) {
                    tasks.add(commitment.toDo);
                }
            }
        }

        GUI.getNewCommitmentsScreen().putBtn(tasks.size() != 0);

        GUI.getNewCommitmentsScreen().putCommitmentListPanel(tasks);

        setVisible(false);
    }

}
