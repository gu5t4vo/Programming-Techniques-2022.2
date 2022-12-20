package assembler.init_screen.btns;

import assembler.init_screen.InitScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class DefBtn extends JButton implements ActionListener {
    protected static InitScreen initScreen;

    public DefBtn(InitScreen initScreen) {

        DefBtn.initScreen = initScreen;

        setSize(new Dimension(250, 30));
        setMaximumSize(getSize());
        setHorizontalTextPosition(CENTER);
        setAlignmentX(CENTER_ALIGNMENT);
    }
}
