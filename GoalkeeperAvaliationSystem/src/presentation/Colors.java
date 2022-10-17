package presentation;

public enum Colors {
    ANSI_RESET  ("\u001B[0m"),
    ANSI_BLACK  ("\u001B[30m"),
    ANSI_GREEN  ("\u001B[32m"),
    ANSI_YELLOW ("\u001B[33m"),
    ANSI_BLUE   ("\u001B[34m"),
    ANSI_PURPLE ("\u001B[35m"),
    ANSI_CYAN   ("\u001B[36m"),
    ANSI_WHITE  ("\u001B[37m");

    final String ansiEscapeCode;

    Colors(String ansiEscapeCode){
        this.ansiEscapeCode = ansiEscapeCode;
    }

    public String toString(){
        return ansiEscapeCode;
    }
}
