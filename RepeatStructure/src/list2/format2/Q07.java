package list2.format2;

public class Q07 {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        for (; i <= 100 && j <= 300; i++, j += 3){
            System.out.print(i + " - " + j + "\n");
        }
    }
}
