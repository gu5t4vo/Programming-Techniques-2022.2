package list4.Q08;

import java.util.ArrayList;

public class CellPhoneCode {

    private final   CellPhoneKeyboard   cellPhoneKeyboard;
    private         String              cellPhoneCode;

    public CellPhoneCode(String cellPhoneNumber){
        setCellPhoneCode(cellPhoneNumber);
        cellPhoneKeyboard = new CellPhoneKeyboard();
    }

    public void setCellPhoneCode(String cellPhoneCode) {
        if (isPhoneNumber(cellPhoneCode))
            this.cellPhoneCode = cellPhoneCode;
    }

    private boolean isPhoneNumber(String cellPhoneNumber){

        return cellPhoneNumber.length() == 12;
    }

    public String decode(){
        String cellPhoneNumber = "";

        for (String c: cellPhoneCode.split("")) {
            if (isNumber(c)){
                cellPhoneNumber = cellPhoneNumber.concat(c);
            }
            else {
                ArrayList<String> keyboard = cellPhoneKeyboard.getAlphaNumKeyboard();

                for (int i = 0; i < keyboard.size(); i++) {
                    if (isIn(keyboard.get(i), c)){
                        cellPhoneNumber = cellPhoneNumber.concat(String.valueOf(i));
                    }
                }
            }
        }

        String formatCellPhoneNumber = "";

        for (int i = 0; i < cellPhoneNumber.length(); i++) {
            if (i == 0){
                formatCellPhoneNumber = formatCellPhoneNumber.concat("(");
            } else if (i == 3){
                formatCellPhoneNumber = formatCellPhoneNumber.concat(")");
            }
            formatCellPhoneNumber = formatCellPhoneNumber.concat(String.valueOf(cellPhoneNumber.charAt(i)));
        }

        return formatCellPhoneNumber;
    }

    private boolean isNumber(String target){

        String numbers = "1234567890";

        for (String number: numbers.split("")) {

            for (String c: target.split("")) {

                if (c.equals(number)){
                    return true;
                }
            }
        }
        return false;
    }

    /*
    * Need to make a method that reads a string and check if the elements from
    * other string are in that first string
    * */

    /**
     * Check if isIn is in msg
     * */
    public boolean isIn(String isIn, String msg){
        for (int i = 0; i < msg.length(); i++) {
            for (int j = 0; j < isIn.length(); j++) {
                if (msg.charAt(i) == isIn.charAt(j)){
                    return true;
                }
            }
        }

        return false;
    }
}
