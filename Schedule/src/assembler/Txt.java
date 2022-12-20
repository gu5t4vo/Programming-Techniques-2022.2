package assembler;

import javax.swing.*;
import java.awt.*;

public class Txt {

    public static JLabel formattedJLabel(String txt, String font, int fontSize, int width){

        Font georgiaInstructions = new Font(font, Font.PLAIN, fontSize);
        JLabel jLabel = new JLabel("<html><p style = \"width: " + width + "px\" text-align: center;>"
                + txt + "</p><br></html>");
        jLabel.setFont(georgiaInstructions);

        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setVerticalAlignment(SwingConstants.CENTER);
        jLabel.setAlignmentY(Component.CENTER_ALIGNMENT);

        return jLabel;

    }

    public static String formattedTxt(String txt){

        return
                "<html><p style = \"width: 100px\">" + txt + "</p></html>";
    }

    public static String formattedTxt(String txt, int px){

        return
                String.format("<html><p style = \"width: %dpx\" text-align: center;>" + txt + "</p></html>", px);
    }
}
