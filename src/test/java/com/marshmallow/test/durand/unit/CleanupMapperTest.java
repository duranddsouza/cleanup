package com.marshmallow.test.durand.unit;

import com.marshmallow.test.durand.mapper.CleanupMapper;
import com.marshmallow.test.durand.model.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class CleanupMapperTest {

    CleanupMapper mapper = new CleanupMapper();

    @Test
    public void test_dtoToModelRequest() {
        // Setup data
        Integer [] areaSize = {4,4};
        Integer [] startingPosition = {2,2};
        List<Integer[]> oilPatches = new ArrayList<>();
        Integer [] oilPatch1 = {1, 2};
        oilPatches.add(oilPatch1);
        String navigationInstruction = "NN";
        CleanupDto dto = new CleanupDto(areaSize, startingPosition, oilPatches, navigationInstruction);
        Cleanup cleanup = mapper.dtoToModel(dto);

        Assert.assertTrue(cleanup.getAreaSize().getX() == 4);
        Assert.assertTrue(cleanup.getAreaSize().getX() == 4);
        Assert.assertTrue(cleanup.getStartingPosition().getX() == 2);
        Assert.assertTrue(cleanup.getStartingPosition().getX() == 2);
        Assert.assertTrue(cleanup.getNavigationInstructions().equals("NN"));
        Assert.assertTrue(cleanup.getOilPatches().size() == 1);
    }

    @Test
    public void test_modelToDto() {
        // Setup data
         Coordinates finalPosition = new Coordinates(2, 1);
         Integer oilPatchesCleaned = 1;
         CleanupResponseDto dto = mapper.modelToDto(new CleanupResponse(finalPosition, oilPatchesCleaned));
         Assert.assertTrue(dto.getFinalPosition()[0] == 2);
         Assert.assertTrue(dto.getFinalPosition()[1] == 1);
         Assert.assertTrue(dto.getOilPatchesCleaned() == 1);
    }
}
