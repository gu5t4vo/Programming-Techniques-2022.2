package assembler.footer;

import assembler.AssembledGoal;
import assembler.footer.sec_panels.FooterMenu;
import goal.GameGoal;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Footer extends JPanel {

    protected FooterMenu    footerMenu;
    protected AssembledGoal assembledGoal;

    public Footer(GameGoal gameGoal) {

        assembledGoal   = new AssembledGoal(gameGoal);
        footerMenu      = new FooterMenu(assembledGoal);

        assembledGoal.setVisible(true);

        JPanel borderPanelStart = new JPanel();
        borderPanelStart.setLayout(new GridLayout(1, 3));

        JPanel borderPanelEnd = new JPanel();
        borderPanelEnd.setLayout(new GridLayout(1, 3));


        sortPanels(borderPanelStart, borderPanelEnd);


        setLayout(new BorderLayout());
        add(footerMenu, BorderLayout.CENTER);
        add(borderPanelStart, BorderLayout.LINE_START);
        add(borderPanelEnd, BorderLayout.LINE_END);

        setVisible(true);
    }

    private void sortPanels(JPanel borderPanelStart, JPanel borderPanelEnd){
        borderPanelEnd.add(new JLabel("               "));

        for (int i = 0; i < 4; i++) {
            borderPanelStart.add(new JLabel(
                    new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/Ball.png")))));

            borderPanelEnd.add(new JLabel(
                    new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/Ball.png")))));

        }

        borderPanelStart.add(new JLabel("               "));
    }

    public FooterMenu getFooterMenu() {
        return footerMenu;
    }

    public AssembledGoal getAssembledGoal() {
        return assembledGoal;
    }
}
