package list4.Q04;

import java.util.Scanner;

public class Main {

    public static int vowelCount(String msg){
        int vowelAmount = 0;

        for (int i = 0; i < msg.length(); i++) {
            if (isVowel(msg.charAt(i))){
                vowelAmount++;
            }
        }
        return vowelAmount;
    }

    public static boolean isVowel(char letter){
        String[] vowels = "aeiouAEIOU".split("");

        for (String vowel : vowels) {
            if (vowel.equals(String.valueOf(letter)))
                return true;
        }
        return false;
    }

    public static char[] vowels(String msg){
        char[] vowels = new char[vowelCount(msg)];

        for (int i = 0, j = 0; i < msg.length(); i++) {
            if (isVowel(msg.charAt(i))){
                vowels[j] = msg.charAt(i);
                j++;
            }
        }
        return vowels;
    }

    public static boolean isConsonant(char letter){
        String[] consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".split("");

        for (String consonant : consonants) {
            if (consonant.equals(String.valueOf(letter)))
                return true;
        }
        return false;
    }

    public static int consonantCount(String msg){
        int consonantAmount = 0;

        for (int i = 0; i < msg.length(); i++) {
            if (isConsonant(msg.charAt(i))){
                consonantAmount++;
            }
        }
        return consonantAmount;
    }

    public static char[] consonants(String msg){
        char[] consonants = new char[consonantCount(msg)];

        for (int i = 0, j = 0; i < msg.length(); i++) {
            if (isConsonant(msg.charAt(i))){
                consonants[j] = msg.charAt(i);
                j++;
            }
        }
        return consonants;
    }

    public static String arrayToString(char[] array){
        String vector = "\n";
        for (Object element: array) {
            vector = vector.concat("[" + element + "]" + " ");
        }
        return vector;
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.print("Type a name: ");
        String msg = read.next();

        System.out.println("-----------------------------------------------");
        System.out.println("NAME: " + msg);
        System.out.println("VOWELS IN THE NAME: " + arrayToString(vowels(msg)));
        System.out.println("CONSONANTS IN THE NAME: " + arrayToString(consonants(msg)));
    }
}
