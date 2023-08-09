package org.studio.carcrash.cars;

import org.studio.carcrash.Grid.Grid;
import org.studio.carcrash.Grid.Position;

public class Fiat extends Car {

    private final static int MOVES_BEFORE_BREAK = 30;
    private final static int MOVES_AFTER_BREAK = 4;
    private final static int SPEED = 1;

    private int moves = 0;

    public Fiat(Grid grid) {
        super(new Position(grid), CarType.FIAT);
    }

    @Override
    public void move() {

        moves++;

        if (moves < MOVES_BEFORE_BREAK || moves % MOVES_AFTER_BREAK != 0) {
            accelerate(chooseDirection(), Fiat.SPEED);
        }

    }
}
