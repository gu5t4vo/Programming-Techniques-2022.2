package tasks;

import java.util.Scanner;

public class Q13 {
    public static void main(String[] args) { int     A, B;
        Scanner read = new Scanner(System.in);

        System.out.print("Type the value of A: ");
        A = read.nextInt();
        System.out.print("Type the value of B: ");
        B = read.nextInt();

        if (A > 10 || A + B == 20){
            if (A > 10){
                System.out.println("A > 10");
            }
            if (A + B == 20){
                System.out.println("A + B == 20");
            }
        }
        else {
            System.out.println("Invalid Number");
        }
    }
}
