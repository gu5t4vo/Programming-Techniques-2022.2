package list4.Q06;

public class Material {

    private final float     mass;
    private final HalfLife  halfLife;

    public Material(float mass, HalfLife halfLife){
        this.mass       = mass;
        this.halfLife   = halfLife;
    }


    public String timeToHalfLife(float expectedMass){
        float   newMass     = this.mass;

        char    timeUnit    = halfLife.getTimeUnit().getTimeMeasure();

        int     timePassed  =0;

        do {
            timePassed += halfLife.getHalfLifeTime();
            newMass    /= 2f;

        } while (newMass > expectedMass);


        return String.format("%d%c", timePassed, timeUnit);
    }
}
