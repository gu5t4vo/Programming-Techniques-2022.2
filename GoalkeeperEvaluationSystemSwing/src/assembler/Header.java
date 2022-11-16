package assembler;

import components.DefPanel;

import javax.swing.*;
import java.awt.*;

public class Header extends DefPanel {

    protected JLabel projectName;
    protected JLabel authorName;
    protected JLabel ID;

    public Header(String projectName, String authorName, String ID){
        this.projectName    = new JLabel(projectName);
        this.authorName     = new JLabel(authorName);
        this.ID             = new JLabel(ID);

        formatProjectName();
        formatAuthorName();
        formatID();

        setLayout(new GridLayout(3, 1));

        add(this.projectName);
        add(this.authorName);
        add(this.ID);
        setVisible(true);
    }

    private void formatProjectName(){

        this.projectName.setFont(new Font("georgia", Font.BOLD, 30));
        this.projectName.setHorizontalAlignment(SwingConstants.CENTER);

    }

    private void formatAuthorName(){

        this.authorName.setFont(new Font("georgia", Font.BOLD, 20));
        this.authorName.setHorizontalAlignment(SwingConstants.CENTER);

    }

    private void formatID(){

        this.ID.setFont(new Font("georgia", Font.BOLD, 20));
        this.ID.setHorizontalAlignment(SwingConstants.CENTER);

    }

}
