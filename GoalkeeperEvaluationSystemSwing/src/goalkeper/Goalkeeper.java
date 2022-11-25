package goalkeper;

import goal.GameGoal;

public class Goalkeeper {

    protected ActingArea actingArea;

    public Goalkeeper(GameGoal gameGoal) {

        actingArea = new ActingArea(gameGoal);

    }

    public void revel(){
        for (DefensePoint defensePoint: actingArea.actingAreaList) {
            defensePoint.revel();
        }
    }

    public void cover(){
        for (DefensePoint defensePoint: actingArea.actingAreaList) {
            defensePoint.cover();
        }
    }

    public ActingArea getActingArea() {
        return actingArea;
    }
}
