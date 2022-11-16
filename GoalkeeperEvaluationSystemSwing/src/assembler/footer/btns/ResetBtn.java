package assembler.footer.btns;

import goal.GameGoal;
import goal.GoalComponent;
import goal.InGoal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ResetBtn extends JButton implements ActionListener {

    protected GameGoal gameGoal;

    public ResetBtn(String text, GameGoal gameGoal) {
        super(text);
        this.gameGoal = gameGoal;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (GoalComponent goalComponent: gameGoal.getGoal()) {
            if (goalComponent.getClass() == InGoal.class){

                goalComponent.setIcon(
                        new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/GoalWeb.png"))));

            }
            else
                goalComponent.setIcon(null);
        }

        gameGoal.getCounterP1().reset();
        gameGoal.getCounterP2().reset();
    }
}
