package presentation;

import goal.Goal;
import players.Team;

import java.util.ArrayList;

public class Play {
    public ArrayList<Team> generateTeams(Goal goal){
        ArrayList<String>   teamNames   = new Show().getTeamNames();
        ArrayList<Team>     teams       = new ArrayList<>();

        for (String name: teamNames) {
            teams.add(new Team(name, goal));
        }

        return teams;
    }
}
