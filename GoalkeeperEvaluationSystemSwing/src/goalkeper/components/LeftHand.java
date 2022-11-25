package goalkeper.components;

import assembler.counters.CounterPanel;
import assembler.footer.sec_panels.StartZone;
import goalkeper.DefensePoint;

public class LeftHand extends DefensePoint {
    public LeftHand(int linePosition, int columPosition, CounterPanel counterPanel, StartZone startZone) {
        super(linePosition, columPosition, counterPanel, startZone);
    }

    public void revel(){
        super.revel();

        setIcon(MainPositionsIcons.LEFT.icon);
    }
}
