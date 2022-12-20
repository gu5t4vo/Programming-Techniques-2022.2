package assembler.new_commitment;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;

public class DateScreen extends JDialog {

    public static Date date;
    private static DateField dateField;
    private static SendBtn sendBtn;

    public DateScreen() {
        setLayout(new BorderLayout());
        setSize(500, 200);

        JLabel title = new JLabel("Create a New Commitment");
        title.setFont(new Font("georgia", Font.BOLD, 25));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel datePanel    = new JPanel();
        JLabel dateLabel    = new JLabel("DATE: ");
        dateField           = new DateField();
        sendBtn             = new SendBtn();

        datePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        datePanel.add(dateLabel);
        datePanel.add(dateField);

        add(title, BorderLayout.NORTH);
        add(datePanel, BorderLayout.CENTER);
        add(sendBtn, BorderLayout.SOUTH);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static DateField getDateField() {
        return dateField;
    }

    public static SendBtn getSendBtn() {
        return sendBtn;
    }
}
