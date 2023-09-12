package org.studio.carcrash.cars;

import org.academiadecodigo.simplegraphics.graphics.Color;

public enum CarType {

    FIAT(Color.BLUE),
    MUSTANG(Color.GREEN),
    AMBULANCE(Color.YELLOW);

    private Color color;

    /**
     * Constructor of Car Types
     *
     * @param color The car type color
     */
    CarType(Color color) {
        this.color = color;
    }

    public Color getColor() {

        return this.color;

    }

}
