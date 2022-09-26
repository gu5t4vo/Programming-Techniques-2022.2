package list4.Q05;

import list4.Q03.Arrays;

public class Main {
    public static void main(String[] args) {

        Arrays[]    array       = new Arrays[3];
        Arrays      sums        = new Arrays(3);
        Arrays      products    = new Arrays(3);
        Arrays      averages    = new Arrays(3, true) ;

        array[0] = new Arrays(15);
        array[0].fill(1, 11);

        array[1] = new Arrays(15);
        array[1].fill(1, 11);

        array[2] = new Arrays(15);
        array[2].fill(1, 11);

        for (int i = 0; i < array.length; i++) {
            System.out.println();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            long sum                 = array[i].sum();
            sums.getIntArray()[i]       = sum;

            long product             = array[i].product();
            products.getIntArray()[i]   = product;

            float   mean                = array[i].intArrayMean();
            averages.getFloatArray()[i] = mean;

            System.out.println("Array " + i + ": ");
            System.out.println(array[i]);
            System.out.println("-------------------------------------------------");
            System.out.println("Summation: "    + sum);
            System.out.println("Product: "      + product);
            System.out.println("Mean: "         + mean);
            System.out.println("-------------------------------------------------");
            System.out.println();

        }
        System.out.println("-------------------------------------------------");

        System.out.println("Array of sums:\n"                       + sums);
        System.out.println("Sum of the array of sums:\n"            + sums.sum());

        System.out.println("Array of products:\n"                   + products);
        System.out.println("Product of the array of products:\n"    + products.product());

        System.out.println("Array of averages:\n"                   + averages.toString(true));
        System.out.println("Average of the array of averages:\n"    + averages.floatArrayMean());

        System.out.println("-------------------------------------------------");
    }
}
