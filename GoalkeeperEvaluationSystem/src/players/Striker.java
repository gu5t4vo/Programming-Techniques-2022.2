package players;

import goal.Goal;
import goal.GoalPosition;
import goal.Target;
import presentation.Colors;

import java.util.ArrayList;
import java.util.Random;

public class Striker {

    private int     force;
    private Target  kickPlace;
    private int     id;

    private final String defenseSymbol   = Colors.ANSI_RED + " D " + Colors.ANSI_RESET;
    private final String goalSymbol      = Colors.ANSI_RED + " X " + Colors.ANSI_RESET;
    private final String goalKickSymbol  = Colors.ANSI_RED + " T " + Colors.ANSI_RESET;
    private final String outSymbol       = Colors.ANSI_RED + " ! " + Colors.ANSI_RESET;

    private boolean goal        = false;
    private boolean goalKick    = false;
    private boolean out         = false;
    private boolean defense     = false;


    public Striker(String id){
        this.id = Integer.parseInt(id);
        setForce(new Random().nextInt(1, 11));

    }

    public Striker(int force){
        setForce(force);
    }

    public Striker(Target kickPlace){
        setForce(new Random().nextInt(1, 11));
        this.kickPlace = kickPlace;
    }

    public void setForce(int force) {
        if (force > 10)
            this.force = 10;
        else
            this.force = Math.max(force, 1);
    }

    private GoalPosition kickArea(Goal goal){

        for (Target area: goal.getGoal()) {
            if (area.getColum() == kickPlace.getColum() && area.getLine() == kickPlace.getLine()){
                return goal.getGoalPosition(area);
            }
        }

        return GoalPosition.OUT;
    }

    public void kick(Goal goal, Goalkeeper goalkeeper){
        Random rand = new Random();
        kickPlace   = new Target(rand.nextInt(0, goal.getHigh()), rand.nextInt(0, goal.getWidth()));

        ArrayList<DefensePoint> GAA = goalkeeper.getActingArea();

        if (kickArea(goal) == GoalPosition.GOAL){
            if (goalkeeper.actingAreaSize > 9 && isInActingArea(kickPlace, goalkeeper)){

                DefensePoint defensePoint  =
                        new DefensePoint(kickPlace.getLine(), kickPlace.getColum(), kickPlace.getSymbol());

                boolean lateral = true;

                for (int i = 0; i < goalkeeper.actingArea.size(); i++) {
                    if (defensePoint.getColum() == goalkeeper.actingArea.get(i).getColum() &&
                            defensePoint.getLine() == goalkeeper.actingArea.get(i).getLine()) {
                        lateral = defensePoint.isLateral(i);
                        break;
                    }
                }

                if (lateral && force > goalkeeper.force) {
                    kickPlace.setSymbol(this.goalSymbol);
                    this.goal = true;
                }
                else {
                    kickPlace.setSymbol(defenseSymbol);
                    this.defense = true;
                }

            }
            else {
                for (Target area: GAA) {
                    if ((area.getLine() == kickPlace.getLine() && area.getColum() == kickPlace.getColum()) &&
                            force <= goalkeeper.force){

                        kickPlace.setSymbol(defenseSymbol);
                        this.defense = true;
                        return;
                    }
                }
                kickPlace.setSymbol(goalSymbol);
                this.goal = true;
            }
            return;
        }
        else if (kickArea(goal) == GoalPosition.GOAL_KICK){
            kickPlace.setSymbol(goalKickSymbol);
            this.goalKick = true;
            return;
        }
        kickPlace.setSymbol(this.outSymbol);
        this.out = true;
    }

    private boolean isInActingArea(Target target, Goalkeeper goalkeeper){
        for (Target GAATargets: goalkeeper.actingArea) {
            if (GAATargets.getColum() == target.getColum() && GAATargets.getLine() == target.getLine()){
                return true;
            }
        }
        return false;
    }

    public String getDefenseSymbol() {
        return defenseSymbol;
    }

    public String getGoalSymbol() {
        return goalSymbol;
    }

    public int getForce() {
        return force;
    }

    public boolean isGoalKick() {
        return goalKick;
    }

    public boolean isGoal() {
        return goal;
    }

    public boolean isOut() {
        return out;
    }

    public boolean isDefense() {
        return defense;
    }

    public int getId() {
        return id;
    }
}
