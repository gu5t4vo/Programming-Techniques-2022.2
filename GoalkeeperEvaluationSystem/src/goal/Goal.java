package goal;

import presentation.Colors;

import java.util.ArrayList;

public class Goal {

    protected ArrayList<Target> goal;
    protected Integer           width;
    protected Integer           high;

    public Goal(Integer width, Integer high){
        goal        = new ArrayList<>();

        this.width  = width;
        this.high   = high;

        createGoal();
    }

    private void createGoal(){
        for (int h = 0; h < high; h++) {
            for (int w = 0; w < width; w++) {
                if ((w == 0 || h == 0) || w == width - 1){
                    goal.add(new Target(GoalPosition.OUT, h, w));
                }
                else if ((w == 1 || h == 1) || w == width - 2){
                    goal.add(new Target(GoalPosition.GOAL_KICK, h, w));
                }
                else {
                    goal.add(new Target(GoalPosition.GOAL, h, w));
                }
            }

        }
    }

    public Integer getHigh() {
        return high;
    }

    public Integer getWidth() {
        return width;
    }

    public ArrayList<Target> getGoal() {
        return goal;
    }

    public int getQuadrant(Target goalCord){

        boolean isGoalArea = (goalCord.colum > 1 && goalCord.colum < width - 2) &&
                             (goalCord.line > 1);
        if (isGoalArea) {
            if (goalCord.line <= high / 2 && goalCord.colum < width / 2) {
                return 1;
            } else if (goalCord.line <= high / 2 && goalCord.colum >= width / 2) {
                return 2;
            } else if (goalCord.line > high / 2 && goalCord.colum < width / 2) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    public boolean isInDrawer(Target goalCord){
        return goalCord.line == 2 && (goalCord.colum == 2 || goalCord.colum == width - 3);
    }

    public GoalPosition getGoalPosition(Target target){
        if (target.out)
            return GoalPosition.OUT;
        if (target.goal)
            return GoalPosition.GOAL;

        return GoalPosition.GOAL_KICK;
    }

    public String toString(){

        int totTargets = 0;
        String goal    = "";

        for (int i = 0; i < getHigh(); i++) {
            for (int j = 0; j < getWidth(); j++) {

                Target target = getGoal().get(totTargets);
                String symbol = target.getSymbol();

                if (target.isOut()){
                    goal = goal.concat(Colors.ANSI_GREEN + symbol);
                }
                else {
                    goal = goal.concat(Colors.ANSI_RESET + symbol);
                }

                totTargets++;
            }
            goal = goal.concat("\n");
        }

        return goal + Colors.ANSI_RESET;
    }
}
