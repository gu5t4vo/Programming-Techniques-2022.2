package assembler.footer.btns;

import assembler.AssembledGoal;
import assembler.footer.sec_panels.StartZone;
import goal.GameGoal;
import goal.GoalComponent;
import goal.InGoal;
import goalkeper.components.DefenseArea;
import goalkeper.components.InitPosition;
import goalkeper.components.LeftHand;
import goalkeper.components.RightHand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ResetBtn extends JButton implements ActionListener {

    protected AssembledGoal assembledGoal;
    protected GameGoal      gameGoal;
    protected StartZone     startZone;
    protected ConfirmBtn    confirmBtn;

    public ResetBtn(String text, AssembledGoal assembledGoal, StartZone startZone, ConfirmBtn confirmBtn) {
        super(text);

        this.assembledGoal  = assembledGoal;
        this.confirmBtn     = confirmBtn;
        this.startZone      = startZone;
        this.gameGoal       = assembledGoal.getGameGoal();
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!confirmBtn.clicked) {
            setEnabled(false);
            confirmBtn.setEnabled(false);
        } else
            confirmBtn.setEnabled(true);

        for (int i = 0; i < gameGoal.getGoal().size(); i++) {

            GoalComponent goalComponent = gameGoal.getGoal().get(i);

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

            goalComponent.setEnabled(!goalComponent.isEnabled());
            goalComponent.clicked = false;
        }

        gameGoal.getCounterP1().reset();
        gameGoal.getCounterP1().setBackground(Color.ORANGE);
        gameGoal.getCounterP2().reset();
        gameGoal.getCounterP2().setBackground(Color.WHITE);

        startZone.getCardLayout().previous(startZone);

        gameGoal.getCounterPanel().playerCont = 0;
        startZone.resetTurns();

    }
}
