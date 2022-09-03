package list2.Q12;

import java.util.Scanner;

public class item_A {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.print("Type the number of lines and columns: ");
        int linesAndColumns = read.nextInt();

        for (int i = 0; i < linesAndColumns; i++) {
            for (int j = 0; j < linesAndColumns; j++) {
                if (i >= j)
                    System.out.print(" * ");
            }
            System.out.println();
        }
    }
}
