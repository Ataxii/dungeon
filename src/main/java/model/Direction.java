package model;

import java.util.Random;

public class Direction {
    private String[] directions;
    private enum Enum {nord, sud, est, ouest};


    public Direction() {

        this.directions = new String[1];
        directions[0] = "North";
    }
}
