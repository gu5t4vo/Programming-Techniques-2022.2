package assembler.init_screen;

import assembler.init_screen.btns.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InitMenu extends JPanel {
    private static NewCommitmentBtn                 newCommitmentBtn;
    private static ShowAllRegisteredCommitmentsBtn  showAllRegisteredCommitmentsBtn;
    private static ShowCommitmentsByDateBtn         showCommitmentsByDateBtn;
    private static ImportCommitmentsBtn             importCommitmentsBtn;
    private static ExportCommitmentsBtn             exportCommitmentsBtn;

    public InitMenu(int vGap, InitScreen initScreen) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        newCommitmentBtn                = new NewCommitmentBtn(initScreen);
        showAllRegisteredCommitmentsBtn = new ShowAllRegisteredCommitmentsBtn(initScreen);
        showCommitmentsByDateBtn        = new ShowCommitmentsByDateBtn(initScreen);
        importCommitmentsBtn            = new ImportCommitmentsBtn(initScreen);
        exportCommitmentsBtn            = new ExportCommitmentsBtn(initScreen);

        addBtn(vGap);

    }

    private void addBtn(int vGap){
        ArrayList<JButton> buttons = new ArrayList<>();
        buttons.add(newCommitmentBtn);
        buttons.add(showAllRegisteredCommitmentsBtn);
        buttons.add(showCommitmentsByDateBtn);
        buttons.add(importCommitmentsBtn);
        buttons.add(exportCommitmentsBtn);

        for (JButton button: buttons) {
            add(button);
            add(Box.createRigidArea(new Dimension(0, vGap)));
        }
    }
}
