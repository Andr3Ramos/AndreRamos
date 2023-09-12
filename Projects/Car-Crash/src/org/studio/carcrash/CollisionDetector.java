package org.studio.carcrash;

import org.studio.carcrash.Grid.Position;
import org.studio.carcrash.cars.Ambulance;
import org.studio.carcrash.cars.Car;

public class CollisionDetector {

    private Car[] cars;

    public CollisionDetector(Car[] cars) {
        this.cars = cars;
    }

    public boolean isUnSafe(Position pos) {

        for (Car c : cars) {

            if (c.getPos() != pos && c.getPos().equals(pos)) {
                return true;
            }

        }

        return false;
    }

    /**
     * Checks for collisions with specific car
     * Requires iterating the array once
     *
     * @param car
     */
    public void check(Car car) {

        for (Car ic : cars) {

            // No point in checking collisions with self
            if (ic == car) {
                continue;
            }

            if (ic.getPos().equals(car.getPos())) {

                // The ambulance fixes cars
                if(car instanceof Ambulance || ic instanceof Ambulance) {
                    ic.unCrash();
                    car.unCrash();
                    continue;
                }

                ic.crash();
                car.crash();
            }
        }
    }
}
