package tasks;

import java.util.Scanner;

public class Q8 {
    public static void main(String[] args) {
        int     A, B;
        Scanner read = new Scanner(System.in);

        System.out.print("Type the value of A: ");
        A = read.nextInt();
        System.out.print("Type the value of B: ");
        B = read.nextInt();

        if (A > 10){
            System.out.println("A > 10");
        }
        System.out.println(A + B == 20 ? "A + B == 20" : "Invalid Number");
    }
}
