package list2.Q12;

import java.util.Scanner;

public class item_E {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.print("Type the number of lines and columns: ");
        int linesAndColumns = read.nextInt();

        for (int i = 0; i < linesAndColumns; i++) {
            for (int j = 0; j < linesAndColumns; j++) {
                if (i >= linesAndColumns/2){
                    if (j % 2 == 0)
                        System.out.print(" # ");
                    else
                        System.out.print(" $ ");
                }
                else
                    System.out.print(" * ");
            }
            System.out.println();
        }
    }
}
