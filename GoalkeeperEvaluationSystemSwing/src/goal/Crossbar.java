package goal;

import assembler.counters.CounterPanel;
import assembler.footer.sec_panels.StartZone;

import java.awt.*;
import java.awt.event.ActionEvent;

public class Crossbar extends GoalComponent{

    public Crossbar(int linePosition, int columPosition, CounterPanel counterPanel, StartZone startZone) {
        super(linePosition, columPosition, counterPanel, startZone);

        setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        super.actionPerformed(e);

        if (counterPanel.playerCont % 2 == 0) {
            counterPanel.getP1().beamPp();
        } else {
            counterPanel.getP2().beamPp();
        }
    }

}
