package presentation;

import goal.Goal;
import players.Team;

import java.util.ArrayList;

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
            System.out.println(show.title(team.getName()));
            System.out.println(show.goalkeepersMean(team));
        }
    }
}
