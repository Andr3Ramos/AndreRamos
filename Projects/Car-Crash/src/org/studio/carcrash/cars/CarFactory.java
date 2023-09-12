package org.studio.carcrash.cars;

import org.studio.carcrash.Grid.Grid;

public class CarFactory {

    public static Car getNewCar(Grid grid) {

        int random = (int) (Math.random() * CarType.values().length);
        CarType carType = CarType.values()[random];
        Car car;

        switch (carType) {
            case FIAT:
                car = new Fiat(grid);
                break;
            case MUSTANG:
                car = new Mustang(grid);
                break;
            default:
                car = new Fiat(grid);
        }

        return car;
    }
}
