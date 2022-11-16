package goal;

import assembler.counters.CounterPanel;
import assembler.footer.sec_panels.StartZone;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class InGoal extends GoalComponent {

    public InGoal(int linePosition, int columPosition, CounterPanel counterPanel, StartZone startZone) {
        super(linePosition, columPosition, counterPanel, startZone);

        setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/GoalWeb.png"))));
    }

    @Override
    public void actionPerformed(ActionEvent e){
        super.actionPerformed(e);

        if (counterPanel.playerCont % 2 == 0) {
            counterPanel.getP1().goalPp();
        } else {
            counterPanel.getP2().goalPp();
        }
    }

}
