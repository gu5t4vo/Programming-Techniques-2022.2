package goalkeper.components;

import javax.swing.*;
import java.util.Objects;

public enum MainPositionsIcons {

    RIGHT(new ImageIcon
            (Objects.requireNonNull(MainPositionsIcons.class.getResource("/images/RightHand.png")))),
    LEFT(new ImageIcon
            (Objects.requireNonNull(MainPositionsIcons.class.getResource("/images/LeftHand.png")))),
    INIT_POSITION(new ImageIcon
            (Objects.requireNonNull(MainPositionsIcons.class.getResource("/images/InitPosIcon.png"))));

    final ImageIcon icon;

    MainPositionsIcons(ImageIcon hand){
        this.icon = hand;
    }

    public ImageIcon getIcon() {
        return icon;
    }
}
