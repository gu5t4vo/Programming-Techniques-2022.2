package presentation;

import goal.Goal;
import players.Goalkeeper;
import players.Team;

import java.util.ArrayList;
import java.util.HashMap;

public class Presentation {
    public static void main(String[] args) {

        Play play               = new Play();
        Goal goal               = new Goal(18, 10);
        Show show               = new Show();


        ArrayList<Team> teams = play.generateTeams(goal);

        System.out.println(show.title("GOALKEEPER EVALUATION SYSTEM"));
        System.out.println("----------------------------------------");
        System.out.println(show.title("TEAMS"));
        System.out.println();

        for (Team team: teams) {
            HashMap<String, Double> defensesAverages    = team.defenseMean(300);
            HashMap<String, Double> missesAverages      = team.missesMean(300);
            System.out.println(show.title(team.getName()));
            show.goalkeepersMean(defensesAverages);
            System.out.println(">> Titular Player: " + team.getTitular(defensesAverages));
            System.out.println("----------------------------------------");
            show.goalkeepersMisses(missesAverages);
            for (Goalkeeper goalkeeper: team.getGoalkeepers()) {

                System.out.println("> Name: " + goalkeeper.getName());
                System.out.println("> Total Kicks: " + goalkeeper.getTotKicks());
                System.out.printf("""
                                >> Outs:        %d
                                >> Goals:       %d
                                >> Goal kick:   %d
                                -------------------------------------------------
                                """,
                        goalkeeper.getTotOuts(),
                        goalkeeper.getTotGoals(),
                        goalkeeper.getTotDefenses()
                );
            }
        }
    }
}
