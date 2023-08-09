package org.studio.carcrash.cars;

import org.studio.carcrash.Grid.Grid;
import org.studio.carcrash.Grid.Position;

public class Mustang extends Car {

    public final static int SPEED = 3;

    public Mustang(Grid grid) {
        super(new Position(grid), CarType.MUSTANG);
    }

    @Override
    public void move() {
        accelerate(chooseDirection(), Mustang.SPEED);
    }
}
