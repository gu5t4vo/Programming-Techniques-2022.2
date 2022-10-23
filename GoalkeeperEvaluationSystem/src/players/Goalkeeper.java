package players;

import goal.Goal;
import goal.GoalPosition;
import goal.Target;
import presentation.Colors;

import java.util.ArrayList;
import java.util.Random;

public class Goalkeeper {
    protected String                    name;
    protected int                       id;
    protected Target                    position;
    protected Goal                      goal;
    protected ArrayList<DefensePoint>   actingArea;
    protected final String              symbol  = Colors.ANSI_CYAN + " @ " + Colors.ANSI_RESET;
    protected boolean                   titular = false;

    protected int totDefenses;
    protected int totGoals;
    protected int totOuts;
    protected int totGoalKicks;

    // Physic stats
    protected int speed;
    protected int flexibility;
    protected int agility;
    protected int coordination;
    protected int force;
    protected int balance;
    protected int actingAreaSize;

    public Goalkeeper(String name, int id, Goal goal){
        this.name       = name;
        this.id         = id;
        this.goal       = goal;

        randomizePosition   ();
        randomizeStats      ();
        actingAreaSize =    ((speed * 3) + (flexibility * 2) + (agility * 3) +
                            (coordination * 2) + force + (balance * 2))/8;
        generateActingArea  ();
        verifyLateral       ();
    }

    public Goalkeeper(String name, int id, Goal goal, Target position){
        this.name       = name;
        this.id         = id;
        this.position   = position;
        this.goal       = goal;

        randomizeStats      ();
        actingAreaSize =    ((speed * 3) + (flexibility * 2) + (agility * 3) +
                            (coordination * 2) + force + (balance * 2))/8;
        generateActingArea  ();
        verifyLateral       ();
    }

    public Goalkeeper(String name, int id, Goal goal, Target position, int speed, int flexibility,
                      int agility, int coordination, int force, int balance){

        this.name           = name;
        this.id             = id;
        this.position       = position;
        this.goal           = goal;
        this.speed          = validateStats(speed);
        this.flexibility    = validateStats(flexibility);
        this.agility        = validateStats(agility);
        this.coordination   = validateStats(coordination);
        this.force          = validateStats(force);
        this.balance        = validateStats(balance);
        actingAreaSize      = ((speed * 3) + (flexibility * 2) + (agility * 3) +
                              (coordination * 2) + force + (balance * 2))/8;

        generateActingArea  ();
        verifyLateral       ();

    }

    public Goalkeeper(String name, int id, Goal goal, int speed, int flexibility,
                      int agility, int coordination, int force, int balance){

        this.name           = name;
        this.id             = id;
        this.goal           = goal;
        this.speed          = validateStats(speed);
        this.flexibility    = validateStats(flexibility);
        this.agility        = validateStats(agility);
        this.coordination   = validateStats(coordination);
        this.force          = validateStats(force);
        this.balance        = validateStats(balance);
        actingAreaSize      = ((speed * 3) + (flexibility * 2) + (agility * 3) +
                              (coordination * 2) + force + (balance * 2))/8;

        randomizePosition   ();
        generateActingArea  ();
        verifyLateral       ();

    }

    private void randomizeStats(){
        Random random = new Random();

        this.speed          = random.nextInt(1, 11);
        this.flexibility    = random.nextInt(1, 11);
        this.agility        = random.nextInt(1, 11);
        this.coordination   = random.nextInt(1, 11);
        this.force          = random.nextInt(1, 11);
        this.balance        = random.nextInt(1, 11);
    }

    private void randomizePosition(){
        Random random = new Random();

        this.position = new Target(
                GoalPosition.GOAL,
                random.nextInt(2, goal.getHigh()),
                random.nextInt(2, goal.getWidth() - 2)
        );
        position.setSymbol(Colors.ANSI_CYAN + " K " + Colors.ANSI_RESET);

    }

    public int validateStats(int stat){
        if (stat > 10){
            stat = 10;
        }
        else if (stat < 1){
            stat = 1;
        }

        return stat;
    }

    private void generateActingArea(){

        actingArea = new ArrayList<>();

        int linePos     = position.getLine ();
        int columPos    = position.getColum();

        for (int i = 0, fit = 0; i < actingAreaSize; i++, fit++) {

            linePos -= fit;

            DefensePoint defensePoint = new DefensePoint(
                    linePos,
                    columPos,
                    symbol
            );

            linePos += fit;

            if (goal.getQuadrant(position) == goal.getQuadrant(defensePoint)) {
                defensePoint.setGoal(true);
                defensePoint.setActingArea(true);
                defensePoint.setLateral(defensePoint.isLateral(actingArea.size() - 1));
                actingArea.add(defensePoint);
            }

            if (fit == 3){
                fit = -1;
                columPos++;
            }
            if (linePos < 2){
                linePos = 2;
            }
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public ArrayList<DefensePoint> getActingArea() {
        return actingArea;
    }

    private void verifyLateral(){
        int i = 0;

        for (DefensePoint defensePoint: actingArea) {
            defensePoint.setLateral(defensePoint.isLateral(i));
            i++;
        }
    }

    @Override
    public String toString() {
        return String.format("""
                =-=-=- GOALKEEPER INFO -=-=-=
                >> PERSONAL DATA
                -----------------------------
                >>> Name:   %s
                >>> Id:     %d
                =-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                >> STATS
                -----------------------------
                >>> Speed:          %d
                >>> Flexibility:    %d
                >>> Agility:        %d
                >>> Coordination:   %d
                >>> Force:          %d
                >>> Balance:        %d
                =-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                """, name, id, speed, flexibility, agility, coordination, force, balance);

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getTotKicks(){
        return (totOuts + totDefenses + totGoals);
    }

    public int getTotDefenses() {
        return totDefenses;
    }

    public int getTotGoals() {
        return totGoals;
    }

    public int getTotOuts() {
        return totOuts;
    }

    public int getTotGoalKicks() {
        return totGoalKicks;
    }
}
