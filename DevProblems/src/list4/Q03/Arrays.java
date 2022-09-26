package list4.Q03;

import java.util.Random;

/**
 * Hi, I will let all the methods related to the arrays here, so you might see
 * something like an import with the name "Arrays", don't worry, I made all those
 * functions
 *
 * @author Gustavo Loiola Fonteles
 * */
public class Arrays {

    private long    [] intArray;
    private float   [] floatArray;
    private long    [] fArray;

    public Arrays(int size){
        intArray = new long[size];

    }

    public Arrays(int size, boolean isFloat){
        if (isFloat)
            floatArray = new float[size];
        else
            intArray = new long[size];

    }

    public void fill(){
        Random rand = new Random();

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = rand.nextInt(-100, 100);
        }
    }

    public void fill(int init, int end){
        Random rand = new Random();

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = rand.nextInt(init, end);
        }
    }

    @Override
    public String toString() {
        String arrays = "";

        for (int i = 0; i < intArray.length; i++) {

            arrays = arrays.concat(String.format("[%-4d]\t", intArray[i]));

            if ((i + 1) % 10 == 0){
                arrays = arrays.concat("\n");
            }
        }

        return arrays;
    }

    public String toString(boolean isFloat) {
        String arrays = "";

        if (isFloat){
            for (int i = 0; i < floatArray.length; i++) {

                arrays = arrays.concat(String.format("[%-4.1f]\t", floatArray[i]));

                if ((i + 1) % 10 == 0){
                    arrays = arrays.concat("\n");
                }
            }
        }
        else {
            for (int i = 0; i < intArray.length; i++) {

                arrays = arrays.concat(String.format("[%-4d]\t", intArray[i]));

                if ((i + 1) % 10 == 0) {
                    arrays = arrays.concat("\n");
                }
            }
        }

        return arrays;
    }

    public long[] getIntArray() {
        return intArray;
    }

    public long[] getFArray() {
        return fArray;
    }

    public float[] getFloatArray() {
        return floatArray;
    }

    private int positiveBy3Length(){
        int size = 0;

        for (long value: intArray) {
            if (value % 3 == 0 && value > 0) {
                size++;
            }
        }

        return size;
    }

    private int negativeBy3Length(){
        int size = 0;

        for (long value: intArray) {
            if (value % 3 == 0 && value < 0) {
                size++;
            }
        }

        return size;
    }

    private int positiveNotBy3Length(){
        int size = 0;

        for (long value: intArray) {
            if (value % 3 != 0 && value > 0) {
                size++;
            }
        }

        return size;
    }

    private int negativeNotBy3Length(){
        int size = 0;

        for (long value: intArray) {
            if (value % 3 != 0 && value < 0) {
                size++;
            }
        }

        return size;
    }

    public void fillFArrayPositiveBy3(){
        fArray = new long[positiveBy3Length()];

        for (int i = 0, j = 0; i < intArray.length; i++) {
            if (intArray[i] % 3 == 0 && intArray[i] > 0) {
                fArray[j] = intArray[i];
                j++;
            }
        }
    }

    public void fillFArrayNegativeBy3(){
        fArray = new long[negativeBy3Length()];

        for (int i = 0, j = 0; i < intArray.length; i++) {
            if (intArray[i] % 3 == 0 && intArray[i] < 0) {
                fArray[j] = intArray[i];
                j++;
            }
        }
    }

    public void fillFArrayPositiveNotBy3(){
        fArray = new long[positiveNotBy3Length()];

        for (int i = 0, j = 0; i < intArray.length; i++) {
            if (intArray[i] % 3 != 0 && intArray[i] > 0) {
                fArray[j] = intArray[i];
                j++;
            }
        }
    }

    public void fillFArrayNegativeNotBy3(){
        fArray = new long[negativeNotBy3Length()];

        for (int i = 0, j = 0; i < intArray.length; i++) {
            if (intArray[i] % 3 != 0 && intArray[i] < 0) {
                fArray[j] = intArray[i];
                j++;
            }
        }
    }

    public long sum(){
        long accumulator = 0;
        for (long value: intArray) {
            accumulator += value;
        }

        return accumulator;
    }

    public float floatSum(){
        float accumulator = 0f;
        for (float value: floatArray) {
            accumulator += value;
        }

        return accumulator;
    }

    public long product(){
        long accumulator = 1;
        for (long value: intArray) {
            accumulator *= value;
        }

        return accumulator;
    }

    public float intArrayMean(){
        return (float) sum()/ intArray.length;
    }

    public float floatArrayMean(){
        return (float) floatSum()/ floatArray.length;
    }
}
