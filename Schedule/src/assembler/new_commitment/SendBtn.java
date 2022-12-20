package assembler.new_commitment;

import assembler.GUI;
import assembler.init_screen.btns.NewCommitmentBtn;
import business.Commitment;
import business.Schedule;
import presentation.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

public class SendBtn extends JButton implements ActionListener {
    public SendBtn() {
        setText("Send");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DateScreen.date = Date.valueOf(DateScreen.getDateField().toString());
        NewCommitmentsScreen.title.setText
                ("<html>Commitments " + DateScreen.getDateField().toDateString() + "<br><br></html>");
        GUI.getNewCommitmentsScreen().setVisible(true);
        NewCommitmentBtn.getDateScreen().dispose();

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

        Main.gui.setVisible(true);
    }

}
