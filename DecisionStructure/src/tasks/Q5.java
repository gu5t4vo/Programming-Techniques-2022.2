package tasks;

import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        int     A, B;
        Scanner read = new Scanner(System.in);

        System.out.print("Type the value of A: ");
        A = read.nextInt();
        System.out.print("Type the value of B: ");
        B = read.nextInt();

        System.out.println((A > 10 || A + B == 20) ? "Valid Number" : "Invalid Number");
    }
}
