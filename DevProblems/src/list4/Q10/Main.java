package list4.Q10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Type a number: ");

        ArmstrongNumber number = new ArmstrongNumber(read.nextInt());

        System.out.println("Is a Armstrong number? ");
        System.out.println(number);
        if (number.armstrong){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
