package assembler.footer;


public enum Turns {
    BLACK("BLACK"),
    RED("RED");

    final String name;

    Turns(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
