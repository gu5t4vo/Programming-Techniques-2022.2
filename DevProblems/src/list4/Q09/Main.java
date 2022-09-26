package list4.Q09;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.print("Type the pyramid high: ");

        Pascal pascal = new Pascal('*', read.nextInt());

        System.out.println(pascal);
    }
}
