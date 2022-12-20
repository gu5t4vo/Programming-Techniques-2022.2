package assembler.init_screen.btns;

import assembler.GUI;
import assembler.init_screen.InitScreen;
import assembler.new_commitment.DateScreen;
import presentation.Main;

import java.awt.event.ActionEvent;

public class NewCommitmentBtn extends DefBtn {

    private static DateScreen dateScreen;

    public NewCommitmentBtn(InitScreen initScreen) {
        super(initScreen);
        setText("New Commitment");
        addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        initScreen.setVisible(false);
        GUI.getNewCommitmentsScreen().setVisible(true);
        Main.gui.setVisible(false);
        dateScreen = new DateScreen();
    }

    public static DateScreen getDateScreen() {
        return dateScreen;
    }
}
