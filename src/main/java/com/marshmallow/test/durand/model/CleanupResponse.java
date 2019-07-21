package com.marshmallow.test.durand.model;

public class CleanupResponse {

    private Coordinates finalPosition;
    private Integer oilPatchesCleaned;


    public CleanupResponse(Coordinates finalPosition, Integer oilPatchesCleaned) {
        this.finalPosition = finalPosition;
        this.oilPatchesCleaned = oilPatchesCleaned;
    }

    public Coordinates getFinalPosition() {
        return finalPosition;
    }

    public Integer getOilPatchesCleaned() {
        return oilPatchesCleaned;
    }

}
