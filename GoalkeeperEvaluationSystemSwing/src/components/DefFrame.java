package components;

import javax.swing.*;
import java.awt.*;

public abstract class DefFrame extends JFrame {

    public DefFrame(String title, int width, int height) throws HeadlessException {
        super(title);
        setSize(width, height);
        setVisible(true);
    }

}
