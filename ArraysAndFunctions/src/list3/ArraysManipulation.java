package list3;

import java.util.Scanner;

import static list3.AestheticFunctions.*;
import static list3.FunctionSupport.*;

public class ArraysManipulation {

    // List Activities Functions
    public static int search(int index, int element, int[] array){
        for (int i = index; i < array.length; i++) {
            if (array[i] == element){
                return index;
            }
            index++;
        }
        return -100;
    }

    public static int searchByIndex(int index, int[] array){
        try{
            return array[index];
        } catch (ArrayIndexOutOfBoundsException error){
            return 101; // The array only create numbers from -100 to 100
        }
    }

    public static void sortPositiveAndNegativeValues(int[] array){

        int[]   positiveArray = fuelWithPositive(array);
        int[]   negativeArray = fuelWithNegative(array);

        for (int i = 0; i < positiveArray.length; i++) {
            array[i] = positiveArray[i];
        }
        for (int i = 0; i < negativeArray.length; i++) {
            array[positiveArray.length + i] = negativeArray[i];
        }
    }

    public static int sum(int[] array){
        int accumulator = 0;
        for (int value: array) {
            accumulator += value;
        }

        return accumulator;
    }

    public static int[] joinArrays(int[] arrayA, int[] arrayB){
        int[] bigArray = new int[arrayA.length + arrayB.length];

        for (int i = 0; i < arrayA.length ; i++)
            bigArray[i] = arrayA[i];
        for (int i = 0; i < arrayB.length ; i++)
            bigArray[i + arrayA.length] = arrayB[i];

        return bigArray;
    }

    public static int[] swapArrayContent(int[] array){
        int[] invertedArray = new int[array.length];

        for (int i = array.length, index = 0; i > 0; i--, index++) {
            invertedArray[index] = array[i - 1];
        }

        return invertedArray;
    }

    /**
     * Only work with same size arrays
     */
    public static void swapArrayContent(int [] arrayA, int[] arrayB){
        int[]   saveArrayA  = new int[arrayA.length];
        fuelIntArray(saveArrayA, arrayA);

        fuelIntArray(arrayA, arrayB);
        fuelIntArray(arrayB, saveArrayA);
    }

    public static int[] prioritize(int[] targetArray, int[] sampleValuesArray){
        float   mean            = arrayMean(targetArray);
        int     bigNumbers      = 0;

        for (int value: sampleValuesArray) {
            if (value > mean){
                bigNumbers++;
            }
        }

        int[] biggerArray       = new int[targetArray.length + bigNumbers];
        fuelIntArray(biggerArray, targetArray);

        for (int i = 0; i < biggerArray.length; i++) {
            if (sampleValuesArray[i] > mean){
                biggerArray[targetArray.length + i] = sampleValuesArray[i];
            }
        }

        return biggerArray;
    }

