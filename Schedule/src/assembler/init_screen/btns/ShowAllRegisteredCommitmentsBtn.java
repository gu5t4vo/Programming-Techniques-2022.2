package assembler.init_screen.btns;

import assembler.GUI;
import assembler.init_screen.InitScreen;

import java.awt.event.ActionEvent;

public class ShowAllRegisteredCommitmentsBtn extends DefBtn {
    public ShowAllRegisteredCommitmentsBtn(InitScreen initScreen) {
        super(initScreen);
        setText("Show All Registered Commitments");
        addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        initScreen.setVisible(false);
        GUI.getSARCScrollPane().setVisible(true);
    }
}
