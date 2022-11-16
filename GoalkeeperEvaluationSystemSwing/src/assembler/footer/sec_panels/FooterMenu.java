package assembler.footer.sec_panels;

import assembler.AssembledGoal;
import assembler.footer.btns.ConfirmBtn;
import assembler.footer.btns.ResetBtn;
import components.DefPanel;
import goal.GameGoal;

import javax.swing.*;
import java.awt.*;

public class FooterMenu extends DefPanel {

    protected StartZone startZone;
    public FooterMenu(AssembledGoal assembledGoal){

        startZone = new StartZone(assembledGoal);

        ConfirmBtn confirmBtn  = new ConfirmBtn
                ("CONFIRM", assembledGoal.getGameGoal(),
                assembledGoal.getGameGoal().getCounterPanel());

        ResetBtn resetBtn    = new ResetBtn("   RESET   ", assembledGoal.getGameGoal());

        JLabel  finalMessage    = new JLabel("Thanks For Using The System :)");

        Font georgiaTitle       = new Font("georgia", Font.PLAIN, 30);
        Font georgiaSubTitle    = new Font("georgia", Font.PLAIN, 15);

        confirmBtn.setFont(georgiaTitle);
        confirmBtn.setHorizontalAlignment(SwingConstants.CENTER);

        resetBtn.setFont(georgiaTitle);
        resetBtn.setHorizontalAlignment(SwingConstants.CENTER);

        finalMessage.setFont(georgiaSubTitle);
        finalMessage.setHorizontalAlignment(SwingConstants.CENTER);


        BorderLayout borderLayout = new BorderLayout();

        setLayout(borderLayout);

        add(confirmBtn, BorderLayout.EAST);
        add(resetBtn, BorderLayout.WEST);
        add(finalMessage, BorderLayout.SOUTH);
        add(startZone, BorderLayout.CENTER);

        setVisible(true);

    }

    public StartZone getStartZone() {
        return startZone;
    }
}
