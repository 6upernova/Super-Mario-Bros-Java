package factories;

import java.io.File;

public class Parser {
    protected File description;
    public Parser(int number) {
        description = new File("levels/level"+number);
    }

    public char getTypeEntity() {
        return 0;
    }

    public char getSubTypeEntity() {
        return 0;
    }

    public int getPositionXInWorld() {
        return 0;
    }
    public int getPositionYInWorld() {
        return 0;
    }

}