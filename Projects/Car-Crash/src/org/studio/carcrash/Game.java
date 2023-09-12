package org.studio.carcrash;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.studio.carcrash.Grid.Grid;
import org.studio.carcrash.cars.*;

public class Game {

    /**
     * Graphical Car field
     */
    private Grid grid;

    /**
     * Container of Cars
     */
    private Car[] cars;

    /**
     * Animation delay
     */
    private int delay;

    /**
     * The collision detector
     */
    private CollisionDetector collisionDetector;

    /**
     * Number of cars to manufacture
     */
    private int manufacturedCars = 50;

    Game(int cols, int rows, int delay) {

        grid = new Grid(cols, rows);
        this.delay = delay;

    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        grid.init();

        cars = new Car[manufacturedCars + 2]; //needs to be + 1 to add the player car

        collisionDetector = new CollisionDetector(cars);

        //To add the car the player can control.
        Car playerCar = new PlayerCar(grid, CarType.MUSTANG);
        playerCar.getPos().setColor(Color.MAGENTA);
        playerCar.setCollisionDetector(collisionDetector);
        cars[cars.length - 1] = playerCar;

        Car ambulance = new Ambulance(grid);
        ambulance.setCollisionDetector(collisionDetector);
        cars[cars.length - 2] = ambulance;

        for (int i = 0; i < manufacturedCars; i++) {
            cars[i] = CarFactory.getNewCar(grid);
            cars[i].setCollisionDetector(collisionDetector);
        }
    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (true) {

            // Pause for a while
            Thread.sleep(delay);

            moveAllCars();
        }
    }

    /**
     * Moves all cars
     */
    public void moveAllCars() {

        for (Car c : cars) {
            c.move();
            collisionDetector.check(c);
        }
    }
}
