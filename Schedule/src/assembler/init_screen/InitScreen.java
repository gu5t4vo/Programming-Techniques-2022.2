package assembler.init_screen;

import javax.swing.*;
import java.awt.*;

public class InitScreen extends JPanel {
    public InitScreen(int vGap) {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("<html>Appointment Schedule<br><br></html>");
        title.setFont(new Font("georgia", Font.BOLD, 30));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        add(title, BorderLayout.NORTH);
        add(new InitMenu(vGap, this), BorderLayout.CENTER);
    }
}
