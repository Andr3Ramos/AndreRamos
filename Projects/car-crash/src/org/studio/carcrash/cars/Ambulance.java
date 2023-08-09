package org.studio.carcrash.cars;

import org.studio.carcrash.Grid.Grid;
import org.studio.carcrash.Grid.Position;

public class Ambulance extends Car {

    private final static int SPEED = 2;

    public Ambulance(Grid grid) {
        super(new Position(grid), CarType.AMBULANCE);
    }

    @Override
    public void move() {
        accelerate(chooseDirection(), Ambulance.SPEED);
    }

}
