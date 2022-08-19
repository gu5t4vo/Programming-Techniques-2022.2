package tasks;

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        int     A, B;
        Scanner read = new Scanner(System.in);

        System.out.print("Type the value of A: ");
        A = read.nextInt();
        System.out.print("Type the value of B: ");
        B = read.nextInt();

        if (A > 10 || A + B == 20){
            System.out.println("Valid Number");
        }
        else {
            if (A == B){
                System.out.println("'A' equals to 'B', 'A' and 'B' different from 10, 'A' lesser than 10");
            }
            else {
                System.out.println("Invalid Number");
            }
        }
    }
}
