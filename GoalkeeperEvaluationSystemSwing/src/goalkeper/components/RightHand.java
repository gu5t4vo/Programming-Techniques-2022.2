package goalkeper.components;

import assembler.counters.CounterPanel;
import assembler.footer.sec_panels.StartZone;
import goalkeper.DefensePoint;

public class RightHand extends DefensePoint {
    public RightHand(int linePosition, int columPosition, CounterPanel counterPanel, StartZone startZone) {
        super(linePosition, columPosition, counterPanel, startZone);
    }

    public void revel(){
        super.revel();

        setIcon(MainPositionsIcons.RIGHT.icon);
    }
}
