package org.studio.carcrash.cars;

import org.studio.carcrash.CollisionDetector;
import org.studio.carcrash.Grid.Direction;
import org.studio.carcrash.Grid.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;

public abstract class Car {

    /**
     * The position of the car on the grid
     */
    private Position pos;

    /**
     * The collision detector
     */
    private CollisionDetector collisionDetector;

    /**
     * The randomness of Car currentDirection change from 1 to 10
     */
    private int directionChangeLevel = 8;

    /**
     * The current currentDirection of the car
     */
    private Direction currentDirection;

    /**
     * The car crashed state
     */
    private boolean crashed = false; //have to check this because it doesn't have access modifier

    private CarType carType;
    /**
     * Constructs a new car
     *
     * @param pos     the initial car position
     * @param carType the car type
     */
    public Car(Position pos, CarType carType) {

        this.carType = carType;
        this.pos = pos;
        this.pos.setColor(this.carType.getColor());
        currentDirection = Direction.values()[(int) (Math.random() * Direction.values().length)];
    }

    public Position getPos() {
        return pos;
    }

    public boolean isCrashed() {
        return crashed;
    }

    public void crash() {

        this.crashed = true;
        this.pos.setColor(Color.RED);
    }

    public void unCrash() {

        this.crashed = false;
        this.pos.setColor(this.carType.getColor());
    }

    public void setDirectionChangeLevel(int directionChangeLevel) {
        this.directionChangeLevel = directionChangeLevel;
    }

    /**
     * Perform specific moving behaviour according to the car type
     */
    abstract public void move();

    /**
     * Chooses a new currentDirection for the car
     *
     * @return the new currentDirection
     */
    public Direction chooseDirection() {

        // Let's move in the same currentDirection by default
        Direction newDirection = currentDirection;

        // Sometimes, we want to change currentDirection...
        if (Math.random() > ((double) directionChangeLevel) / 10) {
            newDirection = Direction.values()[(int) (Math.random() * Direction.values().length)];

            // but we do not want to perform U turns..
            if (newDirection.isOpposite(currentDirection)) {
                return chooseDirection();
            }

        }

        return newDirection;

    }

    /**
     * Accelerates the car towards a specific direction,
     * as long as we have not bumped against the wall,
     * in which case we bounce back
     *
     * @param direction the currentDirection to accelerate
     */
    public void accelerate(Direction direction, int speed) {

        // Crashed cars can not accelerate
        if (isCrashed()) {
            return;
        }

        Direction newDirection = direction;

        // Perform a U turn if we have bumped against the wall
        if (pos.isEdge(direction) && newDirection.equals(currentDirection)) {
            newDirection = currentDirection.oppositeDirection();
        }

        // Accelerate in the choosen direction
        this.currentDirection = newDirection;
        for (int i = 0; i < speed; i++) {

            getPos().moveInDirection(newDirection, 1);
            if (collisionDetector.isUnSafe(getPos())) {
                crash();
                break;
            }
        }
    }


    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

    public CollisionDetector getCollisionDetector() {
        return collisionDetector;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }
}
