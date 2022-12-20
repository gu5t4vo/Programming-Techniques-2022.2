package assembler.new_commitment;

import business.Commitment;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.sql.Time;

public class CommitmentPanel extends JPanel {

    private final JTextArea toDo;
    protected final Time time;
    protected Commitment commitment;

    public CommitmentPanel(Commitment commitment) {
        this.commitment = commitment;
        this.time = commitment.getTime();

        setLayout(new FlowLayout());

        JLabel timeLabel = new JLabel(time.toString());

        toDo = new JTextArea();
        toDo.setAlignmentY(TOP_ALIGNMENT);
        toDo.setLineWrap(true);
        toDo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        toDo.setColumns(20);
        toDo.setRows(2);
        toDo.setText(commitment.getToDo());

        add(timeLabel);
        add(toDo);
    }

    public Commitment getCommitment() {
        return commitment;
    }

    public JTextArea getToDo() {
        return toDo;
    }

}
