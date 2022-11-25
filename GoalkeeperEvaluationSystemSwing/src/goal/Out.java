package goal;

import assembler.counters.CounterPanel;
import assembler.footer.sec_panels.StartZone;

import java.awt.event.ActionEvent;

public class Out extends GoalComponent{

    public Out(int linePosition, int columPosition, CounterPanel counterPanel,
               StartZone startZone) {
        super(linePosition, columPosition, counterPanel, startZone);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        super.actionPerformed(e);

        if (!clicked) {
            if (counterPanel.playerCont % 2 == 0) {
                counterPanel.getP1().outPp();
            } else {
                counterPanel.getP2().outPp();
            }

            clicked = true;
        }

    }

}
