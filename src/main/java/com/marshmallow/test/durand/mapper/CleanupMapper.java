package com.marshmallow.test.durand.mapper;

import com.marshmallow.test.durand.model.*;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CleanupMapper {

    public Cleanup dtoToModel(CleanupDto dto) {
        Coordinates areaSize = new Coordinates(dto.getAreaSize()[0], dto.getAreaSize()[1]);
        Coordinates startingPosition = new Coordinates(dto.getStartingPosition()[0], dto.getStartingPosition()[1]);
        Set<Coordinates> oilPatches = new HashSet<>();
        for(Integer [] oilPatch : dto.getOilPatches()) {
            oilPatches.add(new Coordinates(oilPatch[0], oilPatch[1]));
        }
        return  new Cleanup(areaSize, startingPosition, oilPatches, dto.getNavigationInstructions().toUpperCase());
    }

    public CleanupResponseDto modelToDto(CleanupResponse cleanupResponse) {
        Integer [] finalPosition = new Integer[2];
        finalPosition[0] = cleanupResponse.getFinalPosition().getX();
        finalPosition[1] = cleanupResponse.getFinalPosition().getY();
        return new CleanupResponseDto(finalPosition, cleanupResponse.getOilPatchesCleaned());
    }
}
