package com.marshmallow.test.durand.model;

import java.util.List;
import java.util.Arrays;

public class CleanupDto {

    Integer [] areaSize;
    Integer [] startingPosition;
    List < Integer[]> oilPatches;
    String navigationInstructions;


    public CleanupDto(Integer[] areaSize, Integer[] startingPosition, List<Integer[]> oilPatches, String navigationInstructions) {
        this.areaSize = areaSize;
        this.startingPosition = startingPosition;
        this.oilPatches = oilPatches;
        this.navigationInstructions = navigationInstructions;
    }

    public Integer[] getAreaSize() {
        return areaSize;
    }

    public Integer[] getStartingPosition() {
        return startingPosition;
    }

    public List<Integer[]> getOilPatches() {
        return oilPatches;
    }

    public String getNavigationInstructions() {
        return navigationInstructions;
    }

    @Override
    public String toString() {
        return "CleanupDto{" +
                "areaSize=" + Arrays.toString(areaSize) +
                ", startingPosition=" + Arrays.toString(startingPosition) +
                ", oilPatches=" + oilPatches +
                ", navigationInstructions='" + navigationInstructions + '\'' +
                '}';
    }
}
