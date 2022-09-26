package list4.Q07;

import java.util.Scanner;

public class Main {

    public static String reverse(String msg){
        String reverseMsg = "";

        for (int i = msg.length() - 1; i >= 0; i--) {
            reverseMsg = reverseMsg.concat(String.valueOf(msg.charAt(i)));
        }

        return reverseMsg;
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String  msg;

        System.out.print("Type a word: ");
        msg = read.next();

        System.out.println("Reversed String: " + reverse(msg));
    }
}
