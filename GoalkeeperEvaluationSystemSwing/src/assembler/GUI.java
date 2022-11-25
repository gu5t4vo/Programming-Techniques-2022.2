package assembler;

import assembler.counters.CounterPanel;
import assembler.footer.Footer;
import components.DefFrame;

import java.awt.*;

public class GUI extends DefFrame {

    public GUI(String title, int width, int height) {
        super(title, width, height);

        Assembler assembler = new Assembler();

        Header header               = assembler.header;
        AssembledGoal assembledGoal = assembler.assembledGoal;
        Footer footer               = assembler.footer;
        Instructions instructions   = assembler.instructions;
        CounterPanel counterPanel   = assembler.counterPanel;


        setLayout(new BorderLayout());

        add(header, BorderLayout.NORTH);
        add(assembledGoal, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);
        add(instructions, BorderLayout.WEST);
        add(counterPanel, BorderLayout.EAST);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }


}
