package assembler.init_screen.btns;

import assembler.GUI;
import assembler.init_screen.InitScreen;

import java.awt.event.ActionEvent;

public class ShowCommitmentsByDateBtn extends DefBtn {
    public ShowCommitmentsByDateBtn(InitScreen initScreen) {
        super(initScreen);
        setText("Show Commitments By Date");
        addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        initScreen.setVisible(false);
        GUI.getSCbDScreen().setVisible(true);
    }
}
