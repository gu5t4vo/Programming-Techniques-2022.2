package list2.freeformat;

import java.util.Scanner;

public class Q11 {
    public static void main(String[] args) {
        int[]   j       = {0, 1, 0, 1, 2};
        Scanner read    = new Scanner(System.in);

        System.out.print("Type the iteration limit: ");
        int limit = read.nextInt();

        for (int i = 0; i < limit; i++) {
            for (int element : j) {
                System.out.println(i + "\t" + element);
            }
        }
    }
}
