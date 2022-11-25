package assembler.footer.btns;

import assembler.AssembledGoal;
import assembler.footer.sec_panels.FooterMenu;
import assembler.footer.sec_panels.StartZone;
import goal.GameGoal;
import goal.GoalComponent;
import goal.InGoal;
import goalkeper.DefensePoint;
import goalkeper.components.DefenseArea;
import goalkeper.components.InitPosition;
import goalkeper.components.LeftHand;
import goalkeper.components.RightHand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class StartBtn extends JButton implements ActionListener {

    protected StartZone     startZone;
    protected AssembledGoal assembledGoal;

    protected GameGoal      gameGoal;

    public StartBtn(GameGoal gameGoal) {
        setText("START");

        this.gameGoal   = gameGoal;
        this.startZone  = gameGoal.getStartZone();

        setFont(new Font("georgia", Font.BOLD, 25));

        assembledGoal  = new AssembledGoal(gameGoal);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        assembledGoal.getGameGoal().getCounterPanel().getP1().setBackground(Color.ORANGE);

        for (GoalComponent goalComponent: gameGoal.getGoal()) {
            if (goalComponent.getClass() == InGoal.class ||
                goalComponent.getClass() == LeftHand.class ||
                goalComponent.getClass() == RightHand.class ||
                goalComponent.getClass() == InitPosition.class ||
                goalComponent.getClass() == DefenseArea.class
            ){

                goalComponent.setIcon(
                        new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/GoalWeb.png"))));
                goalComponent.setBackground(Color.GREEN);

            }
            else
                goalComponent.setIcon(null);

            goalComponent.setEnabled(true);

        }

        gameGoal.getCounterP1().reset();
        gameGoal.getCounterP1().setBackground(Color.ORANGE);
        gameGoal.getCounterP2().reset();
        gameGoal.getCounterP2().setBackground(Color.WHITE);
    }


    public AssembledGoal getAssembledGoal() {
        return assembledGoal;
    }
}
