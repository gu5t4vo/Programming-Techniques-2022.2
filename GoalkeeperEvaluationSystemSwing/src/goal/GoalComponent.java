package goal;

import assembler.Txt;
import assembler.counters.CounterPanel;
import assembler.footer.sec_panels.StartZone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public abstract class GoalComponent extends JButton implements ActionListener {

    protected   int             linePosition;
    protected   int             columPosition;
    protected   CounterPanel    counterPanel;
    protected   StartZone       startZone;


    public GoalComponent(int linePosition, int columPosition, CounterPanel counterPanel, StartZone startZone){

        this.startZone      = startZone;
        this.linePosition   = linePosition;
        this.columPosition  = columPosition;
        this.counterPanel   = counterPanel;

        this.setBackground(Color.green);
        addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        counterPanel.playerCont++;
        ImageIcon ball;

        if (counterPanel.playerCont % 2 == 1) {

            counterPanel.getP1().setBackground(Color.WHITE);
            ball = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/Ball.png")));
            counterPanel.getP1().kickPp();
            counterPanel.getP1().getKickLabel().setText(Txt.formattedTxt("KICKS: " + counterPanel.getP1().kicks));
            counterPanel.getP2().setBackground(Color.ORANGE);

        } else {

            counterPanel.getP2().setBackground(Color.WHITE);
            ball = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/Ball2.png")));
            counterPanel.getP2().kickPp();
            counterPanel.getP2().getKickLabel().setText(Txt.formattedTxt("KICKS: " + counterPanel.getP2().kicks));
            counterPanel.getP1().setBackground(Color.ORANGE);

        }
        setIcon(ball);

        startZone.passTurn();

    }

    public int getLinePosition() {
        return linePosition;
    }

    public int getColumPosition() {
        return columPosition;
    }

}
