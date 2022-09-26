package list4.Q09;

public class Pascal {

    public char symbol;
    public int  size;

    public Pascal(char symbol, int size){
        this.symbol = symbol;
        this.size   = size;
    }

    public String center(int spaces, String msg){
        String centerMsg    = "";
        int difference      = spaces - (msg.length());

        for (int i = 0; i < spaces; i++) {
            if (i != difference/2){
                centerMsg = centerMsg.concat(" ");


            } else {
                centerMsg = centerMsg.concat(msg);
            }
        }

        return centerMsg;
    }

    public String toString(){
        String  pascalTriangle      = "";
        int     elementsPerLine     = 1;
        int     elementsInLastLine  = 1 + 2 * (size - 1);

        for (int i = 0; i < size; i++) {

            String  matrix = "";

            for (int j = 0; j < elementsPerLine; j++) {
                matrix = matrix.concat(String.valueOf(symbol));
            }

            matrix          = center(elementsInLastLine, matrix);
            pascalTriangle  = pascalTriangle.concat(matrix + "\n");

            elementsPerLine += 2;
        }

        return pascalTriangle;
    }
}