    /**
     * Needs an array field with 0 or 1
     * */
    public static String[] pack(int[] array){

        int packSize = 0;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i+1]){
                packSize++;
            }
        }

        String[] packedArray   = new String[packSize + 1];
        int packedTerm      = 1;
        for (int i = 0, index = 0; i < array.length - 1; i++) {

            if (array[i] == array[i + 1]){
                packedTerm++;
            } else {
                packedArray[index] = String.format("%d", array[i]) + packedTerm;
                packedTerm = 1;
                index++;
            } if (i == array.length - 2)
                packedArray[index] = String.format("%d", array[i]) + packedTerm;
        }

        return packedArray;
    }

    /**
     * Need a packed array
     * */
    public static int[] unpack(String[] array){
        int[] packedTerms       = new int[array.length];
        int[] packedTermsAmount = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            packedTerms[i] = Integer.parseInt(String.valueOf(array[i].charAt(0)));
            packedTermsAmount[i] = Integer.parseInt(array[i].replaceFirst(
                    String.valueOf(array[i].charAt(0)), ""));
        }

        int[] unpackedArray = new int[sum(packedTermsAmount)];

        for (int i = 0, j = 0, control = 0; j < packedTermsAmount.length; i++) {

            if (j % 2 == 0){
                unpackedArray[i] = (packedTerms[0] == 1)? 1:0;
            }
            else {
                unpackedArray[i] = (packedTerms[0] == 0)? 1:0;
            }
            control++;
            if (control == packedTermsAmount[j]){
                control = 0;
                j++;
            }

        }

        return unpackedArray;
    }

    public static void encrypt(char[] array){
        String cryptography = "%*(-+@#123456789{}!&$?:";

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'a'){
                array[i] = cryptography.charAt(0);
            }
            else if (array[i] == 'b'){
                array[i] = cryptography.charAt(1);

            }
            else if (array[i] == 'c'){
                array[i] = cryptography.charAt(2);

            }
            else if (array[i] == 'd'){
                array[i] = cryptography.charAt(3);

            }
            else if (array[i] == 'e'){
                array[i] = cryptography.charAt(4);

            }
            else if (array[i] == 'f'){
                array[i] = cryptography.charAt(5);

            }
            else if (array[i] == 'g'){
                array[i] = cryptography.charAt(6);

            }
            else if (array[i] == 'h'){
                array[i] = cryptography.charAt(7);

            }
            else if (array[i] == 'i'){
                array[i] = cryptography.charAt(8);

            }
            else if (array[i] == 'j'){
                array[i] = cryptography.charAt(9);

            }
            else if (array[i] == 'l'){
                array[i] = cryptography.charAt(10);

            }
            else if (array[i] == 'm'){
                array[i] = cryptography.charAt(11);

            }
            else if (array[i] == 'n'){
                array[i] = cryptography.charAt(12);

            }
            else if (array[i] == 'o'){
                array[i] = cryptography.charAt(13);

            }
            else if (array[i] == 'p'){
                array[i] = cryptography.charAt(14);

            }
            else if (array[i] == 'q'){
                array[i] = cryptography.charAt(15);

            }
            else if (array[i] == 'r'){
                array[i] = cryptography.charAt(16);

            }
            else if (array[i] == 's'){
                array[i] = cryptography.charAt(17);

            }
            else if (array[i] == 't'){
                array[i] = cryptography.charAt(18);

            }
            else if (array[i] == 'u'){
                array[i] = cryptography.charAt(19);

            }
            else if (array[i] == 'v'){
                array[i] = cryptography.charAt(20);

            }
            else if (array[i] == 'x'){
                array[i] = cryptography.charAt(21);

            }
            else if (array[i] == 'z'){
                array[i] = cryptography.charAt(22);

            }
        }
    }

    public static void decrypt(char[] array){

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < array.length; i++) {
        if (array[i] == '%'){
            array[i] = alphabet.charAt(0);
        }
        else if (array[i] == '*'){
            array[i] = alphabet.charAt(1);

        }
        else if (array[i] == '('){
            array[i] = alphabet.charAt(2);

        }
        else if (array[i] == '-'){
            array[i] = alphabet.charAt(3);

        }
        else if (array[i] == '+'){
            array[i] = alphabet.charAt(4);

        }
        else if (array[i] == '@'){
            array[i] = alphabet.charAt(5);

        }
        else if (array[i] == '#'){
            array[i] = alphabet.charAt(6);

        }
        else if (array[i] == '1'){
            array[i] = alphabet.charAt(7);

        }
        else if (array[i] == '2'){
            array[i] = alphabet.charAt(8);

        }
        else if (array[i] == '3'){
            array[i] = alphabet.charAt(9);

        }
        else if (array[i] == '4'){
            array[i] = alphabet.charAt(10);

        }
        else if (array[i] == '5'){
            array[i] = alphabet.charAt(11);

        }
        else if (array[i] == '6'){
            array[i] = alphabet.charAt(12);

        }
        else if (array[i] == '7'){
            array[i] = alphabet.charAt(13);

        }
        else if (array[i] == '8'){
            array[i] = alphabet.charAt(14);

        }
        else if (array[i] == '9'){
            array[i] = alphabet.charAt(15);

        }
        else if (array[i] == '{'){
            array[i] = alphabet.charAt(16);

        }
        else if (array[i] == '}'){
            array[i] = alphabet.charAt(17);

        }
        else if (array[i] == '!'){
            array[i] = alphabet.charAt(18);

        }
        else if (array[i] == '&'){
            array[i] = alphabet.charAt(19);

        }
        else if (array[i] == '$'){
            array[i] = alphabet.charAt(20);

        }
        else if (array[i] == '?'){
            array[i] = alphabet.charAt(21);

        }
        else if (array[i] == ':'){
            array[i] = alphabet.charAt(22);

        }
    }
}

    /**
     * Returns an array of chars, the odd indexes contains the array elements, meanwhile
     * the even indexes contains the number of times that the last term was repeated
     * */
    public static String[] countChars(char[] array){

        char[]      whitelist   = noRepeatArray(array);
        String[]    sortedArray = new String[whitelist.length * 2];

        for (int i = 1, j = 0; j < whitelist.length; i += 2, j++) {
            sortedArray[i] = String.valueOf(whitelist[j]);
        }

        char[] blacklist = new char[whitelist.length];

        for (int i = 0, w = 0, repeats = 0, index = 0, b = 0; i < array.length; i++) {
            if (!isInArray(0, array[i], blacklist)) {
                if (FunctionSupport.search(w, array[i], array) != -100) {
                    repeats++;
                    w = FunctionSupport.search(w, array[i], array) + 1;
                    i--;
                    if (w < 0) {
                        w = 0;
                        i++;
                        sortedArray[index] = String.valueOf(repeats);
                        index += 2;
                    }
                } else if (index < sortedArray.length) {
                    sortedArray[index] = String.valueOf(repeats);
                    index += 2;
                    repeats = 0;
                    w = 0;
                    blacklist[b] = array[i];
                    b++;
                }
            }
        }

        return sortedArray;
    }

    public static int[] complement(int[] arrayA, int[] arrayB){
        int[] complementArray = new int[arrayA.length];

        for (int i = 0; i < complementArray.length; i++) {
            complementArray[i] = 10 - (arrayA[i] + arrayB[i]);
            /* Fun fact, if weren't for the parenthesis, Java would have summed two
             * minus signs, if arrayA[i] were negative */
        }

        return complementArray;
    }

    public static void polarize(int[] array){
        int[] evenArray = new int[evenCounter   (0, array)];
        int[] oddArray  = new int[oddCounter    (0, array)];
        fuelWithEvens   (0, evenArray, array);
        fuelWithOdds    (0, oddArray, array);

        for (int i = 0; i < oddArray.length; i++) {
            array[i] = oddArray[i];
        }

        for (int i = 0; i < evenArray.length; i++) {
            array[i + oddArray.length] = evenArray[i];
        }
    }

    public static int[] explode(int[] array){
        int[] explodedArray = new int[sum(array)];
        int index = 0;

        for (int element: array) {
            for (int i = 0; i < element; i++) {
                explodedArray[index] = element;
                index++;
            }
        }

        return explodedArray;
    }

    public static void sort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            if (min(i, array) < array[i]){
                int save = array[i];
                array[i] = min(i, array);

                array[search(i + 1, min(i, array), array)] = save;
            }
        }
    }

    public static String group(int groups, int[] array){
        String groupedArray = "[";

        for (int i = 0; i < array.length; i++) {
            groupedArray = groupedArray.concat(String.valueOf(array[i]));
            if ((i + 1) % groups == 0){
                groupedArray = groupedArray.concat("]");

                if (i != array.length - 1){
                    groupedArray = groupedArray.concat("\n[");
                }

            } else if (i != array.length - 1) {
                groupedArray = groupedArray.concat("; \t");
            }
        }
        if (array.length % groups != 0){
            groupedArray = groupedArray.concat("]");
        }

        return groupedArray;
    }

    /**
     * Returns all the elements that are int the array A, but are not in the
     * array B
     * */
    public static int[] differenceA(int[] arrayA, int[] arrayB){
        int arraySize = 0;

        for (int element : arrayA) {
            if (!isInArray(0, element, arrayB)) {
                arraySize++;
            }
        }

        int[] differenceArray = new int[arraySize];

        for (int i = 0, j = 0; i < arrayA.length; i++) {

            if (!isInArray(0, arrayA[i], arrayB)) {
                differenceArray[j] = arrayA[i];
                j++;
            }

        }

        return noRepeatArray(differenceArray);
    }

    public static void main(String[] args) {
        Scanner     read = new Scanner(System.in);
        int         arraySize;
        int[]       array;


        String[]    menu = {
                            "Search"                            , "Search by Index"         ,
                            "Split Positive and Negative Values", "Summation"               ,
                            "Join Arrays"                       , "Reverse the Array Order" ,
                            "Swap the Array Content"            , "Prioritization"          ,
                            "Packing"                           , "Unpacking"               ,
                            "Encrypt"                           , "Decrypt"                 ,
                            "Character Count"                   , "Complement"              ,
                            "Polarize"                          , "Explode"                 ,
                            "Sort"                              , "Group"                   ,
                            "Difference-A"                      , "Exit"
                            };

        System.out.print("Type the array length: ");

        arraySize   = read.nextInt();
        array       = new int[arraySize];

        fuelIntArray        (array);
        creatingArrayMessage();
        System.out.println  (arrayToString(array));
        System.out.println  ();

        int option;
        do {
            System.out.print(optionMenu(2, menu));
            option = read.nextInt();


            if (option == 1){ // Search
                System.out.println("-----------------------------------------------------");
                System.out.print("Which element are you looking for? ");
                int index = search(0, read.nextInt(), array);
                if (index == -100)
                    System.out.println("Return: " + index + "\nElement not Found!");
                else
                    System.out.println("Element Position: " + index);
                System.out.println("-----------------------------------------------------");


            }
            else if(option == 2) /* Search by Index */{
                System.out.println("-----------------------------------------------------");
                System.out.print("Array Index: ");
                int element = searchByIndex(read.nextInt(), array);
                if (element == 101)
                    System.out.println("Error! Invalid Index!");
                else
                    System.out.println("Element: " + element);
                System.out.println("-----------------------------------------------------");

            }
            else if(option == 3) /* Split Positive and Negative Values */{
                System.out.println("-----------------------------------------------------");
                sortPositiveAndNegativeValues(array);
                System.out.println("Split array: " + arrayToString(array));
                System.out.println("-----------------------------------------------------");

            }
            else if(option == 4) /* Summation */{
                System.out.println("-----------------------------------------------------");
                System.out.println("ARRAY SUMMATION: ");
                for (int i = 0; i < array.length; i++) {
                    System.out.print(array[i]);
                    if (i < array.length - 1)
                        System.out.print(" + ");
                    else
                        System.out.println(" = " + sum(array));

                }
                System.out.println("\n-----------------------------------------------------");
            }
            else if(option == 5) /* Join Arrays */{
                System.out.println  ("-----------------------------------------------------");
                int[] array2 = new int[arraySize];
                creatingArrayMessage();
                fuelIntArray        (array2);
                System.out.println  (arrayToString(array2));
                System.out.print    ("Joining both arrays");
                loadingGenerator    ('.', 3, 400);

                System.out.println  (arrayToString(joinArrays(array, array2)));
                System.out.println  ("-----------------------------------------------------");

            }
            else if(option == 6) /* Reverse the Array Order */{
                System.out.println  ("-----------------------------------------------------");

                System.out.print    ("Reversing the array order");
                loadingGenerator    ('.', 3, 400);

                System.out.println  (arrayToString(swapArrayContent(array)));
                System.out.println  ("-----------------------------------------------------");

            }
            else if(option == 7) /* Swap The Array Content */{
                System.out.println  ("-----------------------------------------------------");

                int[] array2 = new int[arraySize];

                creatingArrayMessage();
                fuelIntArray        (array2);
                System.out.println  ("\nArray 1 content:");
                System.out.println  (arrayToString(array));

                System.out.println  ("\nArray 2 content:");
                System.out.println  (arrayToString(array2));

                System.out.print    ("\nReversing the array content");
                loadingGenerator    ('.', 3, 400);

                swapArrayContent(array, array2);

                System.out.println  ("\nArray 1 content:");
                System.out.println  (arrayToString(array));

                System.out.println  ("\nArray 2 content:");
                System.out.println  (arrayToString(array2));

                System.out.println  ("-----------------------------------------------------");

            }
            else if(option == 8) /* Prioritization */{
                System.out.println  ("-----------------------------------------------------");

                int[] array2 = new int[arraySize];
                creatingArrayMessage();
                fuelIntArray        (array2);
                System.out.println  (arrayToString(array2));

                System.out.println("In the prioritization, the intention is to increase the array's mean" +
                        "\nusing the values of other array.");
                System.out.print("Modifying array");
                loadingGenerator('.', 3, 400);
                System.out.println("Modified array: " + arrayToString(prioritize(array, array2)));
                System.out.println  ("-----------------------------------------------------");

            }
            else if(option == 9) /* Packing */{
                System.out.println  ("-----------------------------------------------------");

                int[] unpackedArray = new int[10];
                fuelIntArray(unpackedArray, 0, 2);

                creatingArrayMessage();
                System.out.println  (arrayToString(unpackedArray));
                System.out.print    ("Packing array");
                loadingGenerator    ('.', 3, 400);
                String[] packedArray = pack(unpackedArray);
                System.out.println(arrayToString(packedArray));

                System.out.println  ("-----------------------------------------------------");
            }
            else if(option == 10) /* Unpacking */{
                System.out.println  ("-----------------------------------------------------");

                int[] array2            = new int[10];
                fuelIntArray        (array2, 0, 2);
                String[] packedArray    = pack(array2);

                creatingArrayMessage();

                System.out.println  (arrayToString(packedArray));

                System.out.print    ("Unpacking the array");
                loadingGenerator    ('.', 3, 400);

                int[] unpackedArray     = unpack(packedArray);

                System.out.println  ("\nUnpacked Array:");
                System.out.println  (arrayToString(unpackedArray));

                System.out.println  ("-----------------------------------------------------");
            }
            else if(option == 11) /* Encrypting */{
                System.out.println  ("-----------------------------------------------------");

                char[] charsArray = new char[10];
                fuelCharArray       (charsArray);
                creatingArrayMessage();
                System.out.println  (arrayToString(charsArray));
                System.out.print    ("Encrypting array");
                loadingGenerator    ('.', 3, 400);
                encrypt             (charsArray);
                System.out.println  ("Encrypted array:");
                System.out.println  (arrayToString(charsArray));

                System.out.println  ("-----------------------------------------------------");
            }
            else if(option == 12) /* Decrypting */{
                System.out.println  ("-----------------------------------------------------");

                char[] encryptedArray = new char[10];

                fuelEncryptedArray  (encryptedArray);
                creatingArrayMessage();
                System.out.println  ("\nEncrypted array:");
                System.out.println  (arrayToString(encryptedArray));
                System.out.print    ("Decrypting array");
                loadingGenerator    ('.', 3, 400);
                decrypt             (encryptedArray);
                System.out.println  ("\nDecrypted array:");
                System.out.println  (arrayToString(encryptedArray));

                System.out.println  ("-----------------------------------------------------");
            }
            else if(option == 13) /* Character count */ {
                System.out.println  ("-----------------------------------------------------");

                char[] charsArray   = new char[20];
                fuelAlphaNumArray(charsArray);
                String[] amountTerms  = countChars(charsArray);
                creatingArrayMessage();

                System.out.println("\nCreated array:");
                System.out.println(arrayToString(charsArray));
                System.out.println("Character score:");

                for (int i = 1; i < amountTerms.length; i += 2) {
                    System.out.printf("[%s]: [%sx]\n", amountTerms[i], amountTerms[i-1]);
                }

                System.out.println  ("-----------------------------------------------------");
            }
            else if(option == 14) /* Complement */{
                System.out.println  ("-----------------------------------------------------");

                int[] array2 = new int[arraySize];
                creatingArrayMessage();
                System.out.println  ("New array:");
                fuelIntArray        (array2);
                System.out.println  (arrayToString(array2));
                System.out.print    ("\nComplementing");
                loadingGenerator    ('.', 3, 400);
                System.out.println  ();
                System.out.println  (arrayToString(array));
                System.out.println  (arrayToString(array2));
                System.out.println  (arrayToString(complement(array, array2)));

                System.out.println  ("-----------------------------------------------------");
            }
            else if(option == 15) /* Polarize */{
                System.out.println  ("-----------------------------------------------------");

                System.out.print("Sorting the array");
                loadingGenerator('.', 3, 400);
                polarize(array);
                System.out.println(arrayToString(array));

                System.out.println  ("-----------------------------------------------------");
            }
            else if(option == 16) /* Explode */{
                System.out.println  ("-----------------------------------------------------");

                int[] tinyArray = new int[4];

                creatingArrayMessage();
                fuelIntArray        (tinyArray, 1, 6);
                System.out.println  (arrayToString(tinyArray));
                System.out.print    ("Exploded array");
                loadingGenerator    ('.', 3, 400);
                System.out.println  ("\n" + arrayToString(explode(tinyArray)));

                System.out.println  ("-----------------------------------------------------");
            }
            else if(option == 17) /* Sort */{
                System.out.println  ("-----------------------------------------------------");

                System.out.print    ("Sorting the array");
                loadingGenerator    ('.', 3, 400);

                sort                (array);
                System.out.println  (arrayToString(array));

                System.out.println  ("-----------------------------------------------------");
            }
            else if(option == 18) /* Group */{
                System.out.println  ("-----------------------------------------------------");

                System.out.print    ("Type the groups length: ");
                int groupLength =   read.nextInt();

                System.out.print    ("Grouping the array");
                loadingGenerator    ('.', 3, 400);
                System.out.println  ("\n" + group(groupLength, array));

                System.out.println  ("-----------------------------------------------------");
            }
            else if(option == 19) /* Difference-A */{
                System.out.println  ("-----------------------------------------------------");

                creatingArrayMessage();
                int[] arrayA        = new int[arraySize];
                fuelIntArray        (arrayA, 0, 10);
                System.out.println  ("\nArray A:");
                System.out.println  (arrayToString(arrayA));

                creatingArrayMessage();
                int[] arrayB        = new int[arraySize];
                fuelIntArray        (arrayB, 0, 10);
                System.out.println  ("\nArray B:");
                System.out.println  (arrayToString(arrayB));

                System.out.println  ("\nElements that are in the array A but there are not in the array B:");
                System.out.println  (arrayToString(differenceA(arrayA, arrayB)));

                System.out.println  ("-----------------------------------------------------");
            }
            else if(option == 20){
                System.out.println("-----------------------------------------------------");

                System.out.println("Thanks for using the program, goodbye, have a nice day :)");
                System.out.println("END");

                System.out.println("-----------------------------------------------------");
            }

            if (option != 20){
                System.out.print("Continue? ");
                String[] opts = {"YES", "NO"};
                System.out.println(optionMenu(1, opts));
                option  = read.nextInt();
                option += 18;
            }
        } while (option != 20);

    }
}
