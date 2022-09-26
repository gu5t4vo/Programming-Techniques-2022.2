package list4.Q06;

public class HalfLife {

    private final int           halfLifeTime;
    private final TimeMeasures  timeUnit;

    public HalfLife(int time, TimeMeasures timeUnit){
        this.halfLifeTime   = time;
        this.timeUnit       = timeUnit;
    }

    public int getHalfLifeTime() {
        return halfLifeTime;
    }

    public TimeMeasures getTimeUnit() {
        return timeUnit;
    }
}
