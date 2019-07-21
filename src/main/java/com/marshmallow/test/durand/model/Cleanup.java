package com.marshmallow.test.durand.model;

import java.util.Set;

public class Cleanup {

    private Coordinates areaSize;
    private Coordinates startingPosition;
    private Set<Coordinates> oilPatches;
    private String navigationInstructions;

    public Cleanup(Coordinates areaSize, Coordinates startingPosition, Set<Coordinates> oilPatches, String navigationInstructions) {
        this.areaSize = areaSize;
        this.startingPosition = startingPosition;
        this.oilPatches = oilPatches;
        this.navigationInstructions = navigationInstructions;
    }

    public Coordinates getAreaSize() {
        return areaSize;
    }


    public Coordinates getStartingPosition() {
        return startingPosition;
    }


    public Set<Coordinates> getOilPatches() {
        return oilPatches;
    }

    public String getNavigationInstructions() {
        return navigationInstructions;
    }

}
