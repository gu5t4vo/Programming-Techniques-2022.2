package assembler;

import assembler.export_commitments.ExportScreen;
import assembler.init_screen.InitScreen;
import assembler.new_commitment.NewCommitmentsScreen;
import assembler.show_all_registered_commitments.SARCScrollPane;
import assembler.show_commitments_by_date.SCbDScreen;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private static InitScreen initScreen;
    private static NewCommitmentsScreen newCommitmentsScreen;
    private static SCbDScreen sCbDScreen;
    private static SARCScrollPane sarcScrollPane;
    private static ExportScreen exportScreen;

    public GUI() {
        setLayout(new CardLayout());
        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        initScreen = new InitScreen(10);
        newCommitmentsScreen = new NewCommitmentsScreen();
        sCbDScreen = new SCbDScreen();
        sarcScrollPane = new SARCScrollPane();
        exportScreen = new ExportScreen();

        add(initScreen);
        add(newCommitmentsScreen);
        add(sCbDScreen);
        add(sarcScrollPane);
        add(exportScreen);

        setVisible(true);
    }

    public static InitScreen getInitScreen() {
        return initScreen;
    }

    public static NewCommitmentsScreen getNewCommitmentsScreen() {
        return newCommitmentsScreen;
    }

    public static SCbDScreen getSCbDScreen() {
        return sCbDScreen;
    }

    public static SARCScrollPane getSARCScrollPane() {
        return sarcScrollPane;
    }

    public static ExportScreen getExportScreen() {
        return exportScreen;
    }
}
