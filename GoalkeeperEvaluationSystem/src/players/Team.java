package players;

import goal.Goal;
import presentation.Show;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Team{
    private final String                  name;
    private final ArrayList<Goalkeeper>   goalkeepers;
    private final ArrayList<Striker>      strikers;
    private final Goal                    goal;

    public Team(String name, ArrayList<Goalkeeper> goalkeepers, Goal goal, ArrayList<Striker> strikers){
        this.name           = name;
        this.goalkeepers    = goalkeepers;
        this.strikers       = strikers;
        this.goal           = goal;
    }

    public Team(String name, Goal goal){
        goalkeepers = new ArrayList<>();
        strikers    = new ArrayList<>();
        this.name   = name;
        this.goal   = goal;
        generateTeam(new Show().getStrikerNames(), new Show().getGoalkeeperNames(), this.goal);
    }

    public HashMap<String, Float> defenseMean(){

        HashMap<String, Float> stats = new HashMap<>();

        int totDefense  = 0;
        int totGoal     = 0;

        for (Goalkeeper goalkeeper : goalkeepers) {
            for (Striker striker : strikers) {
                striker.kick(goalkeeper.goal, goalkeeper);
                if (striker.isDefense()){
                    totDefense++;
                }
                else if (striker.isGoal()){
                    totGoal++;
                }
            }
            Float mean = (float)totDefense/(totDefense + totGoal);

            stats.put(goalkeeper.name, mean);
            totDefense  = 0;
            totGoal     = 0;
        }

        return stats;
    }

    public ArrayList<Goalkeeper> getGoalkeepers() {
        return goalkeepers;
    }

    public ArrayList<Striker> getStrikers() {
        return strikers;
    }

    private void generateTeam(ArrayList<String> strikerNames,ArrayList<String> goalkeeperNames, Goal goal) {

        Random rand = new Random();

        for (int i = 0; i < 15; i++) {
            String randPick = strikerNames.get(rand.nextInt(0, strikerNames.size()));

            strikers.add(
                    new Striker(
                            randPick,
                            i,
                            goal.getGoal().get(rand.nextInt(0, goal.getGoal().size()))
                    )
            );

            strikerNames.remove(randPick);
        }

        for (int i = 0; i < 5; i++) {
            String randPick = goalkeeperNames.get(rand.nextInt(0, goalkeeperNames.size()));

            goalkeepers.add(
                    new Goalkeeper(
                            randPick,
                            i,
                            goal
                    )
            );

            goalkeeperNames.remove(randPick);
        }
    }

    @Override
    public String toString() {
        String teamInfo =
                "=-=-=-=-= " + name + " =-=-=-=-=\n" +
                "----------------------------------\n" +
                ">> Strikers:\n";

        for (Striker striker: strikers) {
            teamInfo = teamInfo.concat(
                    String.format(
                            """
                                    >>> Name:   %s
                                    >>>>> Id:   %d
                                    ~~~~~~~~~~~~~~
                                    """, striker.getName(), striker.getId()
                    )
            );
        }

        teamInfo = teamInfo.concat("\n----------------------------------\n>> Goalkeepers:\n");

        for (Goalkeeper goalkeeper: goalkeepers) {
            teamInfo = teamInfo.concat(
                    String.format(
                            """
                                    >>> Name:   %s
                                    >>>>> Id:   %d
                                    ~~~~~~~~~~~~~~
                                    """, goalkeeper.getName(), goalkeeper.getId()
                    )
            );
        }

        return teamInfo;
    }
}
