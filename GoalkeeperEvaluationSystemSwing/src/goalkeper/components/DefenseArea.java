package goalkeper.components;

import assembler.counters.CounterPanel;
import assembler.footer.sec_panels.StartZone;
import goalkeper.DefensePoint;

public class DefenseArea extends DefensePoint {
    public DefenseArea(int linePosition, int columPosition, CounterPanel counterPanel, StartZone startZone) {
        super(linePosition, columPosition, counterPanel, startZone);
    }
}
