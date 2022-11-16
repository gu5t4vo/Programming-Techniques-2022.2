package assembler.counters;

import javax.swing.*;
import java.awt.*;

import static assembler.Txt.formattedJLabel;
import static assembler.Txt.formattedTxt;

public class Counter extends JPanel {

    public int kicks;
    public int defenses;
    public int outs;
    public int beams;
    public int goals;

    protected   Integer     player;

    private final JLabel kickLabel;
    private final JLabel defenseLabel;
    private final JLabel outLabel;
    private final JLabel beamLabel;
    private final JLabel goalLabel;

    protected Counter(int player) {

        this.player = player;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Font georgiaCounter = new Font("georgia", Font.PLAIN, 15);
        setFont(georgiaCounter);

        kickLabel       =  formattedJLabel(Score.KICKS      .getScore() + kicks);
        defenseLabel    =  formattedJLabel(Score.DEFENSES   .getScore() + defenses);
        outLabel        =  formattedJLabel(Score.OUTS       .getScore() + outs);
        beamLabel       =  formattedJLabel(Score.BEAM       .getScore() + beams);
        goalLabel       =  formattedJLabel(Score.GOALS      .getScore() + goals);

        add(formattedJLabel("PLAYER: " + player));
        add(kickLabel);
        add(defenseLabel);
        add(outLabel);
        add(beamLabel);
        add(goalLabel);
    }

    public JLabel getKickLabel() {
        return kickLabel;
    }

    public JLabel getDefenseLabel() {
        return defenseLabel;
    }

    public JLabel getOutLabel() {
        return outLabel;
    }

    public JLabel getBeamLabel() {
        return beamLabel;
    }

    public JLabel getGoalLabel() {
        return goalLabel;
    }

    public void kickPp(){
        kicks++;
    }

    public void defensePp(){
        defenses++;
    }

    public void outPp(){
        outs++;
    }

    public void beamPp(){
        beams++;
    }

    public void goalPp(){
        goals++;
    }

    public void reset(){
        kicks       = 0;
        defenses    = 0;
        outs        = 0;
        beams       = 0;
        goals       = 0;

        kickLabel   .setText(formattedTxt(Score.KICKS   .getScore()     + kicks));
        defenseLabel.setText(formattedTxt(Score.DEFENSES.getScore()     + defenses));
        outLabel    .setText(formattedTxt(Score.OUTS    .getScore()     + outs));
        beamLabel   .setText(formattedTxt(Score.BEAM    .getScore()     + beams));
        goalLabel   .setText(formattedTxt(Score.GOALS   .getScore()     + goals));
    }



}
