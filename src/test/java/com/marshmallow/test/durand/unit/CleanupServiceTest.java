package com.marshmallow.test.durand.unit;

import com.marshmallow.test.durand.mapper.CleanupMapper;
import com.marshmallow.test.durand.model.CleanupDto;
import com.marshmallow.test.durand.model.CleanupResponse;
import com.marshmallow.test.durand.service.CleanupService;
import com.marshmallow.test.durand.service.CleanupServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class CleanupServiceTest {

    CleanupService service = new CleanupServiceImpl();
    CleanupMapper mapper = new CleanupMapper();

    @Test
    public void test_service_One() {
        // Setup data
        Integer [] areaSize = {5,5};
        Integer [] startingPosition = {1,2};
        List<Integer[]> oilPatches = new ArrayList<>();
        Integer [] oilPatch1 = {1, 0};
        Integer [] oilPatch2 = {2, 2};
        Integer [] oilPatch3 = {2, 3};

        oilPatches.add(oilPatch1);
        oilPatches.add(oilPatch2);
        oilPatches.add(oilPatch3);

        String navigationInstruction = "NNESEESWNWW";
        CleanupDto dto = new CleanupDto(areaSize, startingPosition, oilPatches, navigationInstruction);

        CleanupResponse response = service.start(mapper.dtoToModel(dto));
        Assert.assertTrue(response.getFinalPosition().getX() == 1);
        Assert.assertTrue(response.getFinalPosition().getY() == 3);
        Assert.assertTrue(response.getOilPatchesCleaned() == 1);

    }

}
