package goal;

import assembler.counters.Counter;
import assembler.counters.CounterPanel;
import assembler.footer.sec_panels.StartZone;
import goalkeper.DefensePoint;
import goalkeper.Goalkeeper;
import goalkeper.components.InitPosition;
import goalkeper.components.LeftHand;
import goalkeper.components.RightHand;

import java.util.ArrayList;

public class GameGoal implements DefenseGoalkeeper{
    protected final Integer             high;
    protected final Integer             width;
    protected ArrayList<GoalComponent>  goal;
    protected ArrayList<InGoal>         inGoalPart;

    protected Goalkeeper                goalkeeper;

    protected CounterPanel  counterPanel;
    protected StartZone     startZone;


    public GameGoal(int high, int width) {

        counterPanel    = new CounterPanel();

        inGoalPart      = new ArrayList<>();

        this.goal       = new ArrayList<>();
        this.high       = high;
        this.width      = width;
        this.startZone  = new StartZone(this);

        generateGoal();

        goalkeeper = new Goalkeeper(this);
        setDefensePoint();

    }

    public void generateGoal(){

        for (int i = 0; i < high; i++){
            for (int j = 0; j < width; j++){
                if (isBeam(j, i)){
                    goal.add(new Beam(i, j, counterPanel, startZone));
                }
                else if (isInGoal(j, i)){
                    InGoal inGoal = new InGoal(i, j, counterPanel, startZone);

                    goal.add(inGoal);
                    inGoalPart.add(inGoal);

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

    public void setDefensePoint(){
        int index = 0;

        for (GoalComponent goalComponent: goal) {
            for (DefensePoint defensePoint: goalkeeper.getActingArea().getActingAreaList()) {
                if (
                        defensePoint.getLinePosition() == goalComponent.getLinePosition() &&
                        defensePoint.getColumPosition() == goalComponent.getColumPosition()
                ){
                    goal.set(index, defensePoint);
                }
            }
            index++;
        }
    }

    @Deprecated
    @Override
    public void resetDefensePoints(Boolean newDefense) {
        goalkeeper.getActingArea().getActingAreaList().clear();
        goalkeeper.getActingArea().setMainPositions();

        int index = 0;

        for (GoalComponent goalComponent: goal){
            if (goalComponent.getClass() == LeftHand.class ||
                goalComponent.getClass() == RightHand.class ||
                goalComponent.getClass() == InitPosition.class){

                goal.set(index, new InGoal(goalComponent.linePosition, goalComponent.columPosition,
                        counterPanel, startZone));
            }
            index++;
        }

        if (newDefense)
            setDefensePoint();
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

    public StartZone getStartZone() {
        return startZone;
    }

    public ArrayList<InGoal> getInGoalPart() {
        return inGoalPart;
    }

    public Goalkeeper getGoalkeeper() {
        return goalkeeper;
    }
}
