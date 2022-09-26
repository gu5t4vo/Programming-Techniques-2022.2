package list4.Q03;

public class Counter {

    public String positiveFormat(long[] array){
        String countedArray = "";

        for (int i = 0; i < array.length; i++) {

            countedArray = countedArray.concat(String.format("[%-3d]", array[i]));

            if ((i + 1) % 10 == 0) {
                countedArray = countedArray.concat("\n");
            }
        }

        return countedArray;
    }

    public String negativeFormat(long[] array){
        String countedArray = "";

        for (int i = 0; i < array.length; i++) {

            countedArray = countedArray.concat(String.format("[%-4d]", array[i]));

            if ((i + 1) % 10 == 0) {
                countedArray = countedArray.concat("\n");
            }
        }

        return countedArray;
    }

}
