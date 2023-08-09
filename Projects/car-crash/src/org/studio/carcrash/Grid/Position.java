package org.studio.carcrash.Grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Position {

    private Rectangle rectangle;
    private Grid grid;
    private int col;
    private int row;

    public Position(Grid grid) {

        this.grid = grid;
        setRandom();
        int x = grid.columnToX(getCol());
        int y = grid.rowToY(getRow());

        this.rectangle = new Rectangle(x, y, grid.getCellSize(), grid.getCellSize());

        show();
    }

    public void show() {
        this.rectangle.fill();
    }

    public void moveDown(int distance) {
        this.row = (this.row + distance < grid.getRows()) ? this.row + distance : grid.getRows() - 1;
    }

    public void moveUp(int distance) {
        this.row = (this.row - distance > 0) ? (this.row - distance) : 0;
    }

    public void moveLeft(int distance) {
        this.col = (this.col - distance > 0) ? (this.col - distance) : 0;
    }

    public void moveRight(int distance) {
        this.col = (this.col + distance < grid.getCols()) ? (this.col + distance) : (grid.getCols() - 1);
    }

    public void moveInDirection(Direction direction, int distance) {

        int initialCol = getCol();
        int initialRow = getRow();

        switch (direction) {

            case UP:
                moveUp(distance);
                break;
            case DOWN:
                moveDown(distance);
                break;
            case LEFT:
                moveLeft(distance);
                break;
            case RIGHT:
                moveRight(distance);
                break;
        }

        int dx = grid.columnToX(getCol()) - grid.columnToX(initialCol);
        int dy = grid.rowToY(getRow()) - grid.rowToY(initialRow);

        this.rectangle.translate(dx, dy);
    }

    /**
     * @param distance Forces a random movement for the cars. They'll move like little ants.
     */
    public void moveInRandomDirection(int distance) {

        int randomIndex = (int) (Math.random() * Direction.values().length);
        Direction dir = Direction.values()[randomIndex];

        moveInDirection(dir, distance);

    }

    public boolean isEdge(Direction direction) {

        return (direction == Direction.UP && row == 0) ||
                (direction == Direction.DOWN && row == grid.getRows() - 1) ||
                (direction == Direction.LEFT && col == 0) ||
                (direction == Direction.RIGHT && col == grid.getCols() - 1);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setColor(Color color) {
        this.rectangle.setColor(color);
    }

    public void setRandom() {
        row = (int) (Math.random() * grid.getRows());
        col = (int) (Math.random() * grid.getCols());
    }

    /**
     * Tests for position equality
     *
     * @param position The position to compare with
     * @return result of comparing positions
     */
    public boolean equals(Position position) {
        return col == position.getCol() &&
                row == position.getRow();
    }

    @Override
    public String toString() {
        return "Position{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
