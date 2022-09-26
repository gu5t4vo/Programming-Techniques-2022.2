package list4.Q08;

import java.util.ArrayList;
import java.util.Arrays;

public class CellPhoneKeyboard {

    private final   ArrayList<String>   alphaNumKeyboard;

    public CellPhoneKeyboard(){
        alphaNumKeyboard = new ArrayList<>();

        String[] alphaKeyboard =
                {"+", "#", "ABC", "DEF", "GHI", "JKL",
                "MNO", "PQRS", "TUV", "WXYZ"};

        alphaNumKeyboard.addAll(Arrays.asList(alphaKeyboard).subList(0, 10));
    }

    public ArrayList<String> getAlphaNumKeyboard() {
        return alphaNumKeyboard;
    }
}
