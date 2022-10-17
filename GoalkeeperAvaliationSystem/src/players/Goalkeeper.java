package players;

import goal.Goal;
import goal.GoalPosition;
import goal.Target;

import java.util.ArrayList;
import java.util.Random;

public class Goalkeeper {
    protected String            name;
    protected int               id;
    protected Target            position;
    protected Goal              goal;
    protected ArrayList<Target> actingArea;
    protected final String      symbol = " @ ";

    // Physic stats
    protected int speed;
    protected int flexibility;
    protected int agility;
    protected int coordination;
    protected int force;
    protected int balance;

    public Goalkeeper(String name, int id, Goal goal){
        this.name       = name;
        this.id         = id;
        this.goal       = goal;

        randomizePosition   ();
        randomizeStats      ();
        generateActingArea  ();

    }

    public Goalkeeper(String name, int id, Goal goal, Target position){
        this.name       = name;
        this.id         = id;
        this.position   = position;
        this.goal       = goal;

        randomizeStats      ();
        generateActingArea  ();
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

        generateActingArea();

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

        int actingAreaSize =
                ((speed * 3) + (flexibility * 2) + (agility * 3) + (coordination * 2) + force + (balance * 2))/8;

        int linePos     = position.getLine ();
        int columPos    = position.getColum();

        for (int i = 0, fit = 0; i < actingAreaSize; i++, fit++) {

            linePos -= fit;
            if (linePos < 2){
                linePos = 2;
            }

            Target defensePoint = new Target(
                    linePos,
                    columPos,
                    symbol
            );

            if (goal.getQuadrant(position) == goal.getQuadrant(defensePoint)) {
                actingArea.add(defensePoint);
            }

            linePos += fit;

            if (fit == 3){
                fit = -1;
                columPos++;
            }

        }
    }

    public String getSymbol() {
        return symbol;
    }

    public ArrayList<Target> getActingArea() {
        return actingArea;
    }
}
