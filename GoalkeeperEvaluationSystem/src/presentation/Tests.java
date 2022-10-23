package presentation;

import goal.Goal;
import goal.Target;
import players.Goalkeeper;
import players.Striker;

import java.util.ArrayList;
import java.util.Random;


public class Tests {

    public static void main(String[] args) {
        Goal                goal         = new Goal(18, 10);
        Goalkeeper          goalkeeper   = new Goalkeeper("Josh", 1, goal);

        /*Goalkeeper          goalkeeper   = new Goalkeeper("Josh", 1, goal,10, 10, 10,
                                                                10, 10, 10);*/

        int                 randKick     = new Random().nextInt(0, goal.getGoal().size());
        Striker             striker      = new Striker(randKick);

        System.out.println("KICK FORCE: " + striker.getForce());
        System.out.println(goalkeeper);
        System.out.println(goal);
        System.out.println(Colors.ANSI_RESET + "==================================================");

        for (int i = 0; i < goal.getGoal().size(); i++) {

            ArrayList<Target> goalTargets   = goal.getGoal();
            int               quadrant      = goal.getQuadrant(goalTargets.get(i));

            switch (quadrant) {
                case 1 -> goalTargets.get(i).setSymbol(" 1 ");
                case 2 -> goalTargets.get(i).setSymbol(" 2 ");
                case 3 -> goalTargets.get(i).setSymbol(" 3 ");
                case 4 -> goalTargets.get(i).setSymbol(" 4 ");
            }
        }

        System.out.println(Colors.ANSI_RESET + "==================================================");
        System.out.println(goal);

        for (int i = 0; i < goal.getGoal().size(); i++) {
            for (int j = 0; j < goalkeeper.getActingArea().size(); j++){

                Target GAATarget    = goalkeeper.getActingArea().get(j);
                Target goalTarget   = goal.getGoal().get(i);

                if (GAATarget.getColum() == goalTarget.getColum() && GAATarget.getLine() == goalTarget.getLine()){

                    goal.getGoal().set(i, GAATarget);
                    break;
                }
            }
        }

        System.out.println(goal);
        System.out.println(Colors.ANSI_RESET + "==================================================");


    }
}
