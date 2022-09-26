package list4.Q08;

import java.util.Random;

public class Main {

    public static String codeGenerator(String symbols){
        Random randSym  = new Random();
        String code     = "";

        for (int i = 0; i < 12; i++) {
            code = code.concat(String.valueOf(symbols.charAt(randSym.nextInt(0, symbols.length()))));
        }

        return code;
    }

    public static void main(String[] args) {


        String code = codeGenerator("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ#+");

        CellPhoneCode number = new CellPhoneCode(code);

        System.out.println("Encoded cell phone number: " + code);

        System.out.println("Decoded cell phone number: " + number.decode());
    }
}
