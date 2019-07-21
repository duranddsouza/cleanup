package com.marshmallow.test.durand.validator;

import com.marshmallow.test.durand.model.CleanupDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CleanupValidator {

    public void validate(CleanupDto cleanupDto) {
        List<String> errors = new ArrayList<>();
        if (null == cleanupDto.getAreaSize() || cleanupDto.getAreaSize().length != 2) {
            errors.add("Area size has to have X and Y co ordinates");
        }
        if (null == cleanupDto.getStartingPosition() || cleanupDto.getStartingPosition().length != 2) {
            errors.add("Starting position has to have X and Y co ordinates");
        }
        for (Integer[] oilPatch : cleanupDto.getOilPatches()) {
            if (oilPatch.length != 2) {
                errors.add("Every oil patch has to have X and Y co ordinates");
            }
        }
        String instructions = cleanupDto.getNavigationInstructions().replaceAll("N","");
        instructions = instructions.replaceAll("S","");
        instructions = instructions.replaceAll("E","");
        instructions = instructions.replaceAll("W", "");

        if (instructions.length() > 0) {
            errors.add("Invalid navigationInstructions");
        }

        if (errors.size() > 0) {
            throw new IllegalStateException(errors.toString());
        }
    }
}
