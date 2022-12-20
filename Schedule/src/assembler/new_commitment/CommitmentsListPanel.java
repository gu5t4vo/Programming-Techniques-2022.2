package assembler.new_commitment;

import business.Commitment;
import business.ScheduleEnum;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.util.ArrayList;

public class CommitmentsListPanel extends JPanel {
    private final Date date;
    protected static ArrayList<CommitmentPanel> commitments;

    public CommitmentsListPanel(Date date, ArrayList<String> toDo) {
        GridLayout gridLayout = new GridLayout(6, 2);
        gridLayout.setVgap(10);
        gridLayout.setHgap(10);

        setLayout(gridLayout);

        this.date = date;

        setCommitments(toDo);
    }

    protected void setCommitments(ArrayList<String> toDo){
        commitments = new ArrayList<>();
        int index = 0;

        for (ScheduleEnum time: ScheduleEnum.values()) {
            Commitment commitment;

            try {
                commitment = new Commitment(date, time.getTime(), toDo.get(index));
            } catch (NullPointerException | IndexOutOfBoundsException exception){
                commitment = new Commitment(date, time.getTime(), "");
            }
            CommitmentPanel commitmentPanel = new CommitmentPanel(commitment);

            commitments.add(commitmentPanel);
            add(commitmentPanel);
            index++;
        }
    }

    public Date getDate() {
        return date;
    }
}
