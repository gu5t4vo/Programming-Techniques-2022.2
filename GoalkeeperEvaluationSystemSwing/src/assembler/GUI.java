package assembler;

import assembler.footer.Footer;
import components.DefFrame;
import goal.GameGoal;

import java.awt.*;

public class GUI extends DefFrame {

    public GUI(String title, int width, int height) {
        super(title, width, height);

        GameGoal        gameGoal        = new GameGoal(10, 18);

        Footer          footer          = gameGoal.getFooter();
        AssembledGoal   assembledGoal   = footer.getAssembledGoal();

        Header header = new Header(
                "Goalkeeper Evaluation System",
                "Gustavo Loiola Fonteles",
                "499342");


        setLayout(new BorderLayout());

        add(header, BorderLayout.NORTH);
        add(assembledGoal, BorderLayout.CENTER);
        //add(new AssembledGoal(gameGoal), BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);
        add(new Instructions(), BorderLayout.WEST);
        add(gameGoal.getCounterPanel(), BorderLayout.EAST);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }


}
