package assembler;

import assembler.counters.CounterPanel;
import assembler.footer.Footer;
import goal.GameGoal;
import goalkeper.Goalkeeper;

public class Assembler {

    public AssembledGoal    assembledGoal;
    public CounterPanel     counterPanel;
    public Footer           footer;
    public Header           header;
    public Instructions     instructions;

    public Assembler(){

        GameGoal    gameGoal    = new GameGoal(10, 18);


        //assembledGoal   = footer.getFooterMenu().getStartBtn().getAssembledGoal();
        assembledGoal   = new AssembledGoal(gameGoal);
        footer          = new Footer(assembledGoal);
        counterPanel    = gameGoal.getCounterPanel();
        header          = new Header();
        instructions    = new Instructions();
    }

}
