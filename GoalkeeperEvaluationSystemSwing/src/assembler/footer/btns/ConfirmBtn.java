package assembler.footer.btns;

import assembler.counters.CounterPanel;
import assembler.counters.Score;
import goal.GameGoal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static assembler.Txt.formattedTxt;

public class ConfirmBtn extends JButton implements ActionListener {

    protected GameGoal      gameGoal;
    protected CounterPanel  counterPanel;
    public ConfirmBtn(String text, GameGoal gameGoal, CounterPanel counterPanel) {
        super(text);
        this.counterPanel   = counterPanel;
        this.gameGoal       = gameGoal;

        addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JLabel defenseLabelP1   = counterPanel.getP1().getDefenseLabel();
        JLabel outsLabelP1      = counterPanel.getP1().getOutLabel();
        JLabel beamsLabelP1     = counterPanel.getP1().getBeamLabel();
        JLabel goalsLabelP1     = counterPanel.getP1().getGoalLabel();

        defenseLabelP1  .setText(formattedTxt(Score.DEFENSES.getScore()     + counterPanel.getP1().defenses));
        outsLabelP1     .setText(formattedTxt(Score.OUTS    .getScore()     + counterPanel.getP1().outs));
        beamsLabelP1    .setText(formattedTxt(Score.BEAM    .getScore()     + counterPanel.getP1().beams));
        goalsLabelP1    .setText(formattedTxt(Score.GOALS   .getScore()     + counterPanel.getP1().goals));

        JLabel defenseLabelP2   = counterPanel.getP2().getDefenseLabel();
        JLabel outsLabelP2      = counterPanel.getP2().getOutLabel();
        JLabel beamsLabelP2     = counterPanel.getP2().getBeamLabel();
        JLabel goalsLabelP2     = counterPanel.getP2().getGoalLabel();

        defenseLabelP2  .setText(formattedTxt(Score.DEFENSES.getScore()     + counterPanel.getP2().defenses));
        outsLabelP2     .setText(formattedTxt(Score.OUTS    .getScore()     + counterPanel.getP2().outs));
        beamsLabelP2    .setText(formattedTxt(Score.BEAM    .getScore()     + counterPanel.getP2().beams));
        goalsLabelP2    .setText(formattedTxt(Score.GOALS   .getScore()     + counterPanel.getP2().goals));
    }
}
