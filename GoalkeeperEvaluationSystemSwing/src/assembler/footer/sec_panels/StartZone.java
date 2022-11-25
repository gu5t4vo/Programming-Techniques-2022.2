package assembler.footer.sec_panels;

import assembler.AssembledGoal;
import assembler.footer.Turns;
import assembler.footer.btns.StartBtn;
import goal.GameGoal;

import javax.swing.*;
import java.awt.*;

public class StartZone extends JPanel {

    protected CardLayout    cardLayout;
    protected Turns         turn;
    protected JLabel        turnLabel;
    protected StartBtn      startBtn;

    public StartZone(GameGoal gameGoal) {

        cardLayout = new CardLayout();

        setLayout(cardLayout);

        turn = Turns.BLACK;

        turnLabel = new JLabel(this.turn.getName());
        turnLabel.setForeground(Color.BLACK);
        turnLabel.setFont(new Font("georgia", Font.BOLD, 30));
        turnLabel.setHorizontalAlignment(SwingConstants.CENTER);

        startBtn = new StartBtn(gameGoal);

        add(startBtn);
        add(turnLabel);

        setVisible(true);
    }

    public void passTurn(){

        Color color;

        if (turn == Turns.BLACK) {
            turn    = Turns.RED;
            color   = Color.RED;
        }
        else {
            turn    = Turns.BLACK;
            color   = Color.BLACK;
        }

        turnLabel.setText(turn.getName());
        turnLabel.setForeground(color);

    }

    public void resetTurns(){
        turn = Turns.BLACK;
        Color color = Color.BLACK;

        turnLabel.setText(turn.getName());
        turnLabel.setForeground(color);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public StartBtn getStartBtn() {
        return startBtn;
    }
}
