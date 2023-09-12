package org.studio.carcrash.cars;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.studio.carcrash.Grid.Direction;
import org.studio.carcrash.Grid.Grid;
import org.studio.carcrash.Grid.Position;

/**
 * Keyboard Controlled Car
 */
public class PlayerCar extends Car implements KeyboardHandler {

    private Keyboard keyboard;
    private int speed = 0;
    private final int MAX_SPEED = 3;

    /**
     * Constructs a new car
     *
     * @param grid    the grid where the car will play
     * @param carType the car type
     */
    public PlayerCar(Grid grid, CarType carType) {
        super(new Position(grid), carType);
        keyboard = new Keyboard(this);
        init();
    }

    /**
     * Initialize keyboard handlers
     */
    public void init() {
        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent faster = new KeyboardEvent();
        faster.setKey(KeyboardEvent.KEY_SPACE);
        faster.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent slower = new KeyboardEvent();
        slower.setKey(KeyboardEvent.KEY_SPACE);
        slower.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);


        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(faster);
        keyboard.addEventListener(slower);
    }

    /**
     * @see Car#move()
     */
    @Override
    public void move() {
        accelerate(getCurrentDirection(),speed);
    }

    /**
     * @see Car#accelerate(Direction, int)
     */
    @Override
    public void accelerate(Direction direction, int speed) {

        // Crashed cars can not accelerate
        if (isCrashed()) {
            return;
        }

        // Accelerate in the choosen direction
        super.setCurrentDirection(direction);
        for (int i = 0; i < speed; i++) {
            getPos().moveInDirection(direction, 1);
            if (getCollisionDetector().isUnSafe(getPos())) {
                crash();
                break;
            }
        }

    }

    /**
     * Handles key press events
     *
     * @param keyboardEvent the keyboard event
     */
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            speed = MAX_SPEED;
            return;
        }

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                setCurrentDirection(Direction.LEFT);
                break;
            case KeyboardEvent.KEY_RIGHT:
                setCurrentDirection(Direction.RIGHT);
                break;
            case KeyboardEvent.KEY_UP:
                setCurrentDirection(Direction.UP);
                break;
            case KeyboardEvent.KEY_DOWN:
                setCurrentDirection(Direction.DOWN);
                break;
        }

        if (speed == 0) {
            accelerate(getCurrentDirection(), 1);
        }
    }

    /**
     * Handles key release events
     *
     * @param keyboardEvent the keyboard event
     */
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            speed = 0;
        }
    }
}