package list3;

import java.util.Random;

public class FunctionSupport {

    public static void fuelIntArray(int[] array){
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(-100, 100);
        }
    }

    public static void fuelIntArray(int[] targetArray, int[] fieldArray){
        for (int i = 0; i < targetArray.length; i++) {
            targetArray[i] = fieldArray[i];
        }
    }

    public static void fuelStringArray(String[] targetArray, String[] fieldArray){
        for (int i = 0; i < targetArray.length; i++) {
            targetArray[i] = fieldArray[i];
        }
    }

    public static void fuelCharArray(char[] array){
        Random random = new Random();
        String alphabet = "abcdefghijlmnopqrstuvxz";

        for (int i = 0; i < array.length; i++) {
            array[i] = alphabet.charAt(random.nextInt(0, alphabet.length()));
        }
    }

    public static void fuelEncryptedArray(char[] array){
        Random random = new Random();
        String cryptography = "%*(-+@#123456789{}!&$?:";

        for (int i = 0; i < array.length; i++) {
            array[i] = cryptography.charAt(random.nextInt(0, cryptography.length()));
        }
    }

    public static void fuelAlphaNumArray(char[] array){
        Random random = new Random();
        String alphabet = "abcdefghijlmnopqrstuvxz1234567890";

        for (int i = 0; i < array.length; i++) {
            array[i] = alphabet.charAt(random.nextInt(0, alphabet.length()));
        }
    }

    public static void fuelIntArray(int[] array, int minValue, int maxValue){
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(minValue, maxValue);
        }
    }

    public static int positiveCounter(int[] array){
        int positiveCont = 0;

        for (int i: array) {
            if (i > 0){
                positiveCont++;
            }
        }
        return positiveCont;
    }

    public static int negativeCounter(int[] array){
        int negativeCont = 0;

        for (int i: array) {
            if (i < 0){
                negativeCont++;
            }
        }
        return negativeCont;
    }

    public static int[] fuelWithPositive(int[] array){
        int[]   positiveArray = new int[positiveCounter(array)];
        int     index = 0;

        for (int value: array){
            if (value > 0){
                positiveArray[index] = value;
                index++;
            }
        }

        return positiveArray;
    }

    public static int[] fuelWithNegative(int[] array){
        int[]   negativeArray = new int[negativeCounter(array)];
        int     index = 0;

        for (int value: array){
            if (value < 0){
                negativeArray[index] = value;
                index++;
            }
        }

        return negativeArray;
    }

    public static void fuelWithEvens(int index, int[] targetArray, int[] fieldArray){

        for (int i = index, j = 0; i < fieldArray.length; i++) {
            if (isEven(fieldArray[i])){
                targetArray[j] = fieldArray[i];
                j++;
            }
        }
    }

    public static void fuelWithOdds(int index, int[] targetArray, int[] fieldArray){

        for (int i = index, j = 0; i < fieldArray.length; i++) {
            if (isOdd(fieldArray[i])){
                targetArray[j] = fieldArray[i];
                j++;
            }
        }
    }

    public static float arrayMean(int[] array){
        return (float) ArraysManipulation.sum(array)/array.length;
    }

    public static boolean isInArray(int index, int element, int[] array){

        for (int i = index; i < array.length; i++) {
            if (array[i] == element){
                return true;
            }
        }
        return false;
    }

    public static boolean isInArray(int index, char element, char[] array){

        for (int i = index; i < array.length; i++) {
            if (array[i] == element){
                return true;
            }
        }
        return false;
    }

    public static int max(int index, int[] array){
        int max = array[index];

        for (int i = index; i < array.length; i++) {
            if (array[i] > max){
                max = array[i];
            }
        }
        return max;
    }

    public static int min(int index, int[] array){
        int min = array[index];

        for (int i = index; i < array.length; i++) {
            if (array[i] < min){
                min = array[i];
            }
        }
        return min;
    }

    public static int search(int index, char element, char[] array){
        for (int i = index; i < array.length; i++) {
            if (array[index] == element){
                return index;
            }
            index++;
        }
        return -100;
    }

    public static int search(int index, int element, char[] array){

        for (int i = index; i < array.length; i++) {
            if (array[i] == element){
                return index;
            }
        }
        return -100;
    }

    /**
     * Return the number of characters in the array, disregarding those that
     * are repeated
     * */
    public static int countDifferentChars(char[] array){
        char[]  whitelist   = new char[array.length];
        int     amount      = 0;

        for (int i = 0, w = 0; i < array.length; i++) {
            if (!isInArray(0, array[i], whitelist)){
                whitelist[w] = array[i];
                w++;
                amount++;
            }
        }

        return amount;
    }

    /**
     * Return an array of chars with no equal terms
     * */
    public static char[] noRepeatArray(char[] array){
        int         chars       = countDifferentChars(array);
        char[]      whitelist   = new char  [chars];

        for (int i = 0, w = 0; i < array.length; i++) {
            if (!isInArray(0, array[i], whitelist)){
                whitelist[w] = array[i];
                w++;
            }
        }

        return whitelist;
    }

    public static int countDifferentNumbers(int[] array){
        int[]   whitelist   = new int[array.length];
        int     amount      = 0;

        for (int i = 0, w = 0; i < array.length; i++) {
            if (!isInArray(0, array[i], whitelist)){
                whitelist[w] = array[i];
                w++;
                amount++;
            }
        }

        return amount;
    }

    public static int[] noRepeatArray(int[] array){
        int         numbers     = countDifferentNumbers(array);
        int[]       whitelist   = new int[numbers];

        for (int i = 0, w = 0; i < array.length; i++) {
            if (!isInArray(0, array[i], whitelist)){
                whitelist[w] = array[i];
                w++;
            }
        }

        return whitelist;
    }

    public static boolean isEven(int num){
        return num % 2 == 0;
    }

    public static boolean isOdd(int num){
        return num % 2 == 1||num % 2 == -1;
    }

    public static int evenCounter(int index, int[] array){

        int acm = 0;

        for (int i = index; i < array.length; i++) {
            if (isEven(array[i])){
                acm++;
            }
        }

        return acm;
    }

    public static int oddCounter(int index, int[] array){

        int acm = 0;

        for (int i = index; i < array.length; i++) {
            if (isOdd(array[i])){
                acm++;
            }
        }

        return acm;
    }
}
