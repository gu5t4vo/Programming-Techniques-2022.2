package assembler.footer.btns;

import assembler.AssembledGoal;
import assembler.footer.sec_panels.StartZone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartBtn extends JButton implements ActionListener {

    protected StartZone     startZone;
    protected AssembledGoal assembledGoal;

    public StartBtn(String text, StartZone startZone, AssembledGoal assembledGoal) {
        super(text);
        this.startZone      = startZone;
        this.assembledGoal  = assembledGoal;

        setFont(new Font("georgia", Font.BOLD, 25));
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        startZone.getCardLayout().next(startZone);
        assembledGoal.getGameGoal().getCounterPanel().getP1().setBackground(Color.ORANGE);

    }
}
