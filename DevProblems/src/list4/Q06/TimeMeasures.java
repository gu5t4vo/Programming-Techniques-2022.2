package list4.Q06;

public enum TimeMeasures {
    SECONDS('s'),
    MINUTES('m'),
    HOURS('h'),
    DAYS('d'),
    WEEKS('w'),
    MONTHS('m'),
    YEARS('y'),
    CENTURIES('c');

    final char timeMeasure;

    TimeMeasures(char timeMeasure){
        this.timeMeasure = timeMeasure;
    }

    public char getTimeMeasure() {
        return timeMeasure;
    }
}
