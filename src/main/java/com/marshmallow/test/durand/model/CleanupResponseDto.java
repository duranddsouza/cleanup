package com.marshmallow.test.durand.model;

public class CleanupResponseDto {

    private Integer [] finalPosition;
    private Integer oilPatchesCleaned;

    public CleanupResponseDto() {}

    public CleanupResponseDto(Integer[] finalPosition, Integer oilPatchesCleaned) {
        this.finalPosition = finalPosition;
        this.oilPatchesCleaned = oilPatchesCleaned;
    }

    public Integer[] getFinalPosition() {
        return finalPosition;
    }

    public Integer getOilPatchesCleaned() {
        return oilPatchesCleaned;
    }

}
