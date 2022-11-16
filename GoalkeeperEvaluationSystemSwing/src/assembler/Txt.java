package assembler;

import javax.swing.*;
import java.awt.*;

public class Txt {

    public static JLabel formattedJLabel(String txt){

        Font georgiaInstructions = new Font("georgia", Font.PLAIN, 15);
        JLabel jLabel = new JLabel("<html><p style = \"width: 100px\">" + txt + "</p><br></html>");
        jLabel.setFont(georgiaInstructions);

        return jLabel;

    }

    public static String formattedTxt(String txt){

        return
                "<html><p style = \"width: 100px\">" + txt + "</p><br></html>";
    }
}
