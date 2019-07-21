package com.marshmallow.test.durand.util;

import com.marshmallow.test.durand.model.Coordinates;

public class CleanupUtil {


    public static boolean isPositionInsideArea(Coordinates area, Coordinates positionToCheck) {
        return positionToCheck.getX() >= 0 && positionToCheck.getX() <= area.getX()
                && positionToCheck.getY() >= 0 && positionToCheck.getY() <= area.getY();
    }

    public static Coordinates getNextPosition(Coordinates currentPosition, char c) {
        if (c == 'S') {
            currentPosition.moveDown();
        } else if (c == 'N') {
            currentPosition.moveUp();
        } else if (c == 'W') {
            currentPosition.moveLeft();
        } else if (c == 'E') {
            currentPosition.moveRight();
        }
        return currentPosition;
    }
}
