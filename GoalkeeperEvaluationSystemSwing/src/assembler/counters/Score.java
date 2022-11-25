package assembler.counters;

public enum Score {
    KICKS   ("KICKS: "),
    OUTS    ("OUTS: "),
    DEFENSES("DEFENSES: "),
    BEAM    ("BEAMS: "),
    GOALS   ("GOALS: ");

    final String score;

    Score(String score){
        this.score = score;
    }

    public String getScore() {
        return score;
    }
}
