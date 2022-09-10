package list3;

import static java.lang.Thread.sleep;

public class AestheticFunctions {

    public static void loadingGenerator(char loadingSymbol, int lSAmount, int breaks){
        for (int i = 0; i < lSAmount; i++) {
            System.out.print(loadingSymbol);
            try {
                sleep(breaks);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static String arrayToString(int[] array){
        String vector = "\n";
        for (Object element: array) {
            vector = vector.concat("[" + element + "]" + " ");
        }
        return vector;
    }

    public static String arrayToString(char[] array){
        String vector = "\n";
        for (Object element: array) {
            vector = vector.concat("[" + element + "]" + " ");
        }
        return vector;
    }

    public static String arrayToString(String[] array){
        String vector = "\n";
        for (Object element: array) {
            vector = vector.concat("[" + element + "]" + " ");
        }
        return vector;
    }

    public static void creatingArrayMessage(){
        System.out.print("Creating a new array");
        loadingGenerator('.', 3, 400);
    }

    public static String optionMenu(int width, String[] options){
        int     index   = 1;
        String  menu    = "\n\n";
        for (String option: options) {
            menu = menu.concat(String.format("[%d] %-40s\t", index, option));
            index++;

            if((index - 1) % width == 0){
                menu = menu.concat("\n");
            }
        }
        menu = menu.concat("\n\nYour Option: ");
        return menu;
    }
}
