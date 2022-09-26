package list4.Q03;

public class Main {
    public static void main(String[] args) {
        Arrays  array   = new Arrays(100);
        Counter counter = new Counter();


        array.fill();
        System.out.println("Array:\n");
        System.out.println(array);

        System.out.println("\nPositive numbers that are multiples of 3\n");
        array.fillFArrayPositiveBy3();
        System.out.println(counter.positiveFormat(array.getFArray()));

        System.out.println("\nPositive numbers that are not multiples of 3\n");
        array.fillFArrayPositiveNotBy3();
        System.out.println(counter.positiveFormat(array.getFArray()));

        System.out.println("\nNegative numbers that are multiples of 3\n");
        array.fillFArrayNegativeBy3();
        System.out.println(counter.negativeFormat(array.getFArray()));

        System.out.println("\nNegative numbers that are not multiples of 3\n");
        array.fillFArrayNegativeNotBy3();
        System.out.println(counter.negativeFormat(array.getFArray()));
    }
}
