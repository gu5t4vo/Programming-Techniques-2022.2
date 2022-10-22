package goal;

public class Target {
    protected boolean   goal;
    protected boolean   goalKick;
    protected boolean   out;
    protected boolean   actingArea;
    protected int       line;
    protected int       colum;
    protected String    symbol;

    public Target(GoalPosition position, int line, int colum) {

        this.line   = line;
        this.colum  = colum;

        goal        = false;
        goalKick    = false;
        out         = false;

        if (position == GoalPosition.GOAL) {
            goal    = true;
            symbol = " # ";
        }
        else if (position == GoalPosition.GOAL_KICK){
            goalKick    = true;
            symbol = " T ";
        }
        else if (position == GoalPosition.OUT) {
            out     = true;
            symbol = " 0 ";
        }
    }

    public Target(int line, int colum, String symbol) {

        this.line   = line;
        this.colum  = colum;
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isOut() {
        return out;
    }

    public boolean isGoal() {
        return goal;
    }

    public boolean isGoalKick() {
        return goalKick;
    }

    public int getLine() {
        return line;
    }

    public int getColum() {
        return colum;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setGoal(boolean goal) {
        this.goal = goal;
    }

    public void setGoalKick(boolean goalKick) {
        this.goalKick = goalKick;
    }

    public void setOut(boolean out) {
        this.out = out;
    }

    public void setActingArea(boolean actingArea){
        this.actingArea = actingArea;
    }

    public boolean isActingArea() {
        return actingArea;
    }
}
