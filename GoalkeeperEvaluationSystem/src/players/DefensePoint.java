package players;

import goal.GoalPosition;
import goal.Target;

public class DefensePoint extends Target {
    private boolean lateral;

    public DefensePoint(GoalPosition position, int line, int colum) {
        super(position, line, colum);
    }

    public DefensePoint(int line, int colum, String symbol){
        super(line, colum, symbol);
    }

    public void setLateral(boolean lateral) {
        this.lateral = lateral;
    }

    public boolean isLateral() {
        return lateral;
    }

    public boolean isLateral(int index) {
        int inside1 = 10;
        int inside2 = 11;

        if (index > 9){
            do {
               if (index == inside1 || index == inside2){
                   return false;
               }
               inside1 += 4;
               inside2 += 4;
            } while (inside2 < 16);
        }
        return true;
    }
}
