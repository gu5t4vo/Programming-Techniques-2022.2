package goal;

import assembler.AssembledGoal;
import assembler.counters.Counter;
import assembler.counters.CounterPanel;
import assembler.footer.Footer;
import assembler.footer.sec_panels.StartZone;

import java.util.ArrayList;

public class GameGoal {
    protected final Integer               high;
    protected final Integer               width;
    protected ArrayList<GoalComponent>    goal;
    protected CounterPanel  counterPanel;
    protected Footer        footer;


    public GameGoal(int high, int width) {


        counterPanel    = new CounterPanel();

        this.goal       = new ArrayList<>();
        this.high       = high;
        this.width      = width;
        footer          = new Footer(this);

        generateGoal();

    }

    public void generateGoal(){
        StartZone startZone = footer.getFooterMenu().getStartZone();

        for (int i = 0; i < high; i++){
            for (int j = 0; j < width; j++){
                if (isBeam(j, i)){
                    goal.add(new Beam(i, j, counterPanel, startZone));
                }
                else if (isInGoal(j, i)){
                    goal.add(new InGoal(i, j, counterPanel, startZone));
                }
                else if (isCrossbar(j, i)){
                    goal.add(new Crossbar(i, j, counterPanel, startZone));
                }
                else if (isOut(j, i)){
                    goal.add(new Out(i, j, counterPanel, startZone));
                }
            }
        }
    }

    private Boolean isInGoal(Integer columPosition, Integer linePosition){

        Boolean validColumns    =
                columPosition >= 2 && columPosition < width - 2;

        Boolean validLines      =
                linePosition >= 2 && linePosition < high;

        return validLines && validColumns;
    }

    private Boolean isBeam(Integer columPosition, Integer linePosition){

        Boolean validColumns    =
                columPosition == 1 || columPosition == width - 2;

        Boolean validLines      =
                linePosition >= 2 || linePosition.equals(high - 1);

        return validLines && validColumns;
    }

    private Boolean isCrossbar(Integer columPosition, Integer linePosition){

        Boolean validColumns    =
                columPosition >= 1 && columPosition <= width - 2;
        Boolean validLines      =
                linePosition == 1;

        return validLines && validColumns;
    }

    private Boolean isOut(Integer columPosition, Integer linePosition){

        return
                columPosition == 0 || columPosition == width - 1 || linePosition == 0;
    }

    public Integer getHigh() {
        return high;
    }

    public Integer getWidth() {
        return width;
    }

    public ArrayList<GoalComponent> getGoal() {
        return goal;
    }

    public CounterPanel getCounterPanel() {
        return counterPanel;
    }

    public Counter getCounterP1() {
        return counterPanel.getP1();
    }

    public Counter getCounterP2() {
        return counterPanel.getP2();
    }

    public Footer getFooter() {
        return footer;
    }
}
