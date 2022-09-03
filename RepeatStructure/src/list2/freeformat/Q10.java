package list2.freeformat;

import java.util.Scanner;

public class Q10 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Type the limit for the iterator: ");
        int limit = read.nextInt();

        for (int i = 0, j = 0; i <= limit; j++) {
            System.out.println(i + "\t" + j);
            if (j == limit){
                j = -1;
                i++;
            }
        }
    }
}
