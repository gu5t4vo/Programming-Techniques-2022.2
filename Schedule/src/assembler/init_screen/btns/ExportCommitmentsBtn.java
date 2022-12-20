package assembler.init_screen.btns;

import assembler.GUI;
import assembler.init_screen.InitScreen;

import java.awt.event.ActionEvent;

public class ExportCommitmentsBtn extends DefBtn {
    public ExportCommitmentsBtn(InitScreen initScreen) {
        super(initScreen);
        setText("Export Commitments");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        initScreen.setVisible(false);
        GUI.getExportScreen().setVisible(true);
    }
}
