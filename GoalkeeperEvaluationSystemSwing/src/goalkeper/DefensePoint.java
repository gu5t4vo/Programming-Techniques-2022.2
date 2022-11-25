package goalkeper;

import assembler.counters.CounterPanel;
import assembler.footer.sec_panels.StartZone;
import goal.InGoal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public abstract class DefensePoint extends InGoal {

    private boolean clicked;

    protected Color color;

    public DefensePoint(int linePosition, int columPosition, CounterPanel counterPanel, StartZone startZone) {
        super(linePosition, columPosition, counterPanel, startZone);

        clicked = false;
        color = Color.BLUE;

    }

    public void actionPerformed(ActionEvent e){
        super.actionPerformed(e);

        if (!clicked) {
            if (counterPanel.playerCont % 2 == 1) {
                counterPanel.getP1().defensePp();
            } else {
                counterPanel.getP2().defensePp();
            }
            clicked = true;
        }
    }

    public Color getColor() {
        return color;
    }

    public void revel(){
        this.setBackground(color);
        setClicked(false);
    }

    public void cover(){

        this.setBackground(Color.GREEN);
        setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/GoalWeb.png"))));

    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
}
