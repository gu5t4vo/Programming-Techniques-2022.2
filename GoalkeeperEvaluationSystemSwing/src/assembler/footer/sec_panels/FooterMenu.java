package assembler.footer.sec_panels;

import assembler.AssembledGoal;
import assembler.footer.btns.ConfirmBtn;
import assembler.footer.btns.ResetBtn;
import assembler.footer.btns.StartBtn;
import components.DefPanel;
import goal.GameGoal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FooterMenu extends DefPanel implements ActionListener {

    protected StartZone     startZone;
    protected StartBtn      startBtn;
    protected ConfirmBtn    confirmBtn;
    protected ResetBtn      resetBtn;
    protected GameGoal      gameGoal;
    public FooterMenu(AssembledGoal assembledGoal){

        this.gameGoal = assembledGoal.getGameGoal();

        startZone   = gameGoal.getStartZone();
        startBtn    = startZone.getStartBtn();


        confirmBtn  = new ConfirmBtn
                (
                        "CONFIRM",
                        gameGoal,
                        gameGoal.getCounterPanel(),
                        startZone
                );
        confirmBtn.setEnabled(false);

        resetBtn    = new ResetBtn("   RESET   ", assembledGoal, startZone, confirmBtn);
        resetBtn.setEnabled(false);

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

        startBtn.addActionListener(this);

        setVisible(true);

    }

    public StartZone getStartZone() {
        return startZone;
    }

    public StartBtn getStartBtn() {
        return startBtn;
    }

    public ConfirmBtn getConfirmBtn() {
        return confirmBtn;
    }

    public ResetBtn getResetBtn() {
        return resetBtn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        startBtn.actionPerformed(e);

        confirmBtn.setEnabled(true);
        resetBtn.setEnabled(true);

        try {
            startZone.getCardLayout().next(startZone);
        } catch (NullPointerException exception){

            startZone = gameGoal.getStartZone();
            startZone.getCardLayout().next(startZone);

        }
    }
}
