package com.marshmallow.test.durand.unit;

import com.marshmallow.test.durand.model.CleanupDto;
import com.marshmallow.test.durand.validator.CleanupValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class CleanupValidatorTest {

    CleanupValidator validator = new CleanupValidator();

    @Test
    public void test_invalidAreaSize() {

        // Setup data
        Integer [] areaSize = {1};
        Integer [] startingPosition = {2,2};
        List<Integer[]> oilPatches = new ArrayList<>();
        Integer [] oilPatch1 = {1, 2};
        oilPatches.add(oilPatch1);
        String navigationInstruction = "NN";
        CleanupDto dto = new CleanupDto(areaSize, startingPosition, oilPatches, navigationInstruction);

        String errorMessage = "";
        // Validate
        try {
            validator.validate(dto);
        } catch (IllegalStateException e) {
            errorMessage = e.getMessage();
        }

        Assert.assertTrue(errorMessage.contains("Area size has to have X and Y co ordinates"));
    }

    @Test
    public void test_invalidAreaSizeAndInstruction() {

        // Setup data
        Integer [] areaSize = {1};
        Integer [] startingPosition = {2,2};
        List<Integer[]> oilPatches = new ArrayList<>();
        Integer [] oilPatch1 = {1, 2};
        oilPatches.add(oilPatch1);
        String navigationInstruction = "NNXW";
        CleanupDto dto = new CleanupDto(areaSize, startingPosition, oilPatches, navigationInstruction);

        String errorMessage = "";
        // Validate
        try {
            validator.validate(dto);
        } catch (IllegalStateException e) {
            errorMessage = e.getMessage();
        }

        Assert.assertTrue(errorMessage.contains("Area size has to have X and Y co ordinates, Invalid navigationInstructions"));
    }

    @Test
    public void test_Valid() {

        // Setup data
        Integer [] areaSize = {4,4};
        Integer [] startingPosition = {2,2};
        List<Integer[]> oilPatches = new ArrayList<>();
        Integer [] oilPatch1 = {1, 2};
        oilPatches.add(oilPatch1);
        String navigationInstruction = "NN";
        CleanupDto dto = new CleanupDto(areaSize, startingPosition, oilPatches, navigationInstruction);

        String errorMessage = "";
        // Validate
        try {
            validator.validate(dto);
        } catch (IllegalStateException e) {
            errorMessage = e.getMessage();
        }

        Assert.assertTrue(errorMessage.length() == 0);
    }
}
