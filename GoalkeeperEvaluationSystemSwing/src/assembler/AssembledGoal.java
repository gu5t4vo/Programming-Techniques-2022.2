package assembler;

import assembler.footer.btns.StartBtn;
import components.DefPanel;
import goal.GameGoal;
import goal.GoalComponent;

import java.awt.*;

public class AssembledGoal extends DefPanel {

    protected GameGoal      gameGoal;

    public AssembledGoal(GameGoal gameGoal){

        this.gameGoal   = gameGoal;

        setLayout(new GridLayout(gameGoal.getHigh(), gameGoal.getWidth()));
        setSize(800, 500);
        addGoal();

        setVisible(true);
    }

    private void addGoal(){
        for (GoalComponent goalComponent: gameGoal.getGoal()){
            add(goalComponent);
        }
    }

    public void removeGoal(){
        for (GoalComponent goalComponent: gameGoal.getGoal()){
            remove(goalComponent);
        }
    }

    public GameGoal getGameGoal() {
        return gameGoal;
    }

}
