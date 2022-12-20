package assembler.new_commitment;

import assembler.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NewCommitmentsScreen extends JPanel implements ActionListener {
    private CommitmentsListPanel commitmentsListPanel;
    public static JLabel title;

    public NewCommitmentsScreen(){
        setLayout(new BorderLayout());

        title = new JLabel();
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("georgia", Font.BOLD, 25));

        add(title, BorderLayout.NORTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (CommitmentPanel commitmentPanel: CommitmentsListPanel.commitments) {

            commitmentPanel.commitment.toDo = commitmentPanel.getToDo().getText();
            commitmentPanel.getCommitment().insert();

        }

        GUI.getInitScreen().setVisible(true);
        setVisible(false);
    }

    public CommitmentsListPanel getCommitmentsListPanel() {
        return commitmentsListPanel;
    }

    public void putCommitmentListPanel(ArrayList<String> toDo){
        commitmentsListPanel = new CommitmentsListPanel(DateScreen.date, toDo);
        add(commitmentsListPanel, BorderLayout.CENTER);
    }

    public void putBtn(Boolean update){
        if (update){

            UpdateBtn updateBtn = new UpdateBtn();
            add(updateBtn, BorderLayout.SOUTH);

        } else {
            JButton send = new JButton("Send");
            send.addActionListener(this);
            add(send, BorderLayout.SOUTH);
        }
    }
}
