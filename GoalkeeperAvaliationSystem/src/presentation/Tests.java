package presentation;

import goal.Goal;
import goal.GoalPosition;
import goal.Target;
import players.Goalkeeper;

import java.util.ArrayList;

public class Tests {

    public static void main(String[] args) {
        Goal        goal         = new Goal(18, 10);
        int         totTargets   = 0;
/*
        Goalkeeper  goalkeeper   = new Goalkeeper("Josh", 1, goal);
*/

        Goalkeeper  goalkeeper   = new Goalkeeper("Josh", 1, goal, new Target(GoalPosition.GOAL,
                8, 10), 10, 10, 6, 10, 10, 10);
        for (int i = 0; i < goal.getHigh(); i++) {
            for (int j = 0; j < goal.getWidth(); j++) {

                Target target = goal.getGoal().get(totTargets);
                String symbol = target.getSymbol();

                if (target.isOut()){
                    System.out.print(Colors.ANSI_GREEN.ansiEscapeCode + symbol);
                }
                else {
                    System.out.print(Colors.ANSI_RESET.ansiEscapeCode + symbol);
                }

                totTargets++;
            }
            System.out.println();
        }

        totTargets = 0;
        System.out.println(Colors.ANSI_RESET + "==================================================");

        for (int i = 0; i < goal.getHigh(); i++) {
            for (int j = 0; j < goal.getWidth(); j++) {

                ArrayList<Target> targets   = goal.getGoal();
                String symbol               = targets.get(totTargets).getSymbol();

                if (symbol.equals(" # ")){
                    symbol = " " + goal.getQuadrant(targets.get(totTargets)) + " ";
                }

                if (goal.isInDrawer(targets.get(totTargets))){
                    symbol = " G ";
                }

                if (targets.get(totTargets).isOut()){
                    System.out.print(Colors.ANSI_GREEN.ansiEscapeCode + symbol);
                }
                else {
                    System.out.print(Colors.ANSI_RESET.ansiEscapeCode + symbol);
                }
                totTargets++;
            }
            System.out.println();
        }

        totTargets = 0;
        System.out.println(Colors.ANSI_RESET + "==================================================");

        for (int i = 0; i < goal.getHigh(); i++) {
            for (int j = 0; j < goal.getWidth(); j++) {

                Target target = goal.getGoal().get(totTargets);
                String symbol = target.getSymbol();

                for (Target area: goalkeeper.getActingArea()){
                    if (area.getLine() == target.getLine() && area.getColum() == target.getColum()) {
                        symbol = goalkeeper.getSymbol();
                        break;
                    }
                }

                if (target.isOut()){
                    System.out.print(Colors.ANSI_GREEN.ansiEscapeCode + symbol);
                }
                else {
                    System.out.print(Colors.ANSI_RESET.ansiEscapeCode + symbol);
                }


                totTargets++;
            }
            System.out.println();
        }
    }
}
