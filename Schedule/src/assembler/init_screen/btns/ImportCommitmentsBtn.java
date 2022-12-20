package assembler.init_screen.btns;

import assembler.import_commitments.CommitmentChooser;
import assembler.init_screen.InitScreen;
import business.Schedule;
import presentation.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ImportCommitmentsBtn extends DefBtn {
    public ImportCommitmentsBtn(InitScreen initScreen) {
        super(initScreen);
        setText("Import Commitments");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new CommitmentChooser();
        fileChooser.showOpenDialog(Main.gui);

    }
}
