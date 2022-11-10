package Q2.assembler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NameBtn extends JButton implements ActionListener {

    protected JLabel jLabel;

    public NameBtn(String txt, JLabel jLabel) {

        jLabel.setFont(new Font("georgia", Font.PLAIN, 20));
        jLabel.setHorizontalAlignment(CENTER);

        this.jLabel = jLabel;

        setText(txt);
        addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        jLabel.setText(getText());

    }
}
